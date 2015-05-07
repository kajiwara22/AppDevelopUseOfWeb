package UserRegister.Controller;

import UserRegister.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by KAJIWARAYutaka on 2015/05/02.
 */
@Controller
@RequestMapping(value="/")
public class UserRegistController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String pageShow(){
       return "index";
    }

    @RequestMapping(value="users" ,method = RequestMethod.GET)
    public ModelAndView usersShow(Model model){
        model.addAttribute("users",userRepository.findAll());

        return new ModelAndView("userList","model",model);
    }
}
