package com.appsandbox.appsandbox.infrastructure.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.entities.Factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Factories {

    private List<Factory> factories;
    
}
