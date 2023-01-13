package com.SpringGuru.SpringGuruProject.bootstrap;

import com.SpringGuru.SpringGuruProject.domain.Author;
import com.SpringGuru.SpringGuruProject.domain.Book;
import com.SpringGuru.SpringGuruProject.domain.Publisher;
import com.SpringGuru.SpringGuruProject.repositories.AuthorRepository;
import com.SpringGuru.SpringGuruProject.repositories.BookRepository;
import com.SpringGuru.SpringGuruProject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Publisher webster = new Publisher();
        webster.setName("Webster");
        webster.setState("California");
        webster.setAddress1("New road");
        webster.setCity("new orlands");
        webster.setZip("1234");
        publisherRepository.save(webster);

        Book mastery = new Book();
        mastery.setTitle("Mastery");
        mastery.setIsbn("mas123");

        Author robert = new Author();
        robert.setFirstName("Robert");
        robert.setLastName("Green");

        mastery.getAuthors().add(robert);
        robert.getBooks().add(mastery);
        mastery.setPublisher(webster);
        webster.getBooks().add(mastery);

        mastery.setPublisher(webster);
        webster.getBooks().add(mastery);

        authorRepository.save(robert);
        bookRepository.save(mastery);
        publisherRepository.save(webster);

        System.out.println("number of books by webster : " + webster.getBooks().size());
        System.out.println("number of books by robert : " + robert.getBooks().size());
        System.out.println("number of authors : " + authorRepository.count());
    }
}
