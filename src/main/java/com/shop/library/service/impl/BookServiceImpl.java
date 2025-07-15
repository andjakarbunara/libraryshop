package com.shop.library.service.impl;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.dto.BookDto;
import com.shop.library.model.entity.Author;
import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import com.shop.library.model.mapper.AuthorMapper;
import com.shop.library.model.mapper.BookAuthorMapper;
import com.shop.library.model.mapper.BookMapper;
import com.shop.library.repo.AuthorRepository;
import com.shop.library.repo.BookAuthorRepository;
import com.shop.library.repo.BookRepository;
import com.shop.library.service.AuthorService;
import com.shop.library.service.BookAuthorServirce;
import com.shop.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookAuthorServirce bookAuthorServirce;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

//    @Override
//    public BookDto getBookById(Integer bookId) {
//        Optional<Book> book = bookRepository.findById(bookId);
//        return book.map(value -> bookMapper.toDto(value)).orElse(null);
//    }

    @Override
    public BookDto getBookById(Integer bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.map(value -> {
            BookDto bookDto = bookMapper.toDto(value);
            bookDto.setAuthors(value.getBookauthors().stream()
                    .map(bookAuthor -> authorMapper.toDto(bookAuthor.getAuthor()))
                    .collect(Collectors.toSet()));
            return bookDto;
        }).orElse(null);
    }


//    @Override
//    public List<BookDto> getAllBooks() {
//        List<Book> books = bookRepository.findAll();
//        List<BookDto> bookDtoList = new ArrayList<>();
//        books.forEach(book -> bookDtoList.add(bookMapper.toDto(book)));
//        return bookDtoList;
//    }


    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        // Map each Book entity to BookDto
        List<BookDto> bookDtoList = books.stream().map(book -> {
            BookDto bookDto = bookMapper.toDto(book);

            Set<AuthorDto> authors = book.getBookauthors().stream()
                    .map(bookAuthor -> authorMapper.toDto(bookAuthor.getAuthor()))
                    .collect(Collectors.toSet());
            bookDto.setAuthors(authors);
            return bookDto;
        }).collect(Collectors.toList());

        return bookDtoList;
    }


//    @Override   e sakte por me autor
//    public BookDto createBook(BookDto newBookDto) {
//        Book book = bookMapper.toEntity(newBookDto);
//        Set<BookAuthor> bookAuthors = new HashSet<>();
//
//        if (newBookDto.getAuthors() != null) {
//            for (AuthorDto authorDto : newBookDto.getAuthors()) {
//                AuthorDto authorReturned;
//                if (authorDto.getAuthorid() != null) {
//                    authorReturned = authorService.getAuthorById(authorDto.getAuthorid());
//                } else {
//                    authorReturned = authorService.createAuthor(authorDto);
//                }
//                if (authorReturned != null) {
//                    BookAuthor bookAuthor = new BookAuthor();
//                    bookAuthor.setAuthor(authorMapper.toEntity(authorReturned));
//                    bookAuthor.setBook(book);
//                    bookAuthors.add(bookAuthor);
//                }
//            }
//        }
//
//        book.setBookauthors(bookAuthors);
//        Book savedBook = bookRepository.save(book);
//
//        return bookMapper.toDto(savedBook);
//    }







//    @Override             e sakte por dua ta optimizoj bookauthor
//    @Transactional
//    public BookDto createBook(BookDto newBookDto) {
//        Book book = bookMapper.toEntity(newBookDto);
//        Set<BookAuthor> bookAuthors = new HashSet<>();
//        Set<AuthorDto> authors = new HashSet<>();
//
//        if (newBookDto.getAuthors() != null) {
//            for (AuthorDto authorDto : newBookDto.getAuthors()) {
//                AuthorDto authorReturned = null;
//
//                if (authorDto.getAuthorid() != null) {
//                    authorReturned = authorService.getAuthorById(authorDto.getAuthorid());
//
//                    if (authorReturned == null) {
//                        throw new RuntimeException("Author with ID " + authorDto.getAuthorid() + " not found.");
//                    }
//                } else if (authorDto.getName() != null) {
//                    authorReturned = authorService.createAuthor(authorDto);
//                }
//                if(authorReturned != null){
//                    authors.add(authorReturned);
//                }
//            }
//        }
//
//
//        Book savedBook = bookRepository.save(book);
//        authors.forEach(authorDto -> {
//            BookAuthor bookAuthor = new BookAuthor();
//            bookAuthor.setAuthor(authorMapper.toEntity(authorDto));
//            bookAuthor.setBook(savedBook);
//            bookAuthors.add(bookAuthor);
//        });
//
//        Set<BookAuthor> bookAuthorsReturned = new HashSet<>(bookAuthorRepository.saveAll(bookAuthors));
//
//        book.setBookauthors(bookAuthorsReturned);
//        return bookMapper.toDto(savedBook);
//    }



    @Transactional
    public BookDto createBook(BookDto newBookDto) {
        Book book = bookMapper.toEntity(newBookDto);

        // Gjej ose krijo autorët
        Set<AuthorDto> resolvedAuthors = Optional.ofNullable(newBookDto.getAuthors())
                .orElse(Collections.emptySet())
                .stream()
                .map(authorDto -> {
                    if (authorDto.getAuthorid() != null) {
                        return Optional.ofNullable(authorService.getAuthorById(authorDto.getAuthorid()))
                                .orElseThrow(() -> new RuntimeException("Author with ID " + authorDto.getAuthorid() + " not found."));
                    } else if (authorDto.getName() != null) {
                        return authorService.createAuthor(authorDto);
                    } else {
                        throw new RuntimeException("Author must have either ID or name.");
                    }
                })
                .collect(Collectors.toSet());


        // Ruaj librin fillimisht
        Book savedBook = bookRepository.save(book);

        // Lidh librin me autorët
        Set<BookAuthor> bookAuthors = bookAuthorMapper.toEntity(resolvedAuthors, savedBook);
        bookAuthorRepository.saveAll(bookAuthors);
        savedBook.setBookauthors(bookAuthors);


        bookAuthorRepository.saveAll(bookAuthors);
        savedBook.setBookauthors(bookAuthors);

        return bookMapper.toDto(savedBook);
    }



}