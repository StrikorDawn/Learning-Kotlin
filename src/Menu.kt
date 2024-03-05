class Menu {
    val menuList = arrayOf(
        "1.View Tasks",
        "2.Add Task",
        "3.Complete Task",
        "4.Load Task List",
        "5.Save Task List",
        "6.Quit Program")
    val t = Task()
    fun displayMenu(){
        println("What would you like to do?")
        for (item in menuList)
        {
            println(item)
        }
    }
    fun nav(){
        var uAction = -1
        val op1 = 1
        val op2 = 2
        val op3 = 3
        val op4 = 4
        val op5 = 5
        val quit = 6
        while (uAction != quit)
        {
            space()
            displayMenu()
            print("> ")
            val uInput = readln()
            space()
            if (uInput == "1" || uInput == "2" || uInput == "3" || uInput == "4" || uInput == "5" || uInput == "6"){
                uAction = uInput.toInt()

                if(uAction == op1){
                    t.displayTasks()
                    t.pause()
                }
                else if(uAction == op2){
                    t.addTask()
                }
                else if(uAction == op3){
                    t.completeTask()
                    t.pause()
                }
                else if(uAction == op4){
                    println("What is the name of the task file you would like to load? (Default is \"TODO\"")
                    print("> ")
                    val fileName = readln()
                    val file = if (fileName.isNotBlank()) fileName else "TODO"
                    t.loadTasks(file)
                    t.pause()
                }
                else if(uAction == op5){
                    println("What is the name of the task file you would like to save? (Default is \"TODO\"")
                    print("> ")
                    val fileName = readln()
                    val file = if (fileName.isNotBlank()) fileName else "TODO"
                    t.saveTasks(file)
                    t.pause()
                }
                else if(uAction == quit){

                }
            }
            else
            {
                println("Invalid input, Pleas try again.")
            }
        }
    }
    fun space(){
        println()
        println("===================================")
        println()
    }
}