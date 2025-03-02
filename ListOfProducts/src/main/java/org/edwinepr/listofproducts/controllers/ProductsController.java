package org.edwinepr.listofproducts.controllers;

import org.edwinepr.listofproducts.model.Product;
import org.edwinepr.listofproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(path = "/products",
                    method = RequestMethod.POST)
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products";
    }
}
