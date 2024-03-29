package com.appsandbox.appsandbox.infrastructure.mmm.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.mmm.rest.requests.Brands;
import com.appsandbox.appsandbox.infrastructure.mmm.services.BrandService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "brands", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Operation(method = "GET", summary = "Get all brands", description = "Return the list of all machine brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Machine brands retrieved successfully")
    })
    @GetMapping()
    public ResponseEntity<Brands> getAllBrands() {
        return new ResponseEntity<>(new Brands(brandService.getAllBrands()), HttpStatus.OK);
    }

}
