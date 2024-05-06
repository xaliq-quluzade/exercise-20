package com.example.livecoding03052024.service;

import com.example.livecoding03052024.dto.request.PostRequestDto;
import com.example.livecoding03052024.dto.response.PostResponseDto;

import java.util.List;

public interface PostService {
    void insert(PostRequestDto postRequestDto);

    void update(Integer id, PostRequestDto postRequestDto);

    void delete(Integer id);

    PostResponseDto getById(Integer id);

    List<PostResponseDto> getAll();
}
