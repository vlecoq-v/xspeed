import java.security.InvalidParameterException

/**
 * Main function checks for an argument to execute @makeBoxes if None is present it triggers a set of tests
 */
fun main(args: Array<String>) {
    if (args.isNotEmpty()) println(makeBoxes(args[1]))
    else {
        println("No argument detected starting basic tests")
        test()
    }
}

fun test() {
    println( try { makeBoxes("163841689525773") } catch (e: InvalidParameterException) { "KO" })
    println( try { makeBoxes("0") } catch (e: InvalidParameterException) { "KO" })
    println( try { makeBoxes("") } catch (e: InvalidParameterException) { "KO" })
    println( try { makeBoxes("coucou") } catch (e: InvalidParameterException) { "KO" })
    println( try { makeBoxes("10") } catch (e: InvalidParameterException) { "KO" })
    println( try { makeBoxes("111111111111111111111111111111111111") } catch (e: InvalidParameterException) { "KO" })
}

