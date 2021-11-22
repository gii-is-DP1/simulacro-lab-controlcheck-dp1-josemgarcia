package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    List<Product> findAll();

    @Query("SELECT ptype FROM ProductType ptype ORDER BY ptype.name")
    List<ProductType> findAllProductTypes();

    @Query("SELECT DISTINCT ptype FROM ProductType ptype WHERE ptype.name LIKE :name")
    Optional<ProductType> findProductTypeByName(@Param("name") String name);

    @Query("SELECT DISTINCT prod FROM Product prod WHERE prod.price < :price")
    List<Product> findByPriceLessThan(@Param("price") double price);

    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
