package com.example.livecoding03052024.service.impl;

import com.example.livecoding03052024.dto.request.CommentRequestDto;
import com.example.livecoding03052024.dto.response.CommentResponseDto;
import com.example.livecoding03052024.model.Comment;
import com.example.livecoding03052024.repository.CommentRepository;
import com.example.livecoding03052024.repository.PostRepository;
import com.example.livecoding03052024.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public void insert(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment();
        comment.setContent(commentRequestDto.content());
        comment.setCreatedDate(LocalDateTime.now());
        comment.setPost(postRepository.findById(commentRequestDto.postId()).orElseThrow());
        commentRepository.save(comment);
    }

    @Override
    public void insertMulti(List<CommentRequestDto> commentRequestDtoList) {
        List<Comment> commentList = commentRequestDtoList
                .stream()
                .map(comment -> new Comment(null, comment.content(), LocalDateTime.now(), postRepository.findById(comment.postId()).orElseThrow()))
                .toList();

        commentRepository.saveAll(commentList);
    }

    @Override
    public void update(Integer id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository
                .findById(id)
                .orElseThrow();
        comment.setContent(commentRequestDto.content());
        comment.setId(id);
        commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow();
        commentRepository.delete(comment);
    }

    @Override
    public CommentResponseDto getById(Integer id) {
        return commentRepository.findById(id)
                .map(comment -> new CommentResponseDto(comment.getContent(), comment.getCreatedDate()))
                .orElseThrow();
    }

    @Override
    public List<CommentResponseDto> getAll() {
        List<CommentResponseDto> commentResponseDtoList = commentRepository.findAll()
                .stream()
                .map(comment -> new CommentResponseDto(comment.getContent(), comment.getCreatedDate()))
                .toList();

        return commentResponseDtoList;
    }
}
