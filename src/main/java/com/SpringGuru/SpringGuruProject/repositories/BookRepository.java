package com.SpringGuru.SpringGuruProject.repositories;

import com.SpringGuru.SpringGuruProject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
