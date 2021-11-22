package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private ProductService productService;

    @Autowired
    public ProductTypeFormatter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType ptype = productService.getProductType(text);
        if (ptype == null)
            throw new ParseException("Error when formatting product type", 0);
        return ptype;
    }
    
}
