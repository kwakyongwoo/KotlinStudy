package com.example.kotlinstudy.main

import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.room.entitiy.TodoItem
import kotlinx.android.synthetic.main.item_todo.view.*

class MainTodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onbind(item: TodoItem) {
        itemView.todo_cb.isChecked = item.checked.also {
            if(it) {
                itemView.todo_tv_name.paintFlags = itemView.todo_tv_name.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                itemView.todo_tv_name.paintFlags = 0
            }
        }
        itemView.todo_tv_name.text = item.name
    }
}