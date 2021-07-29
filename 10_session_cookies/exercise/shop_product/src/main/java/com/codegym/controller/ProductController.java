package com.codegym.controller;

import com.codegym.model.entity.Cart;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(@CookieValue(value = "idCookie", defaultValue = "-1") Long idCookie, Model model) {
        if(idCookie!= -1){
            model.addAttribute("historyCookie", productService.findById(idCookie).get());
        }
        ModelAndView modelAndView = new ModelAndView("/product-list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("deCrease")) {
            cart.deCreProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("show-cart")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message", "Add " + productOptional.get().getDescription() + " success!!!");
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, HttpServletResponse httpResponse, Model model ) {
        Cookie cookie = new Cookie("idCookie", id + "");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/shop");
        httpResponse.addCookie(cookie);

        Optional<Product> productOptional = productService.findById(id);
        model.addAttribute("products", productOptional.get());
        return "/product-detail";
    }
}
