package UserRegister.Controller;

import UserRegister.Repository.StudentRepository;
import UserRegister.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by KAJIWARAYutaka on 2015/05/02.
 */
@Controller
@RequestMapping(value="/")
public class ShowUserListController {
    @Autowired
    StudentRepository studentRepository;


    @RequestMapping(value="users" ,method = RequestMethod.GET)
    public String usersShow(Model model){
        List<Student> users = studentRepository.findAll();
        model.addAttribute("users",users);

        return "userList";
    }
}
