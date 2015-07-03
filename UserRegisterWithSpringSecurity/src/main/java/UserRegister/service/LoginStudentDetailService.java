package UserRegister.service;

import UserRegister.Repository.StudentRepository;
import UserRegister.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kajiwarayutaka on 2015/06/30.
 */
@Service
public class LoginStudentDetailService implements UserDetailsService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Student student = studentRepository.findOne(userId);
        if(student == null){
            throw new UsernameNotFoundException("このユーザーは見つかりませんでした。");
        }
        return new LoginStudentDetail(student);
    }


}
