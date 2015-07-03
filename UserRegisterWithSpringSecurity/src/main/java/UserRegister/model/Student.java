package UserRegister.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by KAJIWARAYutaka on 2015/04/18.
 */
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @javax.persistence.Id
    @Column(length = 10 )
    private String id;
    private String name;

    private String password;

    private String role = "ROLE_USER";
}
