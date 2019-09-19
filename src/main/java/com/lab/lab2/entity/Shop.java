package com.lab.lab2.entity;

import com.lab.lab2.Lab2Application;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "shop")
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Shop extends Lab2Application implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  
}