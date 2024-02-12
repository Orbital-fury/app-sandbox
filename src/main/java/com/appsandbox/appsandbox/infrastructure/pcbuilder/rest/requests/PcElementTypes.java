package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementType;

import lombok.Data;

@Data
public class PcElementTypes {

    private final List<PcElementType> pcElementTypes;

}
