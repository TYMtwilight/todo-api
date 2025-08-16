package com.example.todoapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.todoapi.entity.TodoEntity;

/**
 * TODOデータアクセス用のRepositoryインターフェース
 * MyBatisのMapperアノテーションを使用してSQL操作を実行
 */
@Mapper
public interface TodoRepository {

    /**
     * 全てのTODOを取得
     * 作成日時の降順（新しいものから）で並び替え
     * 
     * @return TODO一覧
     */
    @Select("SELECT id, title, completed, created_at, updated_at FROM todos ORDER BY created_at DESC")
    List<TodoEntity> findAll();
}
