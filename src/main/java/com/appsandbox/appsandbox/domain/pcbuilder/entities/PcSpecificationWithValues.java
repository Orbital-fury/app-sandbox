package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcSpecificationWithValues extends PcSpecification {

    private final List<String> values;

    public PcSpecificationWithValues(int id, String name, String code, List<String> values) {
        super(id, name, code);
        this.values = values;
    }

    public PcSpecificationWithValues(PcSpecification pcSpecification, List<String> values) {
        super(pcSpecification.getId(), pcSpecification.getName(), pcSpecification.getCode());
        this.values = values;
    }

}
