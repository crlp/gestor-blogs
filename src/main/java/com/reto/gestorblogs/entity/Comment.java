package com.reto.gestorblogs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name ="comment")
@Data
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Date date;
  private String name;
  private String estado;

  @ManyToOne
  private Post post;
}
