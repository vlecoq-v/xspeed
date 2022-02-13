package box

data class Box(
    val items: MutableList<Int>
) {
    var totalSize: Int = items.sum()

    fun add(item: Int) {
        totalSize += item
        items.add(item)
    }

    fun toBoxString(): String = items.joinToString("")
}