package com.lookingclowns.spring5webapp.bootstrap;

import com.lookingclowns.spring5webapp.domain.Author;
import com.lookingclowns.spring5webapp.domain.Book;
import com.lookingclowns.spring5webapp.domain.Publisher;
import com.lookingclowns.spring5webapp.repositories.AuthorRepository;
import com.lookingclowns.spring5webapp.repositories.BookRepository;
import com.lookingclowns.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public final class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author lau = new Author("Lau", "Coratge");
        Book poemarioFlores = new Book("Poemario Flores", "asa21323");
        lau.addBook(poemarioFlores);
        poemarioFlores.addAuthor(lau);
        Author lou = new Author("Lou M.", "Costa");
        Book deseos = new Book("Deseos de Brujo", "2easd34");
        lou.addBook(deseos);
        deseos.addAuthor(lou);
        Publisher publisher = new Publisher(
                "Er publicadó",
                "Calle falsa 123",
                "Ciudad de la piruleta",
                "Estado del avismo",
                "24342"
        );
        authorRepository.save(lau);
        bookRepository.save(poemarioFlores);
        authorRepository.save(lou);
        bookRepository.save(deseos);
        publisherRepository.save(publisher);

        publisher.addBook(poemarioFlores);
        publisher.addBook(deseos);
        poemarioFlores.setPublisher(publisher);
        deseos.setPublisher(publisher);

        authorRepository.save(lau);
        bookRepository.save(poemarioFlores);
        authorRepository.save(lou);
        bookRepository.save(deseos);
        publisherRepository.save(publisher);

        System.out.println("Bootstrapping data");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Published books: " + publisher.getBooks().size());
    }
}
