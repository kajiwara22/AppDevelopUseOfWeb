package UserRegister.service;

import UserRegister.model.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by kajiwarayutaka on 2015/06/30.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginStudentDetail extends User {
    private final Student student;
    public LoginStudentDetail(Student student){
        super(student.getId(),student.getPassword(), AuthorityUtils.createAuthorityList(student.getRole()));
        this.student = student;
    }
}
