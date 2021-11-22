package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        ProductType result = null;
        Optional<ProductType> ptype = productRepository.findProductTypeByName(typeName);
        if (ptype.isPresent())
            result = ptype.get();
        return result;
    }

    public List<ProductType> getAllProductTypes() {
        return this.productRepository.findAllProductTypes();
    }

    public Product save(Product p){
        return this.productRepository.save(p);       
    }

    
}
