package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;

import lombok.Data;

@Data
public class Machines {

    private final List<Machine> machines;

}
