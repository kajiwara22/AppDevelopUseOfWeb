package UserRegister.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by KAJIWARAYutaka on 2015/05/09.
 */
@Data
public class StudentForm {
    @NotNull
    private String name;
    @NotNull
    private Integer id;
}
