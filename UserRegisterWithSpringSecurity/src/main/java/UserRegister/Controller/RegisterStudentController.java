package UserRegister.Controller;

import UserRegister.Repository.StudentRepository;
import UserRegister.model.Student;
import UserRegister.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users/register")
public class RegisterStudentController {
    @Autowired
    StudentRepository studentRepository;

    @ModelAttribute
    StudentForm setupForm(){
        return new StudentForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
        return "userRegister";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Validated StudentForm studentForm,BindingResult result){
        if(result.hasErrors()){
            return showPage();
        }
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = studentForm.getPassword();
        student.setPassword((bCryptPasswordEncoder.encode(password)));
        studentRepository.save(student);
        return "redirect:/";
    }

}
