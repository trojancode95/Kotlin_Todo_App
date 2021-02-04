package com.example.kotlintodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintodolist.adapters.TodoAdapter
import com.example.kotlintodolist.models.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("First task", false))

        rvTodos.layoutManager = LinearLayoutManager(this)
        val todoAdapter: TodoAdapter = TodoAdapter(todos)
        rvTodos.adapter = todoAdapter

        btnAdd.setOnClickListener {
            val newTodo = etNewTodo.text.toString()
            todos.add(Todo(newTodo, false))
            todoAdapter.notifyDataSetChanged()
        }
    }
}