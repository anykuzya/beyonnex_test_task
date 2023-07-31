import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AnagramCheckerTest {
    companion object {
        private const val basicOneLine = "Yester9ay... All my troubles!! se-emed s0 far away&*(???42"
        private const val goldClearText = "yester9ayallmytroublesseemeds0faraway42"
        private val goldCharKeys = "yestr9almoubd0fw42".toSet()
        private val goldCharEncounters = mapOf(
            Pair('y', 4),
            Pair('e', 6),
            Pair('s', 4),
            Pair('t', 2),
            Pair('r', 3),
            Pair('9', 1),
            Pair('a', 5),
            Pair('l', 3),
            Pair('m', 2),
            Pair('o', 1),
            Pair('u', 1),
            Pair('b', 1),
            Pair('d', 1),
            Pair('0', 1),
            Pair('f', 1),
            Pair('w', 1),
            Pair('4', 1),
            Pair('2', 1),
        )
    }

    private fun generateLongString(pairs: List<Pair<Char, Int>>): String {
        val longStringBuilder = StringBuilder()
        for ((symbol, length) in pairs) {
            repeat(length) {
                longStringBuilder.append(symbol)
            }
        }
        return longStringBuilder.toString()
    }
    @Test
    fun checkClearText() {
        assertEquals(goldClearText, AnagramChecker.clearText(basicOneLine))
    }

    @Test
    fun checkToCharEncounters() {
        val basicLineCharset = AnagramChecker.clearText(basicOneLine).toCharEncounters()
        assertEquals(goldCharKeys, basicLineCharset.keys)
        assertEquals(goldCharEncounters, basicLineCharset)
    }

    // here only simple tests with obvious charsets
    // more complicated are stored in files at /resources and checked in AnagramCheckerAdapterTest
    @Test
    fun checkAnagramsEmptyLines() {
        assertTrue(AnagramChecker.areAnagrams("", ""))
    }
    @Test
    fun checkAnagramsCaseInsensitive() {
        assertTrue(AnagramChecker.areAnagrams("Ab1c", "Cb1a"))
    }
    @Test
    fun checkNonAnagramsDiffLength() {
        assertFalse(AnagramChecker.areAnagrams("Ab1cd", "Cb2a"))
    }
    @Test
    fun checkNonAnagramsSameLengthDiffCharsets() {
        assertFalse(AnagramChecker.areAnagrams("Ab1cd", "Cb12a"))
    }
    @Test
    fun checkNonAnagramsSameCharsetsDiffFrequencies() {
        assertFalse(AnagramChecker.areAnagrams("Ab1cdD", "Cb1adB"))
    }

    private val longStrAb = generateLongString(listOf(Pair('A', 100000), Pair('b', 1)))
    private val longStrBa = generateLongString(listOf(Pair('a', 40000), Pair('B', 1),  Pair('a', 60000)))

    @Test
    fun checkLongVsShort() {
        assertFalse(AnagramChecker.areAnagrams("a", longStrAb))
    }
    @Test
    fun checkLongVsLongAnagrams() {
        assertTrue(AnagramChecker.areAnagrams(longStrAb, longStrBa))
    }
    @Test
    fun checkLongVsLongNonAnagrams() {
        assertFalse(AnagramChecker.areAnagrams(
            generateLongString(listOf(Pair('a', 100001), Pair('b', 1))),
            generateLongString(listOf(Pair('b', 100000), Pair('b', 2))),
        ))
    }
}