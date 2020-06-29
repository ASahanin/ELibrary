package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import kg.elibrary.demo.entity.Library;
import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{
    @Override
    public Library create(Library library) {
        return null;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book getByName(String name) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> sortByName() {
        return null;
    }

    @Override
    public List<Book> sortByDate() {
        return null;
    }

    @Override
    public Book deleteById(Long id) {
        return null;
    }

    @Override
    public Book deleteAll(List<Book> books) {
        return null;
    }

    @Override
    public Book sendTo(Book book, String email) {
        return null;
    }
}
