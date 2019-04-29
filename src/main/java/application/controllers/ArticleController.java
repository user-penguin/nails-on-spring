package application.controllers;

import application.entities.Article;
import application.entities.Author;
import application.repos.ArticleRepo;
import application.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/article/delete_article")
    public String deleteArticle(
            @RequestParam Integer id,
            Map<String, Object> model
    ) {

        articleRepo.deleteById(id);
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "articleAdmin";
    }

    @PostMapping("/article/add_new_article")
    public String addNewArticle(
            @RequestParam String Title,
            @RequestParam String Text1,
            @RequestParam String Text2,
            @RequestParam Integer AuthorId,
            Map<String, Object> model
    ) {
        Article article = new Article(Title, Text1, Text2);
        article.setAuthor(authorRepo.findById(AuthorId).get());

        articleRepo.save(article);
        return "articleAdmin";
    }
}
