package com.appsandbox.appsandbox.infrastructure.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.entities.Factory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Factories {

    private List<Factory> factories;

    public Factories(List<Factory> factories) {
        this.factories = factories;
    }

}
