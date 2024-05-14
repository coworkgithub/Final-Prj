package com.project.boardback.service.implement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.boardback.dto.response.ResponseDto;
import com.project.boardback.dto.response.user.GetSignInUserResponseDto;
import com.project.boardback.entity.UserEntity;
import com.project.boardback.repository.UserRepository;
import com.project.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
       
        UserEntity userEntity = null;
    
    try {

        userEntity = userRepository.findByEmail(email);
        if (userEntity == null) return GetSignInUserResponseDto.notExistUser();

    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }

    return GetSignInUserResponseDto.success(userEntity);

    }
    

    
}
