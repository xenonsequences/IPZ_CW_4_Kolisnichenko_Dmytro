package ua.edu.lntu.cw_4

data class Task(
    val title: String,
    val description: String,
    val date: String,
    var status: TaskStatus
)

enum class TaskStatus {
    ACTIVE,
    DONE
}
