package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
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

        Author eric = new Author("Eric", "Evans");
        Book boook = new Book("Ddfigg", "13123");

        eric.getBooks().add(boook);
        boook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(boook);

        Author john =  new Author ("John", "Flanagan");
        Book King = new Book ("The way of kings", "asdsads");

        john.getBooks().add(King);
        King.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(King);

        System.out.println("Started in BootStrap");
        System.out.println("Numbers of book: " +  bookRepository.count());

    }
}
