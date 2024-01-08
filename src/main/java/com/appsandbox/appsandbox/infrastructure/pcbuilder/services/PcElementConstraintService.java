package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
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
        List<PcConstraint> pcConstraints = new ArrayList<>();

        elementConstraints.forEach(elementConstraint -> {
            List<String> values = valuesByConstraints.getOrDefault(elementConstraint.getConstraintId(),
                    new ArrayList<>());
            values.add(elementConstraint.getValue());
            valuesByConstraints.put(elementConstraint.getConstraintId(), values);
        });

        for (Integer key : valuesByConstraints.keySet()) {
            PcConstraintEntity pcConstraint = pcConstraintRepository.findById(key).get();
            pcConstraints.add(new PcConstraint(pcConstraint.getName(), pcConstraint.getCode(), pcConstraint.getType(),
                    valuesByConstraints.get(pcConstraint.getId())));
        }

        return pcConstraints;

    }

}
