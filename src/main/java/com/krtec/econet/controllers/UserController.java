package com.krtec.econet.controllers;

import com.krtec.econet.controllers.global.BaseCrudController;
import com.krtec.econet.entities.UserEntity;
import com.krtec.econet.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
@RequestMapping("/public/user")
@AllArgsConstructor
public class UserController extends BaseCrudController<UserEntity, String> {
    private UserRepository userRepository;

    @Override
    protected JpaRepository<UserEntity, String> getRepository() {
        return userRepository;
    }
}
