package br.com.jp.store.business.impl;

import br.com.jp.store.business.CategoryBusiness;
import br.com.jp.store.model.Category;
import br.com.jp.store.repository.CategoryRepository;
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