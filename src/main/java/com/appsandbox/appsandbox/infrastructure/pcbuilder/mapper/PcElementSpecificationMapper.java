package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecificationWithValues;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;

@Service
public class PcElementSpecificationMapper {

    @Autowired
    private PcSpecificationMapper pcSpecificationMapper;

    public List<PcSpecificationWithValues> entitiesToDtos(
            List<PcElementSpecificationEntity> pcElementSpecificationEntities) {
        Map<Integer, Map<Integer, List<PcElementSpecificationEntity>>> groupedBySpecificationIdAndElementId = pcElementSpecificationEntities
                .stream()
                .collect(Collectors.groupingBy(PcElementSpecificationEntity::getSpecificationId,
                        Collectors.groupingBy(PcElementSpecificationEntity::getElementId)));

        return groupedBySpecificationIdAndElementId.values().stream()
                .flatMap(elementGroup -> elementGroup.values().stream())
                .map(this::mapToPcElementSpecification)
                .collect(Collectors.toList());
    }

    private PcSpecificationWithValues mapToPcElementSpecification(
            List<PcElementSpecificationEntity> specificationEntities) {
        PcSpecification pcSpecification = pcSpecificationMapper
                .entityToDto(specificationEntities.get(0).getPcSpecification()); // Assuming PcConstraintEntity has a
                                                                                 // toDto() method

        List<String> values = specificationEntities.stream()
                .map(PcElementSpecificationEntity::getValue)
                .collect(Collectors.toList());

        return new PcSpecificationWithValues(pcSpecification, values);
    }

    public List<PcElementSpecificationEntity> dtoToEntities(int pcElementId,
            List<PcSpecificationWithValues> pcElementSpecifications) {
        List<PcElementSpecificationEntity> pcElmentSpecificationEntities = new ArrayList<>();

        pcElementSpecifications.stream()
                .map(pcElementSpecification -> pcElementSpecification.getValues().stream()
                        .map(value -> pcElmentSpecificationEntities.add(new PcElementSpecificationEntity(
                                pcElementId,
                                pcElementSpecification.getId(),
                                value,
                                null,
                                null))))
                .distinct()
                .collect(Collectors.toList());

        return pcElmentSpecificationEntities;
    }

}
