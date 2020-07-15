package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import org.apache.tomcat.jni.File;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public interface BookService {
    Book create(Book book);
    Book read(Book book);
    Book edit(Book book);
    Book download(File file);
    Book generateHTMLFromPDF(String filename) throws IOException, ParserConfigurationException;

}
