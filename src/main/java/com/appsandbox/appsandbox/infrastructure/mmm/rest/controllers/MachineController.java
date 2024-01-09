package com.appsandbox.appsandbox.infrastructure.mmm.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.mmm.rest.requests.Machines;
import com.appsandbox.appsandbox.infrastructure.mmm.services.MachineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "machines", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Machine controller", description = "Interact with measuring machines and its linked data")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @Operation(method = "GET", summary = "Get all machines", description = "Return the list of all machines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "204", description = "No machines retrieved")
    })
    @GetMapping()
    public ResponseEntity<Machines> getAllFactories() {
        return new ResponseEntity<>(new Machines(machineService.getAllMachines()), HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get machine by id", description = "Return a machine by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Machine was not found")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Machine> getFactory(
            @PathVariable @Parameter(name = "id", description = "Machine id", example = "1") int id) {
        Machine machine = machineService.getMachine(id);
        return new ResponseEntity<>(machine, HttpStatus.OK);
    }

}
