package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementSpecificationRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcSpecificationRepository;

@Service
public class PcElementSpecificationService {

    @Autowired
    private PcSpecificationRepository pcSpecificationRepository;
    @Autowired
    private PcElementSpecificationRepository pcElementSpecificationRepository;

    public List<PcSpecification> getElementSpecifications(int elementId) {
        List<PcElementSpecificationEntity> elementSpecifications = pcElementSpecificationRepository
                .findByElementId(elementId);

        HashMap<Integer, List<String>> valuesBySpecifications = new HashMap<>();
        List<PcSpecification> pcSpecifications = new ArrayList<>();

        elementSpecifications.forEach(elementSpecification -> {
            List<String> values = valuesBySpecifications.getOrDefault(elementSpecification.getSpecificationId(),
                    new ArrayList<>());
            values.add(elementSpecification.getValue());
            valuesBySpecifications.put(elementSpecification.getSpecificationId(), values);
        });

        for (Integer key : valuesBySpecifications.keySet()) {
            PcSpecificationEntity pcSpecification = pcSpecificationRepository.findById(key).get();
            pcSpecifications.add(
                    new PcSpecification(pcSpecification.getId(), pcSpecification.getName(), pcSpecification.getCode(),
                            valuesBySpecifications.get(pcSpecification.getId())));
        }
        return pcSpecifications;
    }

}
