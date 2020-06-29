package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import org.apache.tomcat.jni.File;


public interface BookService {
    Book create(Book book);
    Book read(Book book);
    Book edit(Book book);
    Book download(File file);

}
