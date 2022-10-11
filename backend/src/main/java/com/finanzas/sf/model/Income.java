package com.finanzas.sf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="INCOME")
@Data

public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idIncome")
    private Long idIncome;
    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;
    
    @Column(name="description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name="idAccount")
    private Account account;
    
    @Column(name="amount")
    private Double amount;
    
    @Column(name="comment")
    private String comment;
    
    @Column(name="state1")
    private Integer state;
    @Column(name="registrationDate")
    private Date registrationDate;

}
