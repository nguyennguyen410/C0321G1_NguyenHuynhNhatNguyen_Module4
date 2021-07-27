package com.codegym.controller;

import com.codegym.exception.BookException;
import com.codegym.model.entity.Book;
import com.codegym.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("bookList", books);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) throws BookException {
        Book book = bookService.findById(id);
        if (book.getNumber() == 0) {
            throw new BookException();
        } else {
            model.addAttribute("book", bookService.findById(id));
            return "/view";
        }

    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book book, RedirectAttributes redirect) {
        Book bookBorrow = book;
        bookBorrow.setNumber(book.getNumber() - 1);
        bookService.save(bookBorrow);
        redirect.addFlashAttribute("success", "Borrow successfully!");
        return "redirect:/book/list";
    }

    @GetMapping("/searchId")
    public String searchID() {
        return "/returnBook";
    }

    @GetMapping("/return")
    public String returnBookUrl(@RequestParam String idReturn, Model model) {
        model.addAttribute("book", bookService.findById(idReturn));
        return "/returnForm";
    }

    @PostMapping("/return")
    public String returnBook(@ModelAttribute Book book, RedirectAttributes redirect) {
        Book bookReturn = book;
        bookReturn.setNumber(book.getNumber() + 1);
        bookService.save(bookReturn);
        redirect.addFlashAttribute("success", "Return successfully!");
        return "redirect:/book/list";
    }

    @ExceptionHandler(BookException.class)
    public String showError() {
        return "error";
    }
}
