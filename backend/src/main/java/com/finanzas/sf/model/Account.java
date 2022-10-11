package com.finanzas.sf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ACCOUNT")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAccount")
    private Long idAccount;
    
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;
    
    @Column(name="nameAccount")
    private String nameAccount;

    @Column(name="descriptionAccount")
    private String descriptionAccount;

    @Column(name="state1")
    private Integer state;

    @Column(name="registrationDate")
    private Date registrationDate;
}
