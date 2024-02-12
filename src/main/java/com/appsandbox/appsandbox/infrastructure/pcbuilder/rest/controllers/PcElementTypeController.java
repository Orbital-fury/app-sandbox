package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcElementTypes;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(path = "pc-element-types", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PcElementTypeController {

    @Autowired
    private PcElementTypeService pcElementTypeService;

    @Operation(method = "GET", summary = "Get all pc element types", description = "Return the list of all types of pc element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC element types retrieved successfully")
    })
    @GetMapping()
    public ResponseEntity<PcElementTypes> getAllPcElementTypes() {
        return new ResponseEntity<>(new PcElementTypes(pcElementTypeService.getAllPcElementTypes()), HttpStatus.OK);
    }

}
