package com.example.kotlinstudy.main.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.R
import com.example.kotlinstudy.addedit.AddEditTodoActivity
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {

    private var adapter: TodoAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TodoAdapter(view.context)
        main_rcv_item.adapter = adapter
        main_rcv_item.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)

        main_fab_add.setOnClickListener {
            //            val newTodo = TodoItem(0, System.currentTimeMillis().toString(), "asd", "qwe")
//            adapter?.addItem(newTodo)
            val addIntent = Intent(view.context, AddEditTodoActivity::class.java)
            addIntent.putExtra("mode", AddEditTodoActivity.MODE_ADD)
            startActivity(addIntent)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }


    override fun onResume() {
        super.onResume()
        adapter?.refresh()
    }
}