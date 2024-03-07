package com.rockthejvm

object Niceties {
    // nullables
    data class Developer(val name: String, val favLanguage: String)

    val maybeDeveloper: Developer? = null // possible if the type is nullable

    // special methods & operators
    data class Person(val name: String, val age: Int) {
        infix fun likes(movie: String) =
            "$name say: I LOVE $movie!"
    }

    val daniel = Person("Daniel", 99)
    val danielStatement = daniel.likes("Dune")
    val danielStatement_v2 = daniel likes "Dune"

    class Vector(var x: Double, var y: Double) {
        operator fun plus(other: Vector) =
            Vector(x + other.x, y + other.y)

        operator fun get(index: Int): Double =
            when (index) {
                0 -> x
                1 -> y
                else -> throw IllegalArgumentException("Vectors only have 2 coordinates")
            }
    }

    val a = Vector(1.0, 2.0)
    val b = Vector(3.5, 6.7)
    val apb = a.plus(b)
    val apb_v2 = a + b // syntax sugar for a.plus(b)
    // same rules for minus, times, div, rem
    val ax = a.get(0)
    val ax_v2 = a[0] // same

    // extensions - new methods to existing types after they've been defined
    operator fun Int.times(aString: String): String {
        var result = ""
        for (i in 1 .. this)
            result += aString
        return result
    }

    val kotlinx3 = 3.times("Kotlin")
    val kotlinx3_v2 = 3 * "Kotlin" // same
    // nicer APIs, DSL


    @JvmStatic
    fun main(args: Array<String>) {
        // val devName = maybeDeveloper.name // unless you KNOW that this is not null
        val devName =
            if (maybeDeveloper == null) "John Doe"
            else maybeDeveloper.name // compiler knows maybeDeveloper is not null

        val devName_v2 = maybeDeveloper?.name // ?. safe call operator - turns a nullable into a nullable
        val devName_definitive = devName_v2 ?: "John Doe" // "Elvis" operator, "or else"
        val trueDevName = maybeDeveloper?.name ?: "John Doe"
    }
}