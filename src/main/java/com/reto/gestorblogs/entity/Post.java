package com.reto.gestorblogs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="post")
@Data
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  private String title;
  private Date date;
  private String status;
  private String content;

  @ManyToOne
  private Blog blog;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;

  @PrePersist
  protected void prePersist(){
    this.date = new Date();
  }
}
