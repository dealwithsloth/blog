package pl.mateusz.ministack.model.form;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {
    @Pattern(regexp = ".{5,30}", message = "Nickname musi zawierać od 5 do 30 znaków." )
    private String nickname;
    @Pattern(regexp = ".+@.+\\..{2,5}", message = "Wpisz adres e-mail zgodnie ze standardem.")
    private String email;
    @Size(min = 6, max = 30, message = "Hasło powinno się składać z przynajmniej 6 znaków, maksymalnie 30.")
    private String password;
}