package ua.edu.lntu.cw_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(private val taskList: List<Task>, private val listener: OnTaskClickListener) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    interface OnTaskClickListener {
        fun onTaskClick(position: Int)
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onTaskClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.titleTextView.text = currentItem.title
        if (currentItem.status == TaskStatus.ACTIVE) {
            holder.itemView.setBackgroundResource(R.color.activeTaskColor)
        } else {
            holder.itemView.setBackgroundResource(R.color.doneTaskColor)
        }
    }

    override fun getItemCount() = taskList.size
}
