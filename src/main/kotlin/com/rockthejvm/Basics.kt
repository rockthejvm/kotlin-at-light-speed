package com.rockthejvm

object Basics {
    @JvmStatic
    fun main(args: Array<String>) {
        // define values
        val meaningOfLife: Int = 42 // const int meaningOfLife = 42;
        val meaningOfLife_v2 = 42 // type inference
        // meaningOfLife = 43 // not ok - values are "immutable"

        var objectiveInLife = 32
        objectiveInLife = 45 // ok - vars can be changed

        // standard types: Int, Boolean, Char, Short, Long, Float, Double

        // string
        val aString = "I love Kotlin"
        val aChar = 's'
        val aCombinedString = "I" + " " + "love" + " " + "Kotlin"
        val aTemplate = "The meaning of life is $meaningOfLife"

        // expressions
        val anExpression = 2 + 3

        val aCondition = 1 > 2
        if (aCondition) {
            println("the condition is true")
        } else {
            println("the condition is false")
        }

        // if structures can be expressions
        val anIfExpression = if (aCondition) 42 else 999 // this is an expression

        // "switch on steroids" = when expressions
        when (meaningOfLife) {
            42 -> println("the meaning of life from HGG")
            43 -> println("not the meaning of life, but quite close")
            else -> println("something else")
        }

        // when structure becomes a when expression
        val meaningOfLifeMessage = when (meaningOfLife) {
            42 -> "HGG"
            43 -> "quite close"
            else -> "something else"
        }

        // looping
        println("inclusive range 1-10")
        for (i in 1 .. 10) {
            // do whatever you want with the counter i
            println(i)
        }
        // ranges: 1..10 (inclusive), 1..<10 (exclusive), 1 until 10(same), 1 .. 10 step 2, 10 downTo 1

        // arrays or lists
        println("iterating over a collection")
        val aList = listOf(1,5,3,2,4)
        for (element in aList) {
            println(element)
        }

        // while loops
        println("while loops")
        var i = 1
        while (i <= 10) {
            println(i)
            i += 1
        }

        // do-while loops
        println("counting backwards with do-while")
        do {
            println(i)
            i -= 1
        } while (i > 0)

        // functions
        fun concatenateString(aString: String, count: Int): String {
            var result = ""
            for (c in 1 .. count)
                result += aString
            return result
        }

        // single-expr function syntax
        fun combineStrings(strA: String, strB: String) =
            "$strA----$strB" // one expression

        // unit = void in other languages
        // void functionReturningVoid(String arg)
        fun functionReturningVoid(arg: String): Unit {
            println("this is a string: $arg")
        }
    }
}