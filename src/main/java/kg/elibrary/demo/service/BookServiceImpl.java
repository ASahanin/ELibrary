package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.Book;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tomcat.jni.File;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class BookServiceImpl implements BookService{
    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book read(Book book) {
        return null;
    }

    @Override
    public Book edit(Book book) {
        return null;
    }

    @Override
    public Book download(File file) {
        return null;
    }

    @Override
    public Book generateHTMLFromPDF(String filename) throws IOException, ParserConfigurationException {
            PDDocument pdf = PDDocument.load(new File(filename));
            Writer output = new PrintWriter("src/output/pdf.html", StandardCharsets.UTF_8);
            new PDFDomTree().writeText(pdf, output);
            output.close();
            return null;
        }
}
