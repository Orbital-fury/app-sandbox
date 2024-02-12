package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.ArrayList;
import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PcConstraintWithValues extends PcConstraint {

    private List<String> values = new ArrayList<>();

    public PcConstraintWithValues(int id, String name, String code, PcConstraintType type, List<String> values) {
        super(id, name, code, type);
        this.values = values;
    }

    public PcConstraintWithValues(PcConstraint pcConstraint, List<String> values) {
        super(pcConstraint.getId(), pcConstraint.getName(), pcConstraint.getCode(), pcConstraint.getType());
        this.values = values;
    }

}
