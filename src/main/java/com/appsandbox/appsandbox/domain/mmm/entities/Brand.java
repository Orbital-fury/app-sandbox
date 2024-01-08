package com.appsandbox.appsandbox.domain.mmm.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Brand {

    private int id;
    private String name;
    private String website;
    private String hqAddress;
    private List<ModelWithoutBrand> models;

}
