package com.example.service;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.Publisher;
import com.example.mapper.BookMapper;
import com.example.model.BookDto;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

    public ResponseEntity<List<BookDto>> getAllBooks(){

        //bookrepository.findall get only first element from list and return it
        List<Book> all = bookRepository.findAll();//
        all.removeFirst();

        //return all;
        return ResponseEntity.ok(all.stream()
                .map(bookMapper::toBookDto)
                .toList());

    }

    public ResponseEntity<BookDto> getBookById(long id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Book bookEntity = book.get();
//        return ResponseEntity.ok(new BookDto(bookEntity.getTitle(), bookEntity.getPublicationYear(),
//                bookEntity.getAuthor().getName(),bookEntity.getPublisher().getName()));
        return ResponseEntity.ok(bookMapper.toBookDto(bookEntity));
    }

    public ResponseEntity<Long> addBook(BookDto bookDto){

        Optional<Publisher> publisher =publisherRepository.findByName(bookDto.getPublisher());
        Optional<Author> author =authorRepository.findByName(bookDto.getAuthor());


        if( publisher.isPresent() && author.isPresent()) {

            Publisher publisher1 = publisher.get();
            Author author1 = author.get();

            Book book = bookMapper.toBook(bookDto, publisher1,author1);
            // Book book = new Book(null, bookDto.getTitle(),bookDto.getPublicationYear(),author1,publisher1);

            return ResponseEntity.ok().body(bookRepository.save(book).getId());

        }
        return ResponseEntity.notFound().build();
    }
}
