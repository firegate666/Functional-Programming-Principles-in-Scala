package example

/**
 * Created by marco on 25.12.16.
 */
object Fibonacci extends App {

  def iterate(iterations: Int, last_2: Int = 0, last_1: Int = 1): Unit = {
    if (iterations == 0) return
    val next = last_1 + last_2
    print(next + " ")
    iterate(iterations - 1, last_1, next)
  }

  println("Fibonacci number sequence")
  iterate(10)
  println("")
}
