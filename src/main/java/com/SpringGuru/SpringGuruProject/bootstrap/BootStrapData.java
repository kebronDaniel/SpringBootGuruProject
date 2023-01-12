package com.SpringGuru.SpringGuruProject.bootstrap;

import com.SpringGuru.SpringGuruProject.domain.Author;
import com.SpringGuru.SpringGuruProject.domain.Book;
import com.SpringGuru.SpringGuruProject.repositories.AuthorRepository;
import com.SpringGuru.SpringGuruProject.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book firstJohn = new Book("1John","62");

        Author john = new Author("John","Jr");
        john.getBooks().add(firstJohn);

        firstJohn.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(firstJohn);

        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Number of Authors " + authorRepository.count());

    }
}
