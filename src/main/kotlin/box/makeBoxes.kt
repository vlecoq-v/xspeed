import box.Box
import utils.dropAt
import java.lang.NumberFormatException
import java.security.InvalidParameterException

/**
 * This function takes a list of items of size [1:9] and packages them inside boxes trying to fit
 * as close to a total size of 10 for each box
 *
 * @arg rawItems is the list of items to package in string format ex 163841689525773
 * @return is a string representing the items inside boxes separated by /
 */
fun makeBoxes(rawItems: String): String {
    val items: List<Int> = try {
        rawItems
            .map { it.toString().toInt() }
            .filter { it != 0 }
            .sortedDescending()
    } catch (e: NumberFormatException) { throw InvalidParameterException("Non int parameter") }

    if (items.isEmpty()) throw InvalidParameterException("Empty Item list, items must be > 0")

    val boxes = makeBoxes(
        items = items.dropAt(0),
        currentBox = Box(mutableListOf(items[0])),
        boxes = mutableListOf()
    )
    return boxes.joinToString("/") { it.toBoxString() }
}

/**
 * This function recursively implements @makeBoxes purpose
 *
 * TODO: look for optimal matches before putting into box
 *
 * @arg Item is the list of items to fit in box
 * @arg currentBox is the current @Box being prepared
 * @arg boxes is a list of the precedent boxes
 *
 * Before each call to this function an item is removed from the items list and put into either a new box or
 * the box being prepared
 */
fun makeBoxes(items: List<Int>, currentBox: Box, boxes: MutableList<Box>): MutableList<Box> {
    if (currentBox.totalSize < 10) { // look for an item to put in the box
        items.forEachIndexed { index: Int, item: Int ->
            if (currentBox.totalSize + item <= 10) {
                currentBox.add(item)
                return makeBoxes(items.dropAt(index), currentBox, boxes)
            }
        }
    }

    boxes.add(currentBox)

    if (items.isEmpty()) return boxes
    else return makeBoxes(
        items = items.dropAt(0),
        currentBox = Box(mutableListOf(items[0])),
        boxes = boxes
    )
}