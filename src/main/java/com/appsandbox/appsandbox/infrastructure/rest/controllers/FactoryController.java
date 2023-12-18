package com.appsandbox.appsandbox.infrastructure.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.rest.requests.Factories;
import com.appsandbox.appsandbox.infrastructure.services.FactoryService;

@RestController
@RequestMapping("factories")
public class FactoryController {

	private FactoryService factoryService;

	public FactoryController(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	@GetMapping()
	public Factories getAllFactories() {
		return new Factories(factoryService.getAllFactories());
	}

}
