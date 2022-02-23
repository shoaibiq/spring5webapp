package guru.springframework.spring5webapp.bootstrap;

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
        Author eric = new Author("Eric","sahab");
        Book aikThaTiger = new Book("Tiger","1234444");
        eric.getBooks().add(aikThaTiger);
        aikThaTiger.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(aikThaTiger);
        Author shoaib = new Author("Shoaib ","sahab");
        Book dars = new Book("dars","1234444");
        shoaib.getBooks().add(dars);
        dars.getAuthors().add(shoaib);

        authorRepository.save(shoaib);
        bookRepository.save(dars);

        Publisher publisher = new Publisher("testPublisher","testAddressLine1","testCity","testState","testZip");
        publisher.getBooks().add(aikThaTiger);
        publisher.getBooks().add(dars);

        publisherRepository.save(publisher);
        System.out.println("Started in BootStrap");
        System.out.println("Total Authors=" + authorRepository.count());
        System.out.println("Publisher Saved=" + publisherRepository.count());
        System.out.println("Total books published by Publisher ="+publisher.getName() +" = " + publisher.getBooks().size());

    }
}
