package com.lab.lab2.entity;

import com.lab.lab2.Lab2Application;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "product")
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends Lab2Application implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "availability")
  private Boolean availability;

  @Column(name = "category")
  private String category;

  @Column(name = "description")
  private String description;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Float price;

  @Column(name = "by_weight")
  private Boolean by_weight;

  @Column(name = "shop_id", nullable = false)
  private Integer shopId;

  
}