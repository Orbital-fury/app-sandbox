package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;

@Service
public class PcElementService {

    Logger log = LoggerFactory.getLogger(PcElementService.class);

    @Autowired
    private PcElementRepository pcElementRepository;
    @Autowired
    private PcElementConstraintService pcElementConstraintService;
    @Autowired
    private PcElementSpecificationService pcElementSpecificationService;

    public List<PcElement> getAllPcElement() {
        List<PcElementEntity> pcElementEntities = pcElementRepository.findAll();
        List<PcElement> pcElements = new ArrayList<>();
        pcElementEntities.forEach(pcElementEntity -> pcElements.add(pcElementDtoFromEntity(pcElementEntity)));
        return pcElements;
    }

    public List<PcElement> getPcElementsWithConstraints(String strSelectedPcElementIds) {
        // Retrieve all PcElement entities
        List<PcElementEntity> pcElementEntities = pcElementRepository.findAll();

        // Retrieve PcElement already selected in order to get constraints from selected
        List<Integer> selectedPcElementIds = Arrays.stream(strSelectedPcElementIds.trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<PcElement> selectedPcElements = new ArrayList<>();
        pcElementRepository.findAllByIdIn(selectedPcElementIds).forEach(pcElementEntity -> {
            selectedPcElements.add(pcElementDtoFromEntity(pcElementEntity));
        });

        // Retrieve PcConstraints of current PC build
        List<PcConstraint> pcBuildConstraints = getPcConstraintsfromPcElements(selectedPcElements);

        List<PcElement> pcElements = new ArrayList<>();
        pcElementEntities.forEach(pcElementEntity -> {
            PcElement pcElement = pcElementDtoFromEntity(pcElementEntity);
            if (canBeAddedRegardingConstraints(pcElement, pcBuildConstraints)) {
                pcElements.add(pcElement);
            }
        });
        return pcElements;
    }

    private List<PcConstraint> getPcConstraintsfromPcElements(List<PcElement> selectedPcElements) {
        return selectedPcElements.stream()
                // applatit le stream de liste de contraintes de liste d'éléments en une seule
                // liste de contraintes
                .flatMap(selectedPcElement -> selectedPcElement.getConstraints().stream())
                // applique un groupBy (ici le code de la PcConstraint) pour créer Map<String,
                // List<PcConstraint>>
                .collect(Collectors.groupingBy(PcConstraint::getCode))
                // créer Stream<List<PcConstraint>>
                .values().stream()
                // re-map le stream d'une liste par le stream d'une autre liste
                .map(constraintGroup -> {
                    // Utilisation de LinkedHashSet pour maintenir l'ordre et éviter les doublons
                    LinkedHashSet<String> mergedValues = constraintGroup.stream()
                            .flatMap(constraint -> constraint.getValue().stream())
                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    // Création d'une nouvelle PcConstraint avec les valeurs fusionnées
                    PcConstraint mergedConstraint = constraintGroup.get(0); // Prend n'importe quel élément du groupe
                    mergedConstraint.setValue(new ArrayList<>(mergedValues));
                    return mergedConstraint;
                })
                .collect(Collectors.toList());
    }

    public PcElement getPcElement(int elementId) {
        Optional<PcElementEntity> optPcElementEntity = pcElementRepository.findById(elementId);
        if (optPcElementEntity.isPresent()) {
            PcElementEntity pcElementEntity = optPcElementEntity.get();
            return pcElementDtoFromEntity(pcElementEntity);
        } else {
            throw new NoDataFoundException("PC element with id=" + elementId + " not found!");
        }

    }

    private PcElement pcElementDtoFromEntity(PcElementEntity pcElementEntity) {
        int elementId = pcElementEntity.getId();
        List<PcConstraint> pcConstraints = pcElementConstraintService.getElementConstraints(elementId);
        List<PcSpecification> pcSpecifications = pcElementSpecificationService.getElementSpecifications(elementId);
        return pcElementEntity.toDto(pcConstraints, pcSpecifications);
    }

    public boolean canBeAddedRegardingConstraints(PcElement pcElement, List<PcConstraint> pcBuildConstraints) {
        List<PcConstraint> constraintsOfPcElement = pcElement.getConstraints();
        Map<String, PcConstraint> buildConstraintMap = pcBuildConstraints.stream()
                .collect(Collectors.toMap(PcConstraint::getCode, constraint -> constraint));
        log.info("***************");
        log.info("Test if {} {} can be added to PC build", pcElement.getBrand(), pcElement.getModel());
        for (PcConstraint constraint : constraintsOfPcElement) {
            PcConstraint pcBuildConstraintToManage = buildConstraintMap.get(constraint.getCode());

            if (pcBuildConstraintToManage != null) {
                switch (pcBuildConstraintToManage.getType()) {
                    case SAME:
                        log.info("PC build constraint '{}' is SAME type", pcBuildConstraintToManage.getName());
                        for (String valueFromBuildToManage : pcBuildConstraintToManage.getValue()) {
                            for (String value : constraint.getValue()) {
                                log.info("Testing : {} = {} ?", valueFromBuildToManage, value);
                                if (valueFromBuildToManage.equals(value)) {
                                    log.info("++ values match so PC element will be retrieved");
                                    return true;
                                }
                            }
                        }
                        log.info("-- values don't match so PC element is excluded");
                        return false;
                    case MAX:
                        return Float.parseFloat(pcBuildConstraintToManage.getValue().get(0)) >= Float
                                .parseFloat(constraint.getValue().get(0));
                    case CAPACITY:
                        // Gestion du cas CAPACITY
                        break;
                    case LIMIT:
                        return Float.parseFloat(pcBuildConstraintToManage.getValue().get(0)) <= Float
                                .parseFloat(constraint.getValue().get(0));
                }
            }
        }
        log.info("***************");

        // Si aucune contrainte n'a été rencontrée, retournez false
        return true;
    }

}
