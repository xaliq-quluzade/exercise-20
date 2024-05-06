package com.example.livecoding03052024.service.impl;

import com.example.livecoding03052024.dto.request.PostRequestDto;
import com.example.livecoding03052024.dto.response.PostResponseDto;
import com.example.livecoding03052024.model.Post;
import com.example.livecoding03052024.repository.PostRepository;
import com.example.livecoding03052024.repository.UserRepository;
import com.example.livecoding03052024.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void insert(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setTitle(postRequestDto.title());
        post.setContent(postRequestDto.content());
        post.setCreatedDate(LocalDateTime.now());
        post.setUser(userRepository.findById(postRequestDto.userId()).orElseThrow());
        postRepository.save(post);
    }

    @Override
    public void update(Integer id, PostRequestDto postRequestDto) {
        Post post = postRepository
                .findById(id)
                .orElseThrow();
        post.setTitle(postRequestDto.title());
        post.setContent(postRequestDto.content());
        post.setId(id);
        postRepository.save(post);
    }

    @Override
    public void delete(Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow();
        postRepository.delete(post);
    }

    @Override
    public PostResponseDto getById(Integer id) {
        return postRepository.findById(id)
                .map(post -> new PostResponseDto(post.getTitle(), post.getContent(), post.getCreatedDate()))
                .orElseThrow();
    }

    @Override
    public List<PostResponseDto> getAll() {
        List<PostResponseDto> postResponseDtoList = postRepository.findAll()
                .stream()
                .map(post -> new PostResponseDto(post.getTitle(), post.getContent(), post.getCreatedDate()))
                .toList();

        return postResponseDtoList;
    }
}
