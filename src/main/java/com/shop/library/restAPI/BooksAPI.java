package com.shop.library.restAPI;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.dto.BookDto;
import com.shop.library.model.entity.BookAuthor;
import com.shop.library.model.mapper.AuthorMapper;
import com.shop.library.model.mapper.BookMapper;
import com.shop.library.service.BookAuthorServirce;
import com.shop.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequestMapping(value="/library/books")
@RestController
public class BooksAPI {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorServirce bookAuthorServirce;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping
    public String helloWorld(){
        return "helloWorld";
    }

    @GetMapping("/{bookId}")
    public BookDto getBookById(@PathVariable(name="bookId") Integer bookId){
        return bookService.getBookById(bookId);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> getAllBooks() {
       List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }



//    @PostMapping("/create")
//    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook){
//        BookDto savedBook = bookService.createBook(newBook);
//        Set<BookAuthor> bookAuthorsReturned = bookAuthorServirce.createBookAuthor((authorMapper.toEntity((AuthorDto) newBook.getAuthors())), bookMapper.toEntity(savedBook));
//        return ResponseEntity.ok(savedBook);
//    }

//    @PostMapping("/create")
//    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook){
//        BookDto savedBook = bookService.createBook(newBook);
//        Set<BookAuthor> bookAuthorsReturned = bookAuthorServirce.createBookAuthor((AuthorDto) newBook.getAuthors(), savedBook);
//        return ResponseEntity.ok(savedBook);
//    }






    //krijon liber te ri por pa autor
//    @PostMapping("/create")
//    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook){
//        return ResponseEntity.ok(bookService.createBook(newBook));
//    }



    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBookDto) {
        BookDto createdBook = bookService.createBook(newBookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }


}
