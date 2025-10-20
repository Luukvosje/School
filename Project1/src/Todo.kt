//package machine
//
//import java.time.LocalDateTime
//
//data class Task(
//    val title: String,
//    val description: String,
//    var isDone: Boolean = false,
//    val deadline: LocalDateTime? = null
//) {
//    override fun toString(): String {
//        return "$title - ${if (isDone) "Afgerond" else "Niet afgerond"}: $description, $deadline"
//    }
//}
//
//class Command(
//    private val name: String,
//    private val action: (date: LocalDateTime) -> Unit
//) {
//    override fun toString(): String {
//        return name;
//    }
//
//    fun execute() = action(LocalDateTime.now())
//}
//
//fun main() {
//    val tasks = mutableListOf<Task>()
//
//    val addCommand = Command("Add", { localDate ->
//        var titleInput: String? = null;
//        while (titleInput.isNullOrBlank()) {
//            println("Naam van je taak:");
//            titleInput = readLine()?.trim();
//        }
//
//        var descriptionInput: String? = null;
//        while (descriptionInput.isNullOrBlank()) {
//            println("Omschrijving van je taak:");
//            descriptionInput = readLine()?.trim();
//        }
//
//        tasks.add(Task(titleInput, descriptionInput, false, localDate))
//        println("Taak aangemaakt");
//    });
//
//    val listCommand = Command("List", {
//        tasks.forEachIndexed { index, task -> println("Taak ${index + 1}: $task") }
//    })
//
//    val doneCommand = Command("Done", {
//        var input: Int? = null;
//        while (input == null) {
//            println("Geef het nummer van een taak die je wilt afronden");
//            input = readLine()?.toIntOrNull();
//        }
//        if (input != null && input <= tasks.size) {
//            tasks[input - 1].isDone = true;
//            println("Taak is afgerond")
//        } else {
//            println("Ongeldige keuze")
//        }
//    })
//
//    val SortDescCommand = Command("SortDesc", {
//        tasks.sortWith(compareByDescending<Task> { it.deadline }.thenBy { it.title })
//    })
//
//    val commands = listOf(addCommand, listCommand, doneCommand, SortDescCommand)
//
//    while (true) {
//        println("-".repeat(20))
//        println("De volgende commando's kunnen gebruikt worden:")
//
//        commands.forEachIndexed { index, comand -> println("$command: ${index + 1}") }
//        println("Kies een commando");
//        val input = readLine()?.trim();
//
//        if (input == null || input.equals("exit", ignoreCase = true)) {
//            break
//        }
//
//        val index = input.toIntOrNull()?.minus(1)
//        if (index != null && index in commands.indices) {
//            commands[index].execute()
//        } else {
//            val command = commands.find { it.toString().equals(input, ignoreCase = true) }
//            if (command != null) {
//                command.execute()
//            } else {
//                println("Ongeldig commando")
//            }
//        }
//    }
//
//}