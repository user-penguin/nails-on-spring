package application.controllers;

import application.entities.Article;
import application.repos.ArticleRepo;
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

    @GetMapping("/article/delete_article")
    public String deleteArticle(
            @RequestParam Integer id,
            Map<String, Object> model
    ) {

        articleRepo.deleteById(Long.valueOf(id));
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "articleAdmin";
    }

//    @PostMapping("/article/add_new_article")
//    public String addNewArticle(
//            @RequestParam String Name,
//            @RequestParam String SecName
//    ) {
//        return "articleAdmin";
//    }
}
