package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Brand;

import lombok.Data;

@Data
public class Brands {

    private final List<Brand> brands;

}
