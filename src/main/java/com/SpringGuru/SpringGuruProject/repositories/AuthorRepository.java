package com.SpringGuru.SpringGuruProject.repositories;

import com.SpringGuru.SpringGuruProject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
