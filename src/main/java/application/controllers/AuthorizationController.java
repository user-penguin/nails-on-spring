package application.controllers;

import application.entities.Role;
import application.entities.User;
import application.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.Map;

@Controller
public class AuthorizationController {
    @Autowired
    private UserRepo userRepo;

//    @GetMapping("/authorization")
//    public String authorization() {
//        return "login";
//    }
//
//    @PostMapping("/authorization")
//    public String loginUser() {
//        return "login";
//    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "user already exist!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

//    @GetMapping("/logout")
//    public RedirectView logout() {
//        return new RedirectView("/");
//    }
}
