package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcElementConstraint extends PcConstraint {

    private List<String> values;

    public PcElementConstraint(int id, String name, String code, PcConstraintType type, List<String> values) {
        super(id, name, code, type);
        this.values = values;
    }

}
