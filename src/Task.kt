import java.io.File
class Task {

    val tasks = mutableListOf<MutableList<Any>>()
    fun pause(){
        println()
        print("Press Enter to continue...")
        readln()
    }
    private fun CreateTask(taskName: String, description: String, completed: Boolean){
        val task : MutableList<Any> = mutableListOf(taskName,description,completed)
        tasks.add(task)

    }
    fun displayTasks()
    {
        var num = 1
        if(tasks.isNotEmpty()){
            for (task in tasks) {
                val name = task[0]
                val description = task[1]
                val completed = task[2]
                val done = if (completed == true) "X" else " "

                println("$num. $name [$done]: $description")
                num++
            }
        }
        else{
            println("No tasks found.")
        }
    }
    fun addTask(){
        println("What is the name of this Task? ")
        print("> ")
        val name = readln()
        println("Describe what you will do for ${name}: ")
        print("> ")
        val description = readln()
        val completed = false
        CreateTask(name, description, completed)
    }
    fun completeTask(){
        println("Which task number would you like to complete?")
        displayTasks()
        print("> ")
        val uInput = readln().toInt()
        if (uInput - 1 > -1 && uInput <= tasks.count()) {
            tasks[uInput - 1][2] = true
        } else {
            println("Invalid input please try again.")
        }
    }
    fun loadTasks(fileName : String = "TODO" ){
        val progTree = System.getProperty("user.dir")
        val filePath = "$progTree/Tasks/$fileName"
        val file = File(filePath)
        if (file.exists()){
            file.bufferedReader().useLines {lines ->
                tasks.clear()
                lines.forEach { line ->
                    val parts = line.split("|||")
                    if(parts.size == 3){
                        val  name = parts[0]
                        val  description = parts[1]
                        val  completed = parts[2].toBoolean()
                        CreateTask(name,description,completed)

                    }
                }
            }
            println("Tasks succesfully loaded from $fileName.")
        }
        else{
            println("$fileName not found. No Tasks Loaded.")
        }
    }
    fun saveTasks(fileName: String = "TODO"){
        val progTree = System.getProperty("user.dir")
        val filePath = "$progTree/Tasks/$fileName"
        val file = File(filePath)
        file.bufferedWriter().use { writer ->
            for(task in tasks) {
                val line = "${task[0]}|||${task[1]}|||${task[2]}"
                writer.write(line)
                writer.newLine()
            }
        }
        println("Tasks successfully saved to $fileName")
    }
}

