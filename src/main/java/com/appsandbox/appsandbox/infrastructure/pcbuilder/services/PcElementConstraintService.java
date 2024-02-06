package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementBasis;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraintValues;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementMapper;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;
    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementRepository pcElementRepository;
    @Autowired
    private PcElementMapper pcElementMapper;

    public List<PcElementConstraint> getElementConstraints(int elementId) {
        List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository.findByElementId(elementId);

        HashMap<Integer, List<String>> valuesByConstraints = new HashMap<>();

        elementConstraintEntities.forEach(elementConstraintEntity -> {
            // List<String> values = valuesByConstraints.getOrDefault(elementConstraint.getConstraintId(),
            //         new ArrayList<>());
            // values.add(elementConstraint.getValue());
            // valuesByConstraints.put(elementConstraint.getConstraintId(), values);
            valuesByConstraints
                    .computeIfAbsent(elementConstraintEntity.getConstraintId(),
                            k -> new ArrayList<>())
                    .add(elementConstraintEntity.getValue());
        });

        return valuesByConstraints.keySet().stream()
                .map(key -> {
                    if (key == null) {
                        throw new RuntimeException("Error ! Not possible to retrieve constraint for id=null");
                    }
                    PcConstraintEntity pcConstraintEntity = pcConstraintRepository.findById(key)
                            .orElseThrow(() -> new RuntimeException("PcConstraintEntity not found for key: " + key));
                    List<String> constraintValues = valuesByConstraints.get(pcConstraintEntity.getId());
                    if ((pcConstraintEntity.getType() == PcConstraintType.LIMIT
                            || pcConstraintEntity.getType() == PcConstraintType.MAX)
                            && constraintValues.size() != 1) {
                        throw new RuntimeException("A type's constraint: MAX or LIMIT has a size different from 1");
                    }
                    return new PcElementConstraint(pcConstraintEntity.getId(), pcConstraintEntity.getName(), pcConstraintEntity.getCode(),
                            pcConstraintEntity.getType(),
                            constraintValues);
                })
                .collect(Collectors.toList());
    }

    public List<PcElementConstraintValues> getPcElementAndConstraintValues(int constraintId) {
        pcConstraintRepository.findById(constraintId)
                .orElseThrow(() -> new NoDataFoundException(
                        "PC constraint not found for id: " + constraintId));
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElementConstraintRepository
                .findByConstraintId(constraintId);

        Map<PcElementBasis, List<String>> resultMap = new HashMap<>();
        for (PcElementConstraintEntity pcElementConstraintEntity : pcElementConstraintEntities) {
                int elementId = pcElementConstraintEntity.getElementId();
                PcElementEntity pcElementEntity = pcElementRepository.findById(elementId)
                        .orElseThrow(() -> new NoDataFoundException(
                                "PC element not found for id: " + elementId));
                PcElementBasis pcElement = pcElementMapper.entityToDto(pcElementEntity);

                resultMap.computeIfAbsent(pcElement, k -> new ArrayList<>())
                        .add(pcElementConstraintEntity.getValue());
        }
        return resultMap.entrySet()
                .stream()
                .map(entry -> new PcElementConstraintValues(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
