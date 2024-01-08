package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Machines {

    private List<Machine> machines;

    public Machines(List<Machine> machines) {
        this.machines = machines;
    }

}
