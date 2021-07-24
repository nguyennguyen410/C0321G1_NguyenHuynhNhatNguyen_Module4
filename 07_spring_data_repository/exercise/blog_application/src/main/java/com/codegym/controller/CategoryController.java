package com.codegym.controller;

import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public ModelAndView showCategoryList(){
        return new ModelAndView("/category/category-list.html","categoryList",categoryService.findAll());
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "/category/category-create.html";
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
        return "/category/category-edit.html";
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
        return "/category/category-delete.html";
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
        return "/category/category-view.html";
    }

    @GetMapping("/{id}/view")
    public String viewBlog(@PathVariable Long id, Model model, @PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogList", blogService.findAllByCategory_Id(id, pageable));
        model.addAttribute("idCategory", id);
        return "/category/view.html";
    }

    @GetMapping("/viewPage")
    public String viewPage(@RequestParam Long id, Model model, @PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogList", blogService.findAllByCategory_Id(id, pageable));
        model.addAttribute("idCategory", id);
        return "/category/view.html";
    }
}
