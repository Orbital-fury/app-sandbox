package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcElements;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(path = "pc-elements", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PcElementController {

        @Autowired
        private PcElementService pcElementService;

        @Operation(method = "GET", summary = "Get all pc elements", description = "Return the list of all pc elements")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully retrieved")
        })
        @GetMapping()
        public ResponseEntity<PcElements> getAllPcElements() {
                return new ResponseEntity<>(new PcElements(pcElementService.getAllPcElement()), HttpStatus.OK);
        }

        @Operation(method = "GET", summary = "Get pc elements regarding constraints", description = "Return the list of all possible pc elements that can be added regarding PC elements from build")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully retrieved")
        })
        @GetMapping("/constraints/elements")
        public ResponseEntity<PcElements> getPcElementsWithConstraints(
                        @RequestParam(name = "ids", required = false) @Parameter(description = "Comma-separated list of PC element IDs", example = "0,9") String pcBuildElementIds) {
                return new ResponseEntity<>(
                                new PcElements(pcElementService.getPcElementsWithConstraints(pcBuildElementIds)),
                                HttpStatus.OK);
        }

        @Operation(method = "GET", summary = "Get PC element by id", description = "Return PC element by its id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
                        @ApiResponse(responseCode = "404", description = "PC element was not found", content = @Content)
        })
        @GetMapping(path = "/{id}")
        public ResponseEntity<PcElement> getPcElement(
                        @PathVariable @Parameter(name = "id", description = "PC element id", example = "1") int id) {
                PcElement pcElement = pcElementService.getPcElement(id);
                return new ResponseEntity<>(pcElement, HttpStatus.OK);
        }

}
