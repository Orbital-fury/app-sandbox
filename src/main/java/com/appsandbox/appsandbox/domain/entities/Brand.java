package com.appsandbox.appsandbox.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Brand {

    private int id;
    private String name;
    private String website;
    private String hqAddress;

}
