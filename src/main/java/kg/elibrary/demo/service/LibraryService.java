package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import kg.elibrary.demo.entity.Library;

import java.util.List;

public interface LibraryService {
    Library create (Library library);
    Book getById(Long id);
    Book getByName(String name);
    List<Book>getAll();
}
