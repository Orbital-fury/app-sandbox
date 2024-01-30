package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutSpec;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;
    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementRepository pcElementRepository;

    public List<PcConstraint> getElementConstraints(int elementId) {
        List<PcElementConstraintEntity> elementConstraints = pcElementConstraintRepository.findByElementId(elementId);

        HashMap<Integer, List<String>> valuesByConstraints = new HashMap<>();

        elementConstraints.forEach(elementConstraint -> {
            // List<String> values = valuesByConstraints.getOrDefault(elementConstraint.getConstraintId(),
            //         new ArrayList<>());
            // values.add(elementConstraint.getValue());
            // valuesByConstraints.put(elementConstraint.getConstraintId(), values);
            valuesByConstraints
                    .computeIfAbsent(elementConstraint.getConstraintId(),
                            k -> new ArrayList<>())
                    .add(elementConstraint.getValue());
        });

        // List<PcConstraint> pcConstraints = new ArrayList<>();
        // for (int key : valuesByConstraints.keySet()) {
        //     PcConstraintEntity pcConstraint = pcConstraintRepository.findById(key)
        //             .orElseThrow(() -> new RuntimeException("PcConstraintEntity not found for key: " + key));
        //     List<String> constraintValues = valuesByConstraints.get(pcConstraint.getId());
        //     if ((pcConstraint.getType() == PcConstraintType.LIMIT || pcConstraint.getType() == PcConstraintType.MAX)
        //             && constraintValues.size() != 1) {
        //         throw new RuntimeException("A type's constraint: MAX or LIMIT has a size different from 1");
        //     }
        //     pcConstraints.add(new PcConstraint(pcConstraint.getId(), pcConstraint.getName(), pcConstraint.getCode(),
        //             pcConstraint.getType(),
        //             constraintValues));
        // }
        // return pcConstraints;
        return valuesByConstraints.keySet().stream()
                .map(key -> {
                    if (key == null) {
                        throw new RuntimeException("Error ! Not possible to retrieve constraint for id=null");
                    }
                    PcConstraintEntity pcConstraint = pcConstraintRepository.findById(key)
                            .orElseThrow(() -> new RuntimeException("PcConstraintEntity not found for key: " + key));
                    List<String> constraintValues = valuesByConstraints.get(pcConstraint.getId());
                    if ((pcConstraint.getType() == PcConstraintType.LIMIT
                            || pcConstraint.getType() == PcConstraintType.MAX)
                            && constraintValues.size() != 1) {
                        throw new RuntimeException("A type's constraint: MAX or LIMIT has a size different from 1");
                    }
                    return new PcConstraint(pcConstraint.getId(), pcConstraint.getName(), pcConstraint.getCode(),
                            pcConstraint.getType(),
                            constraintValues);
                })
                .collect(Collectors.toList());
    }

    // public List<PcConstraintEntity> getConstraintsByIds(List<Integer> ids) {
    //     return pcConstraintRepository.findAllByIdIn(ids);
    // }

    public Map<PcElementWithoutSpec, List<String>> getPcElementAndConstraintValues(int constraintId) {
        pcConstraintRepository.findById(constraintId)
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + constraintId));
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElementConstraintRepository
                .findByConstraintId(constraintId);
        Map<PcElementWithoutSpec, List<String>> map = new HashMap<>();
        for (PcElementConstraintEntity pcElementConstraintEntity : pcElementConstraintEntities) {
            int elementId = pcElementConstraintEntity.getElementId();
            PcElementEntity pcElementEntity = pcElementRepository.findById(elementId)
                    .orElseThrow(() -> new NoDataFoundException("PC element not found for id: " + elementId));
            PcElementWithoutSpec pcElement = pcElementEntity.toDtoWithoutSpec();

            map.computeIfAbsent(pcElement, k -> new ArrayList<>());
            map.get(pcElement).add(pcElementConstraintEntity.getValue());
        }
        return map;
    }

}
