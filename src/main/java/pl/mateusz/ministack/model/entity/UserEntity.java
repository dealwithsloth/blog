package pl.mateusz.ministack.model.entity;

import lombok.Data;
import pl.mateusz.ministack.model.form.RegisterForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String nickname;
    //@Column(name = "password_user")
    private String password;

    public UserEntity() {
    }

    public UserEntity(RegisterForm registerForm) {
        this.email = registerForm.getEmail();
        this.nickname = registerForm.getNickname();
        this.password = registerForm.getPassword();
    }

}
