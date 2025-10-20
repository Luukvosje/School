import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

class TaskTest {

    @Test
    fun `new task is not done`() {
        val task = Task("Eten halen", "Boodschappen doen", deadline = LocalDate.now())
        assertFalse(task.isDone)
    }

    @Test
    fun `marking a task as done works`() {
        val task = Task("Gym", "Gewichten heffen", deadline = LocalDate.now())
        task.isDone = true
        assertTrue(task.isDone)
    }
}
