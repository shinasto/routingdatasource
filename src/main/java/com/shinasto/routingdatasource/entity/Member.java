package com.shinasto.routingdatasource.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  private String name;

  private String age;
}
