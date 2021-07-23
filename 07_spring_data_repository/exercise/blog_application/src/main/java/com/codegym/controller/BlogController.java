package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView showListBlog(@PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogList", blogs);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog",new Blog());
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categorys", categoryList);
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        /*blog.setDateCreate(new Date(System.currentTimeMillis()));*/
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Create blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categorys", categoryList);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Edit blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.delete(blog);
        redirect.addFlashAttribute("success", "Delete blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search") String name, @RequestParam("category") Long id, @PageableDefault(value = 5, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        /*return new ModelAndView("/search-list","blogList",blogService.findAllByNameContaining(name,pageable));*/
        if(name.equals("")){
            /*Category categories = categoryService.findById(id);*/
            Page<Blog> categoryBlog = blogService.findAllByCategory_Id(id, pageable);
            ModelAndView modelAndView = new ModelAndView("/search-list");
            modelAndView.addObject("blogList", categoryBlog);
            return modelAndView;
        } else {
            Page<Blog> blogs = blogService.findAllByNameContaining(name,pageable);
            ModelAndView modelAndView = new ModelAndView("/search-list");
            modelAndView.addObject("blogList", blogs);
            return modelAndView;
        }
    }

    /*@GetMapping("/search1")
    public ModelAndView showList1(@PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/search-list");
        modelAndView.addObject("blogList", blogs);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        return modelAndView;
    }

    @GetMapping("/search2")
    public ModelAndView showList2(@PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/search-list");
        modelAndView.addObject("blogList", blogs);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        return modelAndView;
    }*/
}
