package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import kg.elibrary.demo.entity.Library;
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
}
