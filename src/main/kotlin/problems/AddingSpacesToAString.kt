package problems

class AddingSpacesToAString {

    /*fun addSpaces(s: String, spaces: IntArray): String {
        val result = StringBuilder()
        var start = 0
        for (i in spaces) {
            result.append(s.substring(start, i)).append(" ")
            start = i
        }
        result.append(s.substring(start))
        return result.toString()
    }*/

    fun addSpaces(s: String, spaces: IntArray): String {
        val spaceSet = spaces.toSet()

        return buildString {
            s.forEachIndexed { index, c ->
                if (spaceSet.contains(index)) {
                    append(" ")
                }

                append(c)
            }
        }
    }
}