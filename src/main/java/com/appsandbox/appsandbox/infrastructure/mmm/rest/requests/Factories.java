package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Factory;

import lombok.Data;

@Data
public class Factories {

    private final List<Factory> factories;

}
