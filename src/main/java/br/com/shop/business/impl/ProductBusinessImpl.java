package br.com.shop.business.impl;

import br.com.shop.business.ProductBusiness;
import br.com.shop.dto.ProductDTO;
import br.com.shop.model.Category;
import br.com.shop.model.Product;
import br.com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBusinessImpl implements ProductBusiness {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO findById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("ID: " + id + " NOT FOUND"));
        return new ProductDTO(product);
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setCategory(new Category(productDTO.getCategory()));


        productRepository.save(product);
        productDTO.setId(product.getId());

        return new ProductDTO(product);
    }

    @Override
    public ProductDTO update(long id, ProductDTO productDTO) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("ID: " + id + " NOT FOUND"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setCategory(new Category(productDTO.getCategory()));

        productRepository.save(product);

        return new ProductDTO(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}