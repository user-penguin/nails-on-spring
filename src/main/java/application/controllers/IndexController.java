package application.controllers;

import application.entities.Article;
import application.entities.Author;
import application.repos.ArticleRepo;
import application.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/")
    public String main (Map<String, Object> model) {
        return "index";
    }

    @GetMapping("/articleAdmin")
    public String articleAdmin(Map<String, Object> model) {
        Iterable<Article> articles = articleRepo.findAll();
        Iterable<Author> authors = authorRepo.findAll();
        model.put("articles", articles);
        model.put("authors", authors);
        return "articleAdmin";
    }

    @GetMapping("/authorAdmin")
    public String authorAdmin(Map<String, Object> model) {
        Iterable<Author> authors = authorRepo.findAll();
        model.put("authors", authors);
        return "authorAdmin";
    }
}
