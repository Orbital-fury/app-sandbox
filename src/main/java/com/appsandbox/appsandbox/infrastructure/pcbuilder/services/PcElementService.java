package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
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
        log.info("************************");
        pcElementEntities.forEach(pcElementEntity -> {
            PcElement pcElement = pcElementDtoFromEntity(pcElementEntity);
            if (pcElement.canBeAddedRegardingConstraints(pcBuildConstraints)) {
                pcElements.add(pcElement);
            }
        });
        log.info("************************");
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

    
}
