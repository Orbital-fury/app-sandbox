package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Brand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Brands {

    private List<Brand> brands;

    public Brands(List<Brand> brands) {
        this.brands = brands;
    }

}
