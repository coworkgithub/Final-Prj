package com.project.boardback.service;

import org.springframework.http.ResponseEntity;

import com.project.boardback.dto.request.auth.SignInRequestDto;
import com.project.boardback.dto.request.auth.SignUpRequestDto;
import com.project.boardback.dto.response.auth.SignInResponseDto;
import com.project.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
