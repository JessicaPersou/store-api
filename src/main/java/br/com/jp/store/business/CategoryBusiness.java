package br.com.jp.store.business;

import br.com.jp.store.model.Category;

import java.util.List;

public interface CategoryBusiness {
    List<Category> findAllCategories();

}
