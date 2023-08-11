package br.com.jp.store.business;

import br.com.jp.store.dto.ProductDTO;
import br.com.jp.store.model.Product;

import java.util.List;

public interface ProductBusiness {

    List<Product> findAllProducts();

    ProductDTO findById(long id);

    List<ProductDTO> findByName(String name);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(long id, ProductDTO productDTO);

    void delete(long id);
}