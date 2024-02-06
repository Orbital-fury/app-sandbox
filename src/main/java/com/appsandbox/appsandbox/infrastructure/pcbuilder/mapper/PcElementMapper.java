package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementBasis;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementSpecificationRepository;

@Service
public class PcElementMapper {

        @Autowired
        private PcElementConstraintRepository pcElementConstraintRepository;
        @Autowired
        private PcElementSpecificationRepository pcElementSpecificationRepository;

        public PcElementEntity dtoToEntity(PcElementBasis pcElementBasis) {
                int pcElementId = pcElementBasis.getId();
                List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository
                                .findByElementId(pcElementId);
                List<PcElementSpecificationEntity> elementSpecificationEntities = pcElementSpecificationRepository
                                .findByElementId(pcElementId);
                return new PcElementEntity(
                                pcElementId,
                                pcElementBasis.getBrand(),
                                pcElementBasis.getModel(),
                                pcElementBasis.getPrice(),
                                pcElementBasis.getImg(),
                                pcElementBasis.getType(),
                                elementConstraintEntities,
                                elementSpecificationEntities);
        }

        public PcElement entityToDto(PcElementEntity pcElementEntity, List<PcElementConstraint> pcElementConstraints,
                        List<PcElementSpecification> pcElementSpecifications) {
                return new PcElement(pcElementEntity.getId(),
                                pcElementEntity.getBrand(),
                                pcElementEntity.getModel(),
                                pcElementEntity.getPrice(),
                                pcElementEntity.getImg(),
                                pcElementEntity.getType(),
                                pcElementConstraints,
                                pcElementSpecifications);
        }

        private List<PcElementConstraint> getElementConstraints(int elementId) {
                List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository
                                .findByElementId(elementId);

                HashMap<PcConstraintEntity, List<String>> valuesByConstraints = new HashMap<>();

                elementConstraintEntities.forEach(elementConstraintEntity -> {
                        valuesByConstraints
                                        .computeIfAbsent(elementConstraintEntity.getPcConstraint(),
                                                        pcConstraintEntity -> new ArrayList<>())
                                        .add(elementConstraintEntity.getValue());
                });

                return valuesByConstraints.entrySet().stream()
                                .map(entry -> {
                                        PcConstraintEntity pcConstraintEntity = entry.getKey();
                                        List<String> values = entry.getValue();
                                        if (pcConstraintEntity == null) {
                                                throw new RuntimeException(
                                                                "Error ! Not possible to retrieve constraint for id=null");
                                        }
                                        if ((pcConstraintEntity.getType() == PcConstraintType.LIMIT
                                                        || pcConstraintEntity.getType() == PcConstraintType.MAX)
                                                        && values.size() != 1) {
                                                throw new RuntimeException(
                                                                "A type's constraint: MAX or LIMIT has a size different from 1");
                                        }
                                        return new PcElementConstraint(pcConstraintEntity.getId(),
                                                        pcConstraintEntity.getName(), pcConstraintEntity.getCode(),
                                                        pcConstraintEntity.getType(),
                                                        values);
                                })
                                .collect(Collectors.toList());
        }

        private List<PcElementSpecification> getElementSpecifications(int elementId) {
                List<PcElementSpecificationEntity> elementSpecificationEntities = pcElementSpecificationRepository
                                .findByElementId(elementId);

                HashMap<PcSpecificationEntity, List<String>> valuesBySpecifications = new HashMap<>();

                elementSpecificationEntities.forEach(elementSpecificationEntity -> {
                        valuesBySpecifications
                                        .computeIfAbsent(elementSpecificationEntity.getPcSpecification(),
                                                        pcSpecificationEntity -> new ArrayList<>())
                                        .add(elementSpecificationEntity.getValue());
                });

                return valuesBySpecifications.keySet().stream()
                                .map(pcSpecificationEntity -> {
                                        if (pcSpecificationEntity == null) {
                                                throw new RuntimeException(
                                                                "Error ! Not possible to retrieve specification for id=null");
                                        }
                                        return new PcElementSpecification(pcSpecificationEntity.getId(),
                                                        pcSpecificationEntity.getName(),
                                                        pcSpecificationEntity.getCode(),
                                                        valuesBySpecifications.get(pcSpecificationEntity));
                                })
                                .collect(Collectors.toList());
        }

        public PcElement entityToDto(PcElementEntity pcElementEntity) {
                List<PcElementConstraint> pcElementConstraints = getElementConstraints(pcElementEntity.getId());
                List<PcElementSpecification> pcElementSpecifications = getElementSpecifications(
                                pcElementEntity.getId());

                return new PcElement(pcElementEntity.getId(),
                                pcElementEntity.getBrand(),
                                pcElementEntity.getModel(),
                                pcElementEntity.getPrice(),
                                pcElementEntity.getImg(),
                                pcElementEntity.getType(),
                                pcElementConstraints,
                                pcElementSpecifications);
        }

        public PcElementBasis entityToDtoBasis(PcElementEntity pcElementEntity) {
                return new PcElementBasis(
                                pcElementEntity.getId(),
                                pcElementEntity.getBrand(),
                                pcElementEntity.getModel(),
                                pcElementEntity.getPrice(),
                                pcElementEntity.getImg(),
                                pcElementEntity.getType());
        }

}
