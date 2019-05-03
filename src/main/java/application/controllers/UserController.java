package application.controllers;

import application.entities.Author;
import application.entities.User;
import application.repos.AuthorRepo;
import application.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthorRepo authorRepo;

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
}
