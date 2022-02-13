package utils

/**
 * Extension function to create a copy of the current list without element at @arg index
 */
fun List<Int>.dropAt(index: Int): List<Int> {
    val copy = this.toMutableList()
    copy.remove(this[index])
    return copy
}