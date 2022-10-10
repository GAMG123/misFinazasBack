package com.finanzas.sf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Userpass")
@Data
public class UserPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUserPass")
    private Long idUserPass;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

    @Column(name="pass")
    private String pass;

    @Column(name="state")
    private Boolean state;

    @Column(name="registrationDate")
    private Date registrationDate;
}
