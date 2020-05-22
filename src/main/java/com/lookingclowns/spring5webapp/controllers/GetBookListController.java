package com.lookingclowns.spring5webapp.controllers;

import com.lookingclowns.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class GetBookListController {
    private final BookRepository bookRepository;

    public GetBookListController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", this.bookRepository.findAll());
        return "books/list";
    }
}
