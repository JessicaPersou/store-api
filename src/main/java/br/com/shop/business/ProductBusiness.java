package br.com.shop.business;

import br.com.shop.dto.ProductDTO;
import br.com.shop.model.Product;

import java.util.List;

public interface ProductBusiness {

    List<Product> findAllProducts();

    ProductDTO findById(long id);

    List<ProductDTO> findByName(String name);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(long id, ProductDTO productDTO);

    void delete(long id);
}