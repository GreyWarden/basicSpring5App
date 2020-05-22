package com.lookingclowns.spring5webapp.controllers;

import com.lookingclowns.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class GetAuthorListController {

    private final AuthorRepository authorRepository;

    public GetAuthorListController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors", this.authorRepository.findAll());
        return "authors/list";
    }
}
