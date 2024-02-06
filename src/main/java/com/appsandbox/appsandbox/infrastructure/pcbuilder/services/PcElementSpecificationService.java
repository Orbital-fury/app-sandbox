package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
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

        public List<PcElementSpecification> getElementSpecifications(int elementId) {
                List<PcElementSpecificationEntity> elementSpecifications = pcElementSpecificationRepository
                                .findByElementId(elementId);

                HashMap<Integer, List<String>> valuesBySpecifications = new HashMap<>();

                elementSpecifications.forEach(elementSpecification -> {
                        // List<String> values = valuesBySpecifications.getOrDefault(
                        // elementSpecification.getSpecificationId(),
                        // new ArrayList<>());
                        // values.add(elementSpecification.getValue());
                        // valuesBySpecifications.put(elementSpecification.getSpecificationId(),
                        // values);
                        valuesBySpecifications
                                        .computeIfAbsent(elementSpecification.getSpecificationId(),
                                                        k -> new ArrayList<>())
                                        .add(elementSpecification.getValue());
                });

                // List<PcSpecification> pcSpecifications = new ArrayList<>();
                // for (int key : valuesBySpecifications.keySet()) {
                // PcSpecificationEntity pcSpecification =
                // pcSpecificationRepository.findById(key)
                // .orElseThrow(() -> new RuntimeException(
                // "PcSpecificationEntity not found for key: " + key));
                // pcSpecifications.add(
                // new PcSpecification(pcSpecification.getId(), pcSpecification.getName(),
                // pcSpecification.getCode(),
                // valuesBySpecifications.get(pcSpecification.getId())));
                // }
                // return pcSpecifications;
                return valuesBySpecifications.keySet().stream()
                                .map(key -> {
                                        if (key == null) {
                                                throw new RuntimeException(
                                                                "Error ! Not possible to retrieve specification for id=null");
                                        }
                                        PcSpecificationEntity pcSpecification = pcSpecificationRepository.findById(key)
                                                        .orElseThrow(() -> new RuntimeException(
                                                                        "PcSpecificationEntity not found for key: "
                                                                                        + key));
                                        return new PcElementSpecification(pcSpecification.getId(), pcSpecification.getName(),
                                                        pcSpecification.getCode(), valuesBySpecifications.get(key));
                                })
                                .collect(Collectors.toList());
        }

}
