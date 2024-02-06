package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PcElementSpecification {

    private int id;
    private String name;
    private String code;
    private List<String> values;

}