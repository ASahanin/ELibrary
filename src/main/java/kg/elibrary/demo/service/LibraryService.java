package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import kg.elibrary.demo.entity.Library;
import kg.elibrary.demo.entity.User;
import org.apache.tomcat.jni.File;

import java.util.List;

public interface LibraryService {
    Library create (Library library);
    Book getById(Long id);
    Book getByName(String name);
    List<Book>getAll();
    List<Book> sortByName();
    List<Book> sortByDate();
    Book deleteById(Long id);
    Book deleteAll(List<Book> books);
    Book sendTo (Book book, String email);
}
