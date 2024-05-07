package com.example.livecoding03052024.service.impl;

import com.example.livecoding03052024.dto.request.UserRequestDto;
import com.example.livecoding03052024.dto.response.UserPostResponseDto;
import com.example.livecoding03052024.dto.response.UserResponseDto;
import com.example.livecoding03052024.model.User;
import com.example.livecoding03052024.repository.UserRepository;
import com.example.livecoding03052024.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void insert(UserRequestDto userRequestDto) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        userRepository.save(user);
    }

    @Override
    public void update(Integer id, UserRequestDto userRequestDto) {
        User user = userRepository
                .findById(id)
                .orElseThrow();
        BeanUtils.copyProperties(userRequestDto, user);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public UserResponseDto getById(Integer id) {
        return userRepository.findById(id)
                .map(user -> new UserResponseDto(user.getUsername(), user.getEmail(),
                        new UserPostResponseDto(
                                user.getPost().getTitle(),
                                user.getPost().getContent(),
                                user.getPost().getCreatedDate())))
                .orElseThrow();
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtoList = userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDto(user.getUsername(), user.getEmail(), new UserPostResponseDto(
                        user.getPost().getTitle(),
                        user.getPost().getContent(),
                        user.getPost().getCreatedDate())))
                .toList();

        return userResponseDtoList;
    }
}
