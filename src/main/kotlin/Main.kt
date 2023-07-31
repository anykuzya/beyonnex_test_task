import java.io.File

fun printResult(res: Boolean) {
    if (res) {
        println("The texts are anagrams of each other.")
    } else {
        println("The texts are not anagrams of each other.")
    }
}
fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a mode ('file' or 'manual') as the first argument.")
        return
    }
    try {
        when (args[0]) {
            "file" -> {
                if (args.size < 3) {
                    println("Please provide two file names as arguments for 'file' mode.")
                    return
                }
                printResult(AnagramCheckerAdapter.checkInFileMode(File(args[1]), File(args[2])))
            }

            "manual" -> {
                printResult(AnagramCheckerAdapter.checkInManualMode())
            }

            else -> {
                println("Invalid mode. Please use 'file' or 'manual' as the first argument.")
            }
        }
    } catch (e: InputException) {
        println(e.message)
    }
}