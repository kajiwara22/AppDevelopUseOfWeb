package UserRegister;

import UserRegister.Repository.StudentRepository;
import UserRegister.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StudentRegisterApplication implements CommandLineRunner{
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentRegisterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Student student = new Student();
        //Create
        student.setId("20511091");
        student.setName("かじわら ゆたか");
        studentRepository.save(student);
        //Select(Read)
        student = studentRepository.findOne("20511091");
        System.out.println("User ID = " + student.getId());
        System.out.println("User Name = " + student.getName());

        //Update
        student.setName("梶原 裕");
        studentRepository.save(student);
        //Select
        student = studentRepository.findOne("20511091");
        System.out.println("User ID = " + student.getId());
        System.out.println("User Name = " + student.getName());

        //Delete
        System.out.println("Delete User ? y/N");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equals("y")){
            studentRepository.delete(student);
        }

    }
}
