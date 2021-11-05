package com.exercise.springboot.crudoperations.Repository;

import com.exercise.springboot.crudoperations.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books,Integer>{
}
