package com.krtec.econet.services;

import com.krtec.econet.dtos.global.MessageDTO;
import com.krtec.econet.dtos.user.UserCreateReqDto;
import com.krtec.econet.dtos.user.UserListResDto;
import com.krtec.econet.entities.UserEntity;
import com.krtec.econet.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<MessageDTO> create(UserCreateReqDto body) {
        if (userRepository.existsByEmail(body.email())) {
            throw new EntityExistsException("Usuário já cadastrado");
        }

        UserEntity user = new UserEntity();
        user.setEmail(body.email());
        user.setPassword(body.password());
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO("Usuário criado com sucesso"));
    }

    public List<UserListResDto> GetAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserListResDto(
                        user.getId(),
                        user.getEmail()
                ))
                .toList();
    }
}
