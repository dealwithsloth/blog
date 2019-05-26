package pl.mateusz.ministack.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @ManyToOne // jeden user moze miec wiele postow lub jeden post ma jednego usera.
    @JoinColumn(name = "user_id")//wskazujemy kolumne po ktorej ma zlaczenie z userem.
    private UserEntity user;

}
