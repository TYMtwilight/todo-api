package com.example.todoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.todoapi.dto.TodoDto;
import com.example.todoapi.entity.TodoEntity;
import com.example.todoapi.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    /**
     * すべてのTODOを取得
     * Entity から DTO への変換も行う
     * 
     * @return TODO一覧のDTO
     */
    public List<TodoDto> getAllTodos() {
        // Repository層からEntityのリストを取得
        List<TodoEntity> entities = todoRepository.findAll();

        // EntityをDTOに変換して返す
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * TodoEntityをTodoDtoに変換
     * データベース固有の情報（作成日時、更新日時）は除外
     * 
     * @param entity 変換元のEntity
     * @return 変換後のDTO
     */
    private TodoDto convertToDto(TodoEntity entity) {
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCompleted(entity.getCompleted());
        return dto;
    }
}
