package com.finanzas.sf.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResumeDTO {
    private Integer income;
    private Integer expenses;
    private List<ResumeAccountDTO> accounts;
}
