package UserRegister.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by KAJIWARAYutaka on 2015/04/18.
 */
@Data
@Entity
@Table
public class Student {
    @javax.persistence.Id
    private int id;
    private String Name;
}
