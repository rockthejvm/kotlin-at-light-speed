package com.rockthejvm

object Collections {

    // lists, arrays, sets, maps
    val aList: List<Int> = listOf(1,2,3,4) // immutable
    // main API: index an element + size of that list
    val thirdElement: Int = aList.get(2) // 0-indexed
    val thirdElement_v2: Int = aList[2] // same as aList.get(2)
    val length = aList.size

    // other API
    val find3 = aList.indexOf(3) // 2
    val has3 = aList.contains(3) // true
    val subList = aList.subList(1,2) // from(inclusive), to(exclusive)
    val with5 = aList.plus(5) // [1,2,3,4,5]

    // FP API - later

    // mutable lists
    val mutableList = mutableListOf(1,2,3,4,5,6)

    // arrays - map to JVM arrays (map to OS arrays)
    val anArray = arrayOf(1,2,3,4,5,7)

    // sets - cannot contain duplicates - order cannot be guaranteed
    val aSet = setOf(1,2,3,4,1,2,3) // immutable set
    // API - contains
    val contains1 = aSet.contains(1)
    val contains1_v2 = 1 in aSet // same
    // other API
    val add7 = aSet.plus(7) // new set: [1,2,3,4,7]
    val without3 = aSet.minus(3) // new set: [1,2,4]
    // mutable sets
    val mutableSet = mutableSetOf(1,2,3,4,1,2,3)

    // maps - key-value associations
    val phonebook: Map<String, Int> = mapOf(
        Pair("Daniel", 123),
        "Alice" to 999 // same as Pair("Alice", 999)
    )
    // main API: contains a key, get the value for a key
    val hasAlice = phonebook.contains("Alice")
    val hasAlice_v2 = "Alice" in phonebook // same
    val aliceNumber = phonebook.get("Alice")
    val aliceNumber_v2 = phonebook["Alice"]

    @JvmStatic
    fun main(args: Array<String>) {
        anArray.set(2, 99)
        anArray[2] = 99 // same
        mutableSet.add(99)

        println(mutableSet)
        println(phonebook)
    }
}