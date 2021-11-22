package org.springframework.samples.petclinic.product;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    @ModelAttribute("types")
	public Collection<ProductType> populateProductTypes() {
		return this.productService.getAllProductTypes();
	}

    @GetMapping("/product/create")
    public String initCreationForm(ModelMap model) {
        Product prod = new Product();
        model.put("product", prod);
        return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/product/create")
    public String processCreationForm(@Valid Product prod, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("product", prod);
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        } else {
            this.productService.save(prod);
            return "redirect:/";
        }
    }
}
