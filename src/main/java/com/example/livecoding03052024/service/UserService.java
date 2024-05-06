package com.example.livecoding03052024.service;

import com.example.livecoding03052024.dto.request.UserRequestDto;
import com.example.livecoding03052024.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    void insert(UserRequestDto userRequestDto);

    void update(Integer id, UserRequestDto userRequestDto);

    void delete(Integer id);

    UserResponseDto getById(Integer id);

    List<UserResponseDto> getAll();
}
