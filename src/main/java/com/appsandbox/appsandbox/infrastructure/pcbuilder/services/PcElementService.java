package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithValues;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutConstraintsAndSpecs;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementMapper;

@Service
public class PcElementService {

    Logger log = LoggerFactory.getLogger(PcElementService.class);

    @Autowired
    private PcElementRepository pcElementRepository;
    @Autowired
    private PcElementMapper pcElementMapper;

    public List<PcElement> getAllPcElement() {
        List<PcElementEntity> pcElementEntities = pcElementRepository.findAll();
        return pcElementEntities.stream()
                .map(entity -> pcElementMapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

    public List<PcElement> getPcElementsRegardingConstraints(String strPcBuildElementIds) {
        if (strPcBuildElementIds == null || strPcBuildElementIds == "") {
            log.info("No PC element in current build");
            return getAllPcElement();
        }

        // Retrieve PcElement already selected in order to get constraints from selected
        List<Integer> pcBuildElementIds = Arrays.stream(strPcBuildElementIds.trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<PcElement> pcBuildElements = pcElementRepository.findAllByIdIn(pcBuildElementIds)
                .stream()
                .map(entity -> pcElementMapper.entityToDto(entity))
                .collect(Collectors.toList());

        // Retrieve PcConstraints of current PC build
        List<PcConstraintWithValues> pcBuildConstraints = getPcConstraintsfromPcElements(pcBuildElements);

        // Retrieve all PcElement entities
        return pcElementRepository.findAll().stream()
                .map(entity -> pcElementMapper.entityToDto(entity))
                .filter(pcElement -> canBeAddedRegardingConstraints(pcElement, pcBuildConstraints))
                .collect(Collectors.toList());
    }

    public PcElement getPcElement(int elementId) {
        PcElementEntity pcElementEntity = pcElementRepository.findById(elementId)
                .orElseThrow(() -> new NoDataFoundException("PC element not found for id: " + elementId));
        return pcElementMapper.entityToDto(pcElementEntity);
    }

    @Transactional
    public PcElement savePcElement(
            @NonNull PcElement newPcElement) {
        PcElementEntity pcElementEntity = pcElementMapper.dtoToEntity(newPcElement);
        pcElementRepository.save(pcElementEntity);
        return newPcElement;
    }

    @Transactional
    public PcElement updatePcElement(@NonNull PcElement pcElement) {
        int pcElementId = pcElement.getId();
        pcElementRepository.findById(pcElementId)
                .orElseThrow(() -> new NoDataFoundException("PC element not found for id: " + pcElementId));
        return savePcElement(pcElement);
    }

    @Transactional
    public PcElementWithoutConstraintsAndSpecs deletePcElement(int pcElementId) {
        PcElementEntity pcElementEntity = pcElementRepository.findById(pcElementId)
                .orElseThrow(() -> new NoDataFoundException("PC element not found for id: " + pcElementId));
        pcElementRepository.delete(pcElementEntity);
        return pcElementMapper.entityToDtoWithoutConstraintsAndSpecs(pcElementEntity);
    }

    private List<PcConstraintWithValues> getPcConstraintsfromPcElements(List<PcElement> pcElements) {
        return pcElements.stream()
                // applatit le stream de liste de contraintes de liste d'éléments en une seule
                // liste de contraintes
                .flatMap(pcElement -> pcElement.getConstraints().stream())
                // applique un groupBy (ici le code de la PcConstraint) pour créer Map<String,
                // List<PcConstraint>>
                .collect(Collectors.groupingBy(pcElementConstraint -> pcElementConstraint.getId()))
                // créer Stream<List<PcConstraint>>
                .values().stream()
                // re-map le stream d'une liste par le stream d'une autre liste
                .map(constraintGroup -> {
                    // Utilisation de LinkedHashSet pour maintenir l'ordre et éviter les doublons
                    LinkedHashSet<String> mergedValues = constraintGroup.stream()
                            .flatMap(constraint -> constraint.getValues().stream())
                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    // Création d'une nouvelle PcConstraint avec les valeurs fusionnées
                    PcConstraintWithValues mergedConstraint = constraintGroup.get(0);
                    return new PcConstraintWithValues(
                            mergedConstraint.getId(),
                            mergedConstraint.getName(),
                            mergedConstraint.getCode(),
                            mergedConstraint.getType(),
                            new ArrayList<>(mergedValues));
                })
                .collect(Collectors.toList());
    }

    // public boolean canBeAddedRegardingConstraints(PcElement pcElement,
    // List<PcConstraint> pcBuildConstraints) {
    // boolean canBeAdded = true;
    // List<PcConstraint> constraintsOfPcElement = pcElement.getConstraints();
    // Map<String, PcConstraint> buildConstraintMap = pcBuildConstraints.stream()
    // .collect(Collectors.toMap(PcConstraint::getCode, constraint -> constraint));
    // log.info("***************");
    // log.info("Test if {} {} can be added to PC build", pcElement.getBrand(),
    // pcElement.getModel());
    // for (PcConstraint constraint : constraintsOfPcElement) {
    // PcConstraint pcBuildConstraintToManage =
    // buildConstraintMap.get(constraint.getCode());

    // if (pcBuildConstraintToManage != null) {
    // boolean canBeAddedCurrentConstraint = false;
    // switch (pcBuildConstraintToManage.getType()) {
    // case SAME:
    // log.info("PC build constraint '{}' is SAME type",
    // pcBuildConstraintToManage.getName());
    // for (String valueFromBuildToManage : pcBuildConstraintToManage.getValue()) {
    // for (String value : constraint.getValue()) {
    // log.info("Testing : {} = {} ?", valueFromBuildToManage, value);
    // if (valueFromBuildToManage.equals(value)) {
    // log.info("++ values match so PC element can be retrieved");
    // // return true;
    // canBeAddedCurrentConstraint = true;
    // }
    // }
    // }
    // // return false;
    // break;
    // case MAX:
    // canBeAddedCurrentConstraint = Float
    // .parseFloat(pcBuildConstraintToManage.getValue().get(0)) >= Float
    // .parseFloat(constraint.getValue().get(0));
    // // return maxTest;
    // break;
    // case CAPACITY:
    // // Gestion du cas CAPACITY
    // break;
    // case LIMIT:
    // canBeAddedCurrentConstraint = Float
    // .parseFloat(pcBuildConstraintToManage.getValue().get(0)) <= Float
    // .parseFloat(constraint.getValue().get(0));
    // // return limitTest;
    // break;
    // }
    // canBeAdded = canBeAdded && canBeAddedCurrentConstraint;
    // if (canBeAdded == false) {
    // log.info("PC element is discarded because constraint doesn't match !!!");
    // return false;
    // } else {
    // log.info("PC element is potentially retrieved");
    // }
    // }
    // }
    // log.info("PC element is retrieved");
    // log.info("***************");
    // return canBeAdded; // return true;
    // }

    private boolean canBeAddedRegardingConstraints(PcElement pcElement,
            List<PcConstraintWithValues> pcBuildConstraints) {
        log.info("***************");
        log.info("Test if {} {} can be added to PC build", pcElement.getBrand(), pcElement.getModel());

        boolean canBeAdded = pcElement.getConstraints().stream().allMatch(constraint -> {
            PcConstraintWithValues pcBuildConstraintToManage = pcBuildConstraints.stream()
                    .filter(buildConstraint -> buildConstraint.getCode().equals(constraint.getCode()))
                    .findFirst()
                    .orElse(null);

            if (pcBuildConstraintToManage == null) {
                return true; // Contrainte non présente, donc valide
            }
            log.info("PC build constraint '{}' is {} type", pcBuildConstraintToManage.getName(),
                    pcBuildConstraintToManage.getType());
            switch (pcBuildConstraintToManage.getType()) {
                case SAME:
                    return pcBuildConstraintToManage.getValues().stream()
                            .anyMatch(valueFromBuildToManage -> {
                                log.info("Comparing from build: {} to {}", valueFromBuildToManage,
                                        constraint.getValues());
                                return constraint.getValues().contains(valueFromBuildToManage);
                            });
                case MAX:
                    return Float.parseFloat(pcBuildConstraintToManage.getValues().get(0)) >= Float
                            .parseFloat(constraint.getValues().get(0));
                case CAPACITY:
                    // Gestion du cas CAPACITY
                    return true;
                case LIMIT:
                    return Float.parseFloat(pcBuildConstraintToManage.getValues().get(0)) <= Float
                            .parseFloat(constraint.getValues().get(0));
            }

            return false; // Au cas où une nouvelle valeur de type serait ajoutée
        });

        log.info("PC element is {}retrieved", canBeAdded ? "" : "not ");
        log.info("***************");
        return canBeAdded;
    }

}
