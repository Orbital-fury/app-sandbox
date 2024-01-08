package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Models {

    private List<Model> models;

    public Models(List<Model> models) {
        this.models = models;
    }

}