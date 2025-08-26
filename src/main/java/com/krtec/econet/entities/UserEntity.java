package com.krtec.econet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String id;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToOne
    private UserEntity created;
}
