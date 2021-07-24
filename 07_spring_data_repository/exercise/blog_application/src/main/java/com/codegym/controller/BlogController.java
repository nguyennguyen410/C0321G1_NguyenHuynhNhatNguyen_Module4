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

import java.util.List;
import java.util.Optional;

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
        ModelAndView modelAndView = new ModelAndView("/blog/list.html");
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
        return "/blog/create.html";
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
        return "/blog/edit.html";
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
        return "/blog/delete.html";
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
        return "/blog/view.html";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "search", required = false) String name,
                               @RequestParam(value = "category", required = false) Long id,
                               @PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        /*return new ModelAndView("/search-list","blogList",blogService.findAllByNameContaining(name,pageable));*/
        Page<Blog> blogs = null;
        String nameKey = "";
        ModelAndView modelAndView = null;

        if(name.equals("")){
            blogs = blogService.findAllByCategory_Id(id, pageable);
            modelAndView = new ModelAndView("/blog/search-list.html");
            modelAndView.addObject("blogList", blogs);
            modelAndView.addObject("idCategory", id);
            modelAndView.addObject("nameSearch", nameKey);
            List<Category> categoryList = categoryService.findAll();
            modelAndView.addObject("categorys", categoryList);
            /*Category categories = categoryService.findById(id);*/
        }
        if(!name.equals("")) {
            blogs = blogService.findAllByNameContaining(name,pageable);
            modelAndView = new ModelAndView("/blog/search-list.html");
            modelAndView.addObject("blogList", blogs);
            modelAndView.addObject("idCategory", id);
            List<Category> categoryList = categoryService.findAll();
            modelAndView.addObject("categorys", categoryList);
        }
        return modelAndView;
    }

    /*@GetMapping("/searchPre")
    public ModelAndView showListPre(@RequestParam Long id, @PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAllByCategory_Id(id,pageable);
        ModelAndView modelAndView = new ModelAndView("/category/search-list.html");
        modelAndView.addObject("blogList", blogs);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        modelAndView.addObject("idCategory",id);
        return modelAndView;
    }

    @GetMapping("/searchNext")
    public ModelAndView showListNext(@RequestParam Long id, @PageableDefault(value = 3, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAllByCategory_Id(id, pageable);
        ModelAndView modelAndView = new ModelAndView("/category/search-list.html");
        modelAndView.addObject("blogList", blogs);
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        modelAndView.addObject("idCategory",id);
        return modelAndView;
    }*/
}
