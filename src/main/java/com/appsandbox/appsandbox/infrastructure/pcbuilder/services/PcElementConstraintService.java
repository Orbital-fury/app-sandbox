package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;

@Service
public class PcElementConstraintService {

    Logger log = LoggerFactory.getLogger(PcElementConstraintService.class);

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
            pcConstraints.add(new PcConstraint(pcConstraint.getId(), pcConstraint.getName(), pcConstraint.getCode(),
                    pcConstraint.getType(),
                    valuesByConstraints.get(pcConstraint.getId())));
        }
        return pcConstraints;
    }

    public List<PcConstraintEntity> getConstraintsByIds(List<Integer> ids) {
        List<PcConstraintEntity> allByIdIn = pcConstraintRepository.findAllByIdIn(ids);
        return allByIdIn;
    }

}
