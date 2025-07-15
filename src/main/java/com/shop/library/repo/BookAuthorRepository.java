package com.shop.library.repo;

import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import com.shop.library.model.entity.BookAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository <BookAuthor, BookAuthorId> {

}
