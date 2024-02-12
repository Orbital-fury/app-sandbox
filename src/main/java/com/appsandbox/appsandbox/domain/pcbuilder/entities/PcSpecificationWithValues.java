package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PcSpecificationWithValues extends PcSpecification {

    private List<String> values = new ArrayList<>();

    public PcSpecificationWithValues(int id, String name, String code, List<String> values) {
        super(id, name, code);
        this.values = values;
    }

    public PcSpecificationWithValues(PcSpecification pcSpecification, List<String> values) {
        super(pcSpecification.getId(), pcSpecification.getName(), pcSpecification.getCode());
        this.values = values;
    }

}
