package com.springpractice.spring_web_app.bootstrap;

import com.springpractice.spring_web_app.model.Author;
import com.springpractice.spring_web_app.model.Book;
import com.springpractice.spring_web_app.model.Publisher;
import com.springpractice.spring_web_app.repositories.AuthorRepository;
import com.springpractice.spring_web_app.repositories.BookRepository;
import com.springpractice.spring_web_app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("Pearson Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author hardik = new Author("Hardik","Kumar Singh");
        Book book = new Book( "123123","Domain Driven Design");
        hardik.getBooks().add(book);
        book.getAuthors().add(hardik);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(hardik);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author sambhav = new Author("Sambhav","Sharma");
        Book noEJB = new Book( "123123","J2EE Development without EJB");
        sambhav.getBooks().add(noEJB);
        noEJB.getAuthors().add(sambhav);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(sambhav);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());


    }
}
