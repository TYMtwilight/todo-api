package com.example.todoapi.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * TODOのエンティティクラス
 * データベースのtodosテーブルと対応する
 */
@Data
public class TodoEntity {

    /**
     * TODO ID（主キー）
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

    /**
     * 作成日時
     */
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    private LocalDateTime updatedAt;
}
