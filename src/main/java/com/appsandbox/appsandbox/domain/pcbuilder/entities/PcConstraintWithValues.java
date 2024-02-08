package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcConstraintWithValues extends PcConstraint {

    // private final int elementId;
    // private final int constraintId;
    private final List<String> values;

    public PcConstraintWithValues(int id, String name, String code, PcConstraintType type, List<String> values) {
        super(id, name, code, type);
        this.values = values;
    }

    public PcConstraintWithValues(PcConstraint pcConstraint, List<String> values) {
        super(pcConstraint.getId(), pcConstraint.getName(), pcConstraint.getCode(), pcConstraint.getType());
        this.values = values;
    }

}
