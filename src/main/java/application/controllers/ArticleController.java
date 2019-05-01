package application.controllers;

import application.entities.Article;
import application.entities.Author;
import application.repos.ArticleRepo;
import application.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @PostMapping("/article/edit_article")
    public RedirectView editArticle(
            @RequestParam String editTitle,
            @RequestParam String editText1,
            @RequestParam String editText2,
            @RequestParam Integer idArticle
    ) {
        Article article = articleRepo.findById(idArticle).get();
        article.setTitle(editTitle);
        article.setText1(editText1);
        article.setText2(editText2);
        articleRepo.save(article);
        return new RedirectView("/articleAdmin");
    }

    @GetMapping("/article/delete_article/{id}")
    public RedirectView deleteArticle(@PathVariable Integer id) {
        articleRepo.deleteById(id);
        return new RedirectView("/articleAdmin");
    }

    @PostMapping("/article/add_new_article")
    public RedirectView addNewArticle(
            @RequestParam String Title,
            @RequestParam String Text1,
            @RequestParam String Text2,
            @RequestParam Integer author
    ) {
        Article article = new Article(Title, Text1, Text2);
        article.setAuthor(authorRepo.findById(author).get());
        articleRepo.save(article);
        return new RedirectView("/articleAdmin");
    }
}
