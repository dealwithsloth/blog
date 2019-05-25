package pl.mateusz.ministack.model.form;

import lombok.Data;

@Data
public class LoginForm {
    private String email;
    private String password;
}