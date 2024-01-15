package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PcConstraint {

    private int id;
    private String name;
    private String code;
    private PcConstraintType type;
    private List<String> value;

}
