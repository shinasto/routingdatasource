package com.shinasto.routingdatasource.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Danji {

  @Id
  private Integer id;

  private String name;
}
