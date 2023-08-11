package br.com.shop.repository;

import br.com.shop.dto.ProductDTO;
import br.com.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name like %?1%")
    List<ProductDTO> findByName(@Param("name") String name);
}