package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithValues;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;

@Service
public class PcElementConstraintMapper {

    @Autowired
    private PcConstraintMapper pcConstraintMapper;

    public List<PcConstraintWithValues> entitiesToDtos(List<PcElementConstraintEntity> pcElementConstraintEntities) {
        Map<Integer, Map<Integer, List<PcElementConstraintEntity>>> groupedByConstraintIdAndElementId = pcElementConstraintEntities.stream()
                .collect(Collectors.groupingBy(PcElementConstraintEntity::getConstraintId,
                        Collectors.groupingBy(PcElementConstraintEntity::getElementId)));

        return groupedByConstraintIdAndElementId.values().stream()
                .flatMap(elementGroup -> elementGroup.values().stream())
                .map(this::mapToPcElementConstraint)
                .collect(Collectors.toList());
    }

    private PcConstraintWithValues mapToPcElementConstraint(List<PcElementConstraintEntity> constraintEntities) {
        PcConstraint pcConstraint = pcConstraintMapper.entityToDto(constraintEntities.get(0).getPcConstraint()); // Assuming PcConstraintEntity has a toDto() method

        List<String> values = constraintEntities.stream()
                .map(PcElementConstraintEntity::getValue)
                .collect(Collectors.toList());

        return new PcConstraintWithValues(pcConstraint, values);
    }

    public List<PcElementConstraintEntity> dtosToEntities(int pcElementId, List<PcConstraintWithValues> pcElementConstraints) {
        List<PcElementConstraintEntity> pcElmentConstraintEntities = new ArrayList<>();
        pcElementConstraints.stream()
                .map(pcElementConstraint -> pcElementConstraint.getValues().stream()
                        .map(value -> pcElmentConstraintEntities.add(new PcElementConstraintEntity(
                                pcElementId,
                                pcElementConstraint.getId(),
                                value,
                                null,
                                null))))
                .distinct()
                .collect(Collectors.toList());

        return pcElmentConstraintEntities;
    }

}
