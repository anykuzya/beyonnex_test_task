import java.io.File

open class InputException(override val message: String?): Exception(message)
class InputPhilosophicalException: InputException(philosophical)
object AnagramCheckerAdapter  {

    fun checkInFileMode(first: File, second: File): Boolean {
        if (first.absolutePath == second.absolutePath) {
            if (first.exists()) {
                return true
            } else {
                throw InputPhilosophicalException()
            }
        }
        try {
            val firstText = first.readText().trim()
            val secondText = second.readText().trim()
            return AnagramChecker.areAnagrams(firstText, secondText)
        } catch (e: Exception) {
            throw InputException("Error while reading files: ${e.message}")
        }
    }

    fun checkInManualMode(): Boolean {
        try {
            println("Enter the first text (one-line), please:")
            val firstText = readln().trim()

            println("Enter the second text (one-line), please:")
            val secondText = readln().trim()

            return AnagramChecker.areAnagrams(firstText, secondText)
        } catch (e: Exception) {
            throw InputException("Error in user input: ${e.message}")
        }
    }
}