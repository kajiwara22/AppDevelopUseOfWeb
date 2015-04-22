package UserRegister.Resource;

import UserRegister.Repository.UserRepository;
import UserRegister.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="students",method = RequestMethod.GET)
    List<Student> studentList(){
        return userRepository.findAll();
    }
}
