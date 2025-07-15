package com.shop.library.repo;

import com.shop.library.model.entity.Author;
import com.shop.library.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//eshte nje implememtim i JPA (Spring JPA), eshte shtresa persistence, pra nje layer qe na ndihmon te kryejme veprime me db
//find, save, delete
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer > {

}


