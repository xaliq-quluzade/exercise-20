package com.example.livecoding03052024.controller;

import com.example.livecoding03052024.dto.request.PostRequestDto;
import com.example.livecoding03052024.dto.response.PostResponseDto;
import com.example.livecoding03052024.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Validated
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponseDto> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public PostResponseDto getById(@PathVariable("id") Integer id) {
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PostRequestDto postRequestDto) {
        postService.insert(postRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody PostRequestDto postRequestDto) {
        postService.update(id, postRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }
}
