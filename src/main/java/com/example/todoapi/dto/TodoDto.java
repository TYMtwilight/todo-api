package com.example.todoapi.dto;

import lombok.Data;

/**
 * TODO のDTO（Data Transfer Object）
 * サービス層とコントローラー層の間でデータを転送するために使用
 */
@Data
public class TodoDto {

    /**
     * TODO ID
     */
    private Long id;

    /**
     * TODOのタイトル
     */
    private String title;

    /**
     * 完了状態（true: 完了, false: 未完了）
     */
    private Boolean completed;
}
