class Solution {
    fun reverseWordsWithKotlinFunctions(s: String): String {
        return s.split(" ").joinToString(" ") { word -> word.reversed() }
    }

    fun reverseWordsWithCustomFunctions(s: String): String {
        val words = split(s, ' ')

        return buildString {
            words.forEachIndexed { index, word ->
                append(reverseString(word))
                if (index != words.lastIndex) {
                    append(' ')
                }
            }
        }
    }

    fun reverseWords(s: String): String {
        if (s.isEmpty()) {
            return s
        }

        val reversedWords = mutableListOf<String>()
        val wordBuilder = StringBuilder()

        for (index in s.lastIndex downTo 0) {
            val char = s[index]
            if (char == ' ') {
                reversedWords.add(wordBuilder.toString())
                wordBuilder.clear()
            } else {
                wordBuilder.append(char)
            }
        }

        reversedWords.add(wordBuilder.toString())

        return buildString {
            for (index in reversedWords.lastIndex downTo 0) {
                append(reversedWords[index])
                if (index != 0) {
                    append(' ')
                }
            }
        }
    }

    private fun split(s: String, delimiter: Char): List<String> {
        if (s.isEmpty()) {
            return emptyList()
        }

        val list = mutableListOf<String>()
        val wordBuilder = StringBuilder()

        s.forEachIndexed { index, char ->
            if (char == delimiter) {
                list.add(wordBuilder.toString())
                wordBuilder.clear()
            } else {
                wordBuilder.append(char)
            }
        }

        list.add(wordBuilder.toString())

        return list
    }

    private fun reverseString(s: String): String =
        buildString {
            for (i in s.lastIndex downTo 0) {
                append(s[i])
            }
        }
}

fun test(s: String, expectedString: String) {
    val result = Solution().reverseWords(s)
    println(result)
    println(result == expectedString)
}

test("Let's take LeetCode contest", expectedString = "s'teL ekat edoCteeL tsetnoc")
test("God Ding", expectedString = "doG gniD")