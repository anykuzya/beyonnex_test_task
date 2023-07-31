fun String.toCharEncounters(): MutableMap<Char, Int> {
    val result = mutableMapOf<Char, Int>()
    for (char in this) {
        result[char] = result.getOrDefault(char, 0) + 1
    }
    return result
}
object AnagramChecker {
    fun clearText(text: String): String {
        return text.asSequence().filter {
            it.isLetterOrDigit()
        }.map { it.lowercaseChar() }.joinToString("")
    }

    fun areAnagrams(firstText: String, secondText: String): Boolean {
        val firstChars = clearText(firstText)
        val secondChars = clearText(secondText)
        if (firstChars.length != secondChars.length) {
            return false
        }
        val firstCharEncounters = firstChars.toCharEncounters()
        val secondCharEncounters = secondChars.toCharEncounters()
//        if (firstCharEncounters.keys != secondCharEncounters.keys) {
//            return false
//        }
//        got rid of this check, that is a loop inside actually:
//          iterating through one of the map keys, if there is any difference in keys, will get null in the second map.
//          if keys sets are the same and there's just a difference in counts, then just catch the difference obviously
        for (key in secondCharEncounters.keys) {
            if (secondCharEncounters[key] != firstCharEncounters[key]) {
                return false
            }
        }
        return true
    }
}

