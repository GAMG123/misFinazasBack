package com.finanzas.sf.service;

import java.util.List;

import com.finanzas.sf.dto.CategoryDTO;
import com.finanzas.sf.dto.DeleteCategoryRequestDTO;
import com.finanzas.sf.dto.SaveCategoryRequestDTO;

public interface CategoryService {

    List<CategoryDTO> getListCategorys(Long idUser);
    void saveCategory(SaveCategoryRequestDTO saveCategoryRequestDTO);
    void deleteCategory(DeleteCategoryRequestDTO deleteCategoryRequestDTO);
}
