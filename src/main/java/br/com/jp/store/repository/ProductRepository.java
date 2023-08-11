package br.com.jp.store.repository;

import br.com.jp.store.dto.ProductDTO;
import br.com.jp.store.model.Product;
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