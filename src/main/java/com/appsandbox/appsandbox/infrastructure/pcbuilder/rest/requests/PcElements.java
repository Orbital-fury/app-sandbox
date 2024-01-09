package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;

import lombok.Data;

@Data
public class PcElements {

    private final List<PcElement> pcElements;

}
