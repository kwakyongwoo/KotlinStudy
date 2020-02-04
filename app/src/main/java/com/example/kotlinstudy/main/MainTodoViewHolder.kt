package com.example.kotlinstudy.main

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.room.entitiy.TodoItem
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

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
        itemView.todo_tv_due_date.text = item.dDate

        val cal = Calendar.getInstance()
        val mYear = cal.get(Calendar.YEAR)
        val mMonth = cal.get(Calendar.MONTH) + 1
        val mDay = cal.get(Calendar.DAY_OF_MONTH)

        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd")
        val dDate = simpleDateFormat.parse(item.dDate)
        val today = simpleDateFormat.parse("$mYear/$mMonth/$mDay")

        val left = (dDate.time - today.time) / (24*60*60*1000)
        itemView.todo_tv_left.text = left.toString()
        if (left < 0) {
            itemView.todo_tv_left.setTextColor(Color.RED)
        }
    }
}