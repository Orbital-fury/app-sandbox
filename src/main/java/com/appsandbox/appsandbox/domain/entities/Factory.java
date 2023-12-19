package com.appsandbox.appsandbox.domain.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Factory {

  private int id;
  private String name;
  private String type;
  private String address;
  private List<Machine> machines;

}
