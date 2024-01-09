package com.appsandbox.appsandbox.infrastructure.mmm.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.entities.Model;

import lombok.Data;

@Data
public class Models {

    private final List<Model> models;

}
