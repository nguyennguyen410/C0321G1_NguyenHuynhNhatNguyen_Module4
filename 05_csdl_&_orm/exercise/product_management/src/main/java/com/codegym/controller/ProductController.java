package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import com.codegym.model.service.ProductServiceImpl;
import com.sun.org.apache.xml.internal.serializer.AttributesImplSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

   @Autowired
   ProductService productService;

    @GetMapping("")
    public String index(Model model) {

        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Create Product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product customer, RedirectAttributes redirect) {
        productService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String findByName(@RequestParam("search") String name, Model model) {
        model.addAttribute("product", productService.findByName(name));
        return "/view";
    }
}
