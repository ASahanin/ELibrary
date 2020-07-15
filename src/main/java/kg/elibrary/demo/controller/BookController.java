package kg.elibrary.demo.controller;

import com.itextpdf.text.PageSize;
import kg.elibrary.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;

@RestController
@RequestMapping("/library/book")
public class BookController {

    @Autowired
    private BookService bookService;



}
