package com.example.kotlinstudy.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.room.entitiy.TodoItem
import kotlinx.android.synthetic.main.item_todo.view.*

class MainTodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onbind(item: TodoItem) {
        itemView.todo_cb.isChecked = item.checked
        itemView.todo_tv_name.text = item.name
    }
}