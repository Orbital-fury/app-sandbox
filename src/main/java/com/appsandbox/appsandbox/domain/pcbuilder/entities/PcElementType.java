package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PcElementType {

    private int id;
    private String name;
    private String code;

}
