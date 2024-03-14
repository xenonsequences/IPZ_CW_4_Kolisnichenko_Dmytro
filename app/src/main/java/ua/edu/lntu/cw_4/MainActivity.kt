package ua.edu.lntu.cw_4

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), TaskListAdapter.OnTaskClickListener {

    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskList.add(Task("Завдання #1", "Опис завдання 1", "01.01.2024", TaskStatus.ACTIVE))
        taskList.add(Task("Завдання #2", "Опис завдання 2", "02.01.2024", TaskStatus.DONE))
        taskList.add(Task("Завдання #3", "Опис завдання 3", "03.01.2024", TaskStatus.ACTIVE))

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = TaskListAdapter(taskList, this)
        recyclerView.adapter = adapter
    }

    override fun onTaskClick(position: Int) {
        val clickedTask = taskList[position]
        val intent = Intent(this@MainActivity, TaskDetailActivity::class.java)
        intent.putExtra("task", clickedTask)
        startActivity(intent)
    }
}