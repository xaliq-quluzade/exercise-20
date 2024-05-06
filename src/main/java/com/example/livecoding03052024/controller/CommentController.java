package com.example.livecoding03052024.controller;

import com.example.livecoding03052024.dto.request.CommentRequestDto;
import com.example.livecoding03052024.dto.response.CommentResponseDto;
import com.example.livecoding03052024.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Validated
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentResponseDto> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public CommentResponseDto getById(@PathVariable("id") Integer id) {
        return commentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody CommentRequestDto commentRequestDto) {
        commentService.insert(commentRequestDto);
    }

    @PostMapping("/multi")
    public void insert(@Valid @RequestBody List<CommentRequestDto> comments) {
        if (comments.size() > 5 || comments.size() < 2) {
            throw new RuntimeException();
        }
        commentService.insertMulti(comments);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody CommentRequestDto commentRequestDto) {
        commentService.update(id, commentRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        commentService.delete(id);
    }
}
