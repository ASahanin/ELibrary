package kg.elibrary.demo.entity;

import javax.persistence.*;

@Entity
@Table (name = "book")
public class  Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
}
