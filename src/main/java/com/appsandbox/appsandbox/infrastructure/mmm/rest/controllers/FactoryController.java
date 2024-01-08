package com.appsandbox.appsandbox.infrastructure.mmm.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.appsandbox.appsandbox.domain.mmm.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.mmm.rest.requests.Factories;
import com.appsandbox.appsandbox.infrastructure.mmm.services.FactoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "factories", produces = MediaType.APPLICATION_JSON_VALUE)
public class FactoryController {

	@Autowired
	private FactoryService factoryService;

	@Operation(method = "GET", summary = "Get all factories", description = "Return the list of all factories and there machines")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Factories were not found")
	})
	@GetMapping()
	public ResponseEntity<Factories> getAllFactories() {
		return new ResponseEntity<>(new Factories(factoryService.getAllFactories()), HttpStatus.OK);
	}

	@Operation(method = "GET", summary = "Get factory by id", description = "Return a factory by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Factory was not found")
	})
	@GetMapping(path = "/{id}")
	public ResponseEntity<Factory> getFactory(
			@PathVariable @Parameter(name = "id", description = "Factory id", example = "1") int id) {
		Factory factory = factoryService.getFactory(id);
		if (factory != null) {
			return new ResponseEntity<>(factory, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Factory with id=" + id + " not found");
		}
	}

}
