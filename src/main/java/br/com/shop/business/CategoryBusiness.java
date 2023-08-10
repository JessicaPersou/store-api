package br.com.shop.business;

import br.com.shop.model.Category;

import java.util.List;

public interface CategoryBusiness {
    List<Category> findAllCategories();

}
