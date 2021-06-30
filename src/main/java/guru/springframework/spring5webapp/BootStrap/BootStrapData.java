package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book boook = new Book("Ddfigg", "13123");

        eric.getBooks().add(boook);
        boook.getAuthors().add(eric);

        publisher.getBooks().add(boook);
        boook.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(boook);
        publisherRepository.save(publisher);

        Author john =  new Author ("John", "Flanagan");
        Book King = new Book ("The way of kings", "asdsads");

        john.getBooks().add(King);
        King.getAuthors().add(john);

        King.setPublisher(publisher);
        publisher.getBooks().add(King);

        authorRepository.save(john);
        bookRepository.save(King);
        publisherRepository.save(publisher);


        System.out.println("Numbers of book: " +  bookRepository.count());
        System.out.println("Publisher numer of books: " + publisher.getBooks().size());

    }
}
