package com.finanzas.sf.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name="CATEGORY")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategory")
    private Long idCategory;
    
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

    @Column(name="nameCategory")
    private String nameCategory;
    
    @Column(name="descriptionCategory")
    private String descriptionCategory;

    @Column(name="state1")
    private Integer state;

    @Column(name="registrationDate")
    private Date registrationDate;
}
