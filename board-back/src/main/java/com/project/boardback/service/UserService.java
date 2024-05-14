package com.project.boardback.service;

import org.springframework.http.ResponseEntity;

import com.project.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser (String email);
    
}
