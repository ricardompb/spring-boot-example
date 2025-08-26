package com.krtec.econet.controllers;

import com.krtec.econet.dtos.user.SiginDTO;
import com.krtec.econet.dtos.user.TokenDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/auth")
public class AuthController {
    @PostMapping("/signin")
    public ResponseEntity<TokenDTO> SingIn(@RequestBody @Valid SiginDTO input) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new TokenDTO("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30"));
    }
}
