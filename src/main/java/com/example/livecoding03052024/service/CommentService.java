package com.example.livecoding03052024.service;

import com.example.livecoding03052024.dto.request.CommentRequestDto;
import com.example.livecoding03052024.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    void insert(CommentRequestDto commentRequestDto);

    void insertMulti(List<CommentRequestDto> commentRequestDto);

    void update(Integer id, CommentRequestDto commentRequestDto);

    void delete(Integer id);

    CommentResponseDto getById(Integer id);

    List<CommentResponseDto> getAll();
}
