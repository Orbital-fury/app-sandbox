package com.appsandbox.appsandbox.infrastructure.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.services.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

}
