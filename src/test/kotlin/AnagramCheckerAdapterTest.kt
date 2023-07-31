import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import java.nio.file.Paths

class AnagramCheckerAdapterTest {
    // the overall logic test
    // checking only file mode
    // don't want to emulate manual user input for test assignment :)
    // simple one-lines are tested in AnagramCheckerTest
    private fun testFile(name: String): File {
        return File("./src/test/resources/$name")
    }

    @Test
    fun checkTwoSameFiles() {
        assertTrue(AnagramCheckerAdapter.checkInFileMode(
            testFile("empty.txt"), testFile("empty.txt")
        ))
    }
    @Test
    fun checkTwoSameNonExistentFiles() {
        assertThrows<InputException>(philosophical) {
            (AnagramCheckerAdapter.checkInFileMode(
                testFile("oops.txt"), testFile("oops.txt")
            ))
        }
    }
    @Test
    fun checkTwoEmptyFiles() {
        assertTrue(AnagramCheckerAdapter.checkInFileMode(
            testFile("empty.txt"), testFile("empty-copy.txt")
        ))
    }
    @Test
    fun checkEmptyAndNonExistentFiles() {
        assertThrows<InputException>("Error while reading files: ./src/test/resources/oops.txt (No such file or directory)") {
            AnagramCheckerAdapter.checkInFileMode(
                testFile("empty.txt"), testFile("oops.txt")
            )
        }
    }
    @Test
    fun checkFilesWithAnagrams() {

        val currentDirectory = Paths.get("").toAbsolutePath().toString()
        println("Current Directory: $currentDirectory")
        assertTrue(AnagramCheckerAdapter.checkInFileMode(
            testFile("styryeade.txt"), testFile("yesterday.txt"))
        )
    }

    @Test
    fun checkDifferentCleanLength() {
       assertFalse(AnagramCheckerAdapter.checkInFileMode(
           testFile("suddenly.txt"), testFile("yesterday.txt")
       ))
    }
    @Test
    fun checkWithEmptyFile() {
        assertFalse(AnagramCheckerAdapter.checkInFileMode(
            testFile("empty.txt"), testFile("yesterday.txt")
        ))
    }
    @Test
    fun checkSameCleanLengthButDifferentCharsets() {
        assertFalse(AnagramCheckerAdapter.checkInFileMode(
            testFile("styryead-diff-charset.txt"), testFile("yesterday.txt")
        ))
    }
    @Test
    fun checkSameCleanLengthAndSameCharsets() {
        assertFalse(AnagramCheckerAdapter.checkInFileMode(
            testFile("styryeade.txt"), testFile("styryead-diff-charset.txt")
        ))
    }

}