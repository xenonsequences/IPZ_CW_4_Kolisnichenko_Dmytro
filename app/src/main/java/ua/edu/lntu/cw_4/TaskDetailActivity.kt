package ua.edu.lntu.cw_4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task_detail.*



class TaskDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        val task = intent.getSerializableExtra("task") as Task

        supportActionBar?.title = task.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        descriptionTextView.text = task.description
        dateTextView.text = task.date

        if (task.status == TaskStatus.ACTIVE) {
            doneButton.visibility = View.VISIBLE
            doneButton.setOnClickListener {
                task.status = TaskStatus.DONE
                finish()
            }
        } else {
            doneButton.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}