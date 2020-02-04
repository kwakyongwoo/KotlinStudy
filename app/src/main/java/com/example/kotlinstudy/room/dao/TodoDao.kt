package com.example.kotlinstudy.room.dao

import androidx.room.*
import com.example.kotlinstudy.room.entitiy.TodoItem

@Dao
interface TodoDao {
    @Insert
    fun insertTodo(item: TodoItem)

    @Delete
    fun deleteTodo(item: TodoItem)

    @Update
    fun updateTodo(item: TodoItem)

    @Query("SELECT * FROM todo")
    fun getTodos(): List<TodoItem>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodo(id: Int): TodoItem
}