package org.example.productthymeleaf.controller;

import org.example.productthymeleaf.model.Product;
import org.example.productthymeleaf.service.IProductService;
import org.example.productthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("product", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random()*10000));
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes attributes){
        productService.remove(product.getId());
        attributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search(){
        return "/search";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Product> productList = productService.findByName(name);
        model.addAttribute("products", productList);
        return "/search";
    }

}
