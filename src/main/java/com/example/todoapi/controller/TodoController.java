package com.example.todoapi.controller;

import com.example.todoapi.generated.api.TodosApi;
import com.example.todoapi.generated.model.Todo;
import com.example.todoapi.generated.model.TodoListResponse;
import com.example.todoapi.service.TodoService;
import com.example.todoapi.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO関連のAPIエンドポイントを処理するControllerクラス
 * OpenAPIで生成されたTodosApiインターフェースを実装
 */
@RestController
@RequiredArgsConstructor
public class TodoController implements TodosApi {

    private final TodoService todoService;

    /**
     * TODO一覧を取得するAPIエンドポイント
     * 
     * @return TODO一覧のレスポンス
     */
    @Override
    public ResponseEntity<TodoListResponse> getTodos() {
        // サービス層からTODO一覧を取得
        List<TodoDto> todoDtos = todoService.getAllTodos();

        // DTOをOpenAPI生成モデルに変換
        List<Todo> todos = todoDtos.stream()
                .map(this::convertToApiModel)
                .collect(Collectors.toList());

        // レスポンスオブジェクトを作成
        TodoListResponse response = new TodoListResponse();
        response.setTodos(todos);

        return ResponseEntity.ok(response);
    }

    /**
     * TodoDtoをOpenAPI生成のTodoモデルに変換
     * 
     * @param dto 変換元のDTO
     * @return 変換後のAPIモデル
     */
    private Todo convertToApiModel(TodoDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.getCompleted());
        return todo;
    }
}