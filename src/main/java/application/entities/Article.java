package application.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    private Author author;
    private String Title;
    private String Text1;
    private String Text2;
    private Integer FirstPhotoId;
    private Integer SecondPhotoId;
    private Integer AuthorId;

    public Article(String title, String text1, String text2) {
        Title = title;
        Text1 = text1;
        Text2 = text2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText1() {
        return Text1;
    }

    public void setText1(String text1) {
        Text1 = text1;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }

    public Integer getFirstPhotoId() {
        return FirstPhotoId;
    }

    public void setFirstPhotoId(Integer firstPhotoId) {
        FirstPhotoId = firstPhotoId;
    }

    public Integer getSecondPhotoId() {
        return SecondPhotoId;
    }

    public void setSecondPhotoId(Integer secondPhotoId) {
        SecondPhotoId = secondPhotoId;
    }

    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        AuthorId = authorId;
    }

}
