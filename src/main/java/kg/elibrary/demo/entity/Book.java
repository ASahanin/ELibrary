package kg.elibrary.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.FileReader;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "book")
public class  Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private FileReader text;
    private LocalDateTime timeOfCreate;
}
