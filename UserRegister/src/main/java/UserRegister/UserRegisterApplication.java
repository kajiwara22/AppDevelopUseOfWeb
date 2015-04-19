package UserRegister;

import UserRegister.Repository.UserRepository;
import UserRegister.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserRegisterApplication implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserRegisterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Student student = new Student();
        student.setId(20511091);
        student.setName("かじわら ゆたか");
        userRepository.save(student);

    }
}
