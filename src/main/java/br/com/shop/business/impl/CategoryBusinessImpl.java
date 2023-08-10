package br.com.shop.business.impl;

import br.com.shop.business.CategoryBusiness;
import br.com.shop.model.Category;
import br.com.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBusinessImpl implements CategoryBusiness {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}