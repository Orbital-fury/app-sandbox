package com.appsandbox.appsandbox.infrastructure.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.rest.requests.Factories;
import com.appsandbox.appsandbox.infrastructure.services.FactoryService;

@RestController
@RequestMapping("factories")
public class FactoryController {

	@Autowired
	private FactoryService factoryService;

	// @GetMapping()
	// public Factories getAllFactories() {
	// 	return new Factories(factoryService.getAllFactories());
	// }

}
