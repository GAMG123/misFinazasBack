package com.finanzas.sf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="t_detail")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetail")
    private Long idDetail;
    @Column(name="descriptionDetail")
    private String descriptionDetail;
    @Column(name="state")
    private Boolean state;
    @Column(name="registrationDate")
    private Date registrationDate;
}
