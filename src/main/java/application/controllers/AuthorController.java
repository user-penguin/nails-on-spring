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

import java.util.Map;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping("/author/delete_author/{id}")
    public RedirectView deleteAuthor(@PathVariable Integer id) {
        Iterable<Article> articles = articleRepo.findAll();
        for (Article article: articles) {
            if (article.getAuthor().getId() == id) {
                articleRepo.delete(article);
            }
        }
        authorRepo.deleteById(id);
        return new RedirectView("/authorAdmin");
    }

    @PostMapping("/author/edit_author")
    public RedirectView editAuthor(
            @RequestParam String EditName,
            @RequestParam String EditSecName,
            @RequestParam String EditEmail,
            @RequestParam String EditPhone,
            @RequestParam Integer EditRanking,
            @RequestParam Integer EditPrice,
            @RequestParam String EditMission,
            @RequestParam String EditMainText,
            @RequestParam Integer idAuthor
    ) {
       Author author = authorRepo.findById(idAuthor).get();
       author.setName(EditName);
       author.setSecName(EditSecName);
       author.setEmail(EditEmail);
       author.setPhone(EditPhone);
       author.setRanking(EditRanking);
       author.setPrice(EditPrice);
       author.setMission(EditMission);
       author.setMainText(EditMainText);
       authorRepo.save(author);
       return new RedirectView("/authorAdmin");
    }

    @PostMapping("/author/add_new_author")
    public RedirectView addNewAuthor(
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
        return new RedirectView("/authorAdmin");
    }
}
