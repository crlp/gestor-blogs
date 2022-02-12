package com.reto.gestorblogs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="author")
@Data
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  private String name;
  private String email;
  private String phone;

  @Temporal(TemporalType.DATE)
  private Date birthDate;

  @JsonIgnore
  @OneToMany(mappedBy = "author",  cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Blog> blogs;

}
