package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PcElementSpecificationId implements Serializable {

    @Column(name = "element_id")
    private int elementId;

    @Column(name = "specification_id")
    private int specificationId;

}
