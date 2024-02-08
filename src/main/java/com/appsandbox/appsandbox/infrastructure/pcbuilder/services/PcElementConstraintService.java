package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutSpecs;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementMapper;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementMapper pcElementMapper;

    public List<PcElementWithoutSpecs> getPcElementAndConstraintValues(int pcConstraintId) {
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElementConstraintRepository
                .findByConstraintId(pcConstraintId);
        return pcElementConstraintEntities.stream()
                .map(entity -> pcElementMapper.entityToDtoWithoutSpecs(entity.getPcElement()))
                .collect(Collectors.toList());
    }

}
