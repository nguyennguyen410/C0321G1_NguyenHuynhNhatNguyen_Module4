package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView showCategoryList(){
        return new ModelAndView("/category-list","categoryList",categoryService.findAll());
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "/category-create";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Create blog successfully!");
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category-edit";
    }

    @PostMapping("/edit")
    public String edit(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Edit successfully!");
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category-delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        categoryService.delete(category);
        redirect.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/category/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category-view";
    }
}
