package com.appsandbox.appsandbox.infrastructure.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.appsandbox.appsandbox.domain.entities.Factory;
import com.appsandbox.appsandbox.domain.enums.FactoryType;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;
import com.appsandbox.appsandbox.infrastructure.database.entities.MachineEntity;
import com.appsandbox.appsandbox.infrastructure.database.repositories.FactoryRepository;
import com.appsandbox.appsandbox.infrastructure.mapper.FactoryMapper;

@ExtendWith(MockitoExtension.class)
public class FactoryServiceTest {

    @Mock
    private FactoryRepository factoryRepository;

    @Spy
    private FactoryMapper factoryMapper = Mappers.getMapper(FactoryMapper.class);

    @InjectMocks
    private FactoryService factoryService;

    @Test
    void should_retrieve_factory() {
        // Given
        int factoryId = 0;
        FactoryEntity factoryEntity = new FactoryEntity(factoryId, "name", FactoryType.FACTORY, "address",
                new ArrayList<MachineEntity>());
        when(factoryRepository.findById(anyInt())).thenReturn(factoryEntity);

        // When
        Factory factory = factoryService.getFactory(factoryId);

        // Then
        assertEquals(factory, factoryMapper.entityToDto(factoryEntity));
    }

    @Test
    void should_retrieve_no_factory() {
        // Given
        when(factoryRepository.findById(anyInt())).thenReturn(null);

        // When
        Factory factory = factoryService.getFactory(20);

        // Then
        assertNull(factory);
    }

}
