package com.rockthejvm

object OOP {

    // classes
    open class Pet {
        // properties = pieces of data
        val age = 0
        // functions (methods) = pieces of behavior
        open fun eat() { // this method can be overridden in child classes
            println("I'm eating something")
        }

        companion object { // properties and methods of the Pet TYPE
            val humanLoveGuaranteed = true
        }
    }

    val aPet = Pet() // instantiation = construction
    // ^^ an instance of Pet

    // inheritance
    class Dog(val name: String) : Pet() {
        // additional properties, methods, etc

        // can change behavior from the parent class (overriding)
        override fun eat() {
            println("I'm chewing something, whatcha lookin at?")
        }
    }

    val aDog = Dog("Lassie")
    val dogName = aDog.name // constructor args are NOT properties, UNLESS prefixed with val or var

    // subtype polymorphism
    val myPet: Pet = Dog("Hachi")

    // abstract class
    abstract class WalkingPet {
        val hasLegs = true
        abstract fun walk(): Unit // may not necessarily have an implementation
    }

    // interface
    interface Carnivore {
        fun eat(animal: Pet): Unit
    }

    interface ColdBlooded

    // inheritance model: a class can inherit from ONE class and >0 interfaces
    class Snake: Pet(), Carnivore, ColdBlooded {
        override fun eat(animal: Pet) = println("sssst, I'm swallowing thisss poor sssucker")
        // additional properties, methods, overrides
    }

    // access modifiers: protected, private
    // overloading

    // objects and companions
    object MySingleton { // singleton pattern in one line = type + the only instance of that type in one definition
        // define properties/methods
        val aProperty = 42
        fun aMethod(arg: Int): Int {
            println("hello from singleton: $arg")
            return aProperty + arg
        }
    }

    // data classes (Java: records, Scala: case classes)
    data class Person(val name: String, val age: Int) // meant to be passed around and stored
    // equals, hashCode, toString
    // copy
    // destructuring

    // exceptions
    val maybeFailure = try {
        // code that can crash
        val language = "Kotlin"
        language.substring(10, 20) // crash
    } catch (e: Exception) {
        "some faulty error message"
    } finally {
        // execute some code no matter what
    }

    // generics - Java, Scala, C#, TypeScript
    interface MyLinkedList<T> {
        // can use the type T inside the definitions of the methods/properties
        fun head(): T
        fun tail(): MyLinkedList<T>
    }

    // real collections
    val numbers: List<Int> = listOf(1,2,3)
    val first = numbers[0]
    val strings = listOf("Kotlin", "rocks")
    val firstStringLength = strings[0].length

    @JvmStatic
    fun main(args: Array<String>) {
        aPet.eat()
        aDog.eat()
        myPet.eat() // the eat() from Dog will be called AT RUNTIME
        println(MySingleton.aProperty) // 42
        println(MySingleton.aMethod(78))
        println(Pet.humanLoveGuaranteed) // property of the Pet TYPE (belongs to companion object)
        // "static" properties and methods

        val bob = Person("Bob", 32)
        val (name, age) = bob
    }
}