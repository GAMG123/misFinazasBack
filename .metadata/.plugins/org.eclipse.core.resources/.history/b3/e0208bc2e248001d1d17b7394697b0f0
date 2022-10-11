package com.finanzas.sf.repository;

import org.springframework.data.repository.CrudRepository;

import com.finanzas.sf.model.Category;
import com.finanzas.sf.model.Detail;
import com.finanzas.sf.model.User;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository  extends CrudRepository<Detail, Integer> {
    List<Detail> findPeridoByEstado(Boolean estado);
    Optional<Detail> findPeriodoByCodigoPeriodoAndEstado(String codigoPerido, Boolean estado);
}
