package com.project.boardback.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.boardback.dto.request.auth.SignInRequestDto;
import com.project.boardback.dto.request.auth.SignUpRequestDto;
import com.project.boardback.dto.response.auth.SignUpResponseDto;
import com.project.boardback.dto.response.auth.SignInResponseDto;
import com.project.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
        
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody)
        {
            ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
            return response;
        }
    
}
