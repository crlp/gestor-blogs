package com.reto.gestorblogs.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name ="blog")
@Data
public class Blog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  private String name;
  private String description;
  private String url;
  private String status;

  @ManyToOne
  private Author author;

  @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;

}
