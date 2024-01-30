package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;
    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;

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
                        throw new RuntimeException("Error ! Not possible to retrieve constraint with id=null");
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

    public List<PcConstraintEntity> getConstraintsByIds(List<Integer> ids) {
        return pcConstraintRepository.findAllByIdIn(ids);
    }

}
