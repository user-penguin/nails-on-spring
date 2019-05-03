package application.controllers;

import application.entities.Article;
import application.entities.Author;
import application.entities.User;
import application.repos.ArticleRepo;
import application.repos.AuthorRepo;
import application.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private UserRepo  userRepo;

    @GetMapping("/")
    public String main (Authentication authentication, Map<String, Object> model) {
        if (authentication != null) {
            if (authentication.isAuthenticated()) {
                return "redirect:/main";
            }
        }
        return "index";
    }

    @GetMapping("/main")
    public String mainPage(Authentication authentication, Map<String, Object> model) {
        model.put("user_name", authentication.getName());
        return "main";
    }

    // @TODO запилить страничку обзора и редактирования профиля
    @PostMapping("/userInfo")
    public String getUserInfo(Authentication authentication, Map<String, Object> model) {
        User user = userRepo.findByUsername(authentication.getName());
        Author author = user.getAuthor();
        model.put("author", author);
        return "userInfo";
    }

    @PostMapping("/editUserInfo")
    public ModelAndView editUserInfo(@RequestParam String EditName,
                                     @RequestParam String EditSecName,
                                     @RequestParam String EditEmail,
                                     @RequestParam String EditPhone,
                                     @RequestParam Integer EditRanking,
                                     @RequestParam Integer EditPrice,
                                     @RequestParam String EditMission,
                                     @RequestParam String EditMainText,
                                     Authentication authentication,
                                     HttpServletRequest request
    ) {
        User user = userRepo.findByUsername(authentication.getName());
        Author author = user.getAuthor();

        author.setName(EditName);
        author.setSecName(EditSecName);
        author.setEmail(EditEmail);
        author.setPhone(EditPhone);
        author.setRanking(EditRanking);
        author.setPrice(EditPrice);
        author.setMainText(EditMainText);
        author.setMission(EditMission);

        authorRepo.save(author);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);

        return new ModelAndView("redirect:/userInfo");
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
