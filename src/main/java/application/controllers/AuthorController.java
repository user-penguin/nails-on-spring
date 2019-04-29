package application.controllers;

import application.entities.Author;
import application.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class AuthorController {
    @Autowired
    private AuthorRepo authorRepo;

    @PostMapping("/author/add_new_author")
    public String addNewAuthor(
            @RequestParam String Name,
            @RequestParam String SecName,
            @RequestParam String Email,
            @RequestParam String Phone,
            @RequestParam Integer Ranking,
            @RequestParam Integer Price,
            @RequestParam String Mission,
            @RequestParam String MainText,
            Map<String, Object> model
    ) {
        Author author = new Author(Name, SecName, Email, Phone, Ranking, Price, Mission, MainText);
        authorRepo.save(author);
        return "authorAdmin";
    }
}
