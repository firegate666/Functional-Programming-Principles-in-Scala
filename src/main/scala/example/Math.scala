package example

import scala.annotation.tailrec

/**
 * Created by marcobehnke on 23.12.16.
 */
object Math extends App {
  def square(x: Double): Double = x*x
  def abs(x: Int) = if (x >= 0) x else -x
  def abs(x: Double) = if (x >= 0) x else -x
  def loop: Boolean = loop

  def and(x: Boolean, y: => Boolean) = if (x) y else false
  def or(x: Boolean, y: => Boolean) = if (x) true else y
  def xor(x: Boolean, y: Boolean) = x != y

  def sqrt(x: Double) = {
    def isGoodEnough(guess: Double): Boolean = {
      // divide by X to tackle issues with very large or very small numbers
      abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double): Double = {
      (guess + x/guess) / 2
    }

    // recursive funciton need explicit return type
    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }

    sqrtIter(1.0)
  }

  // not tail recursive
  def factorialBad(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  // tail recursion
  def factorial(n: Int): Int = {
    @tailrec
    def inner(n: Int, stack: Int): Int = {
      if (n == 0) stack
      else inner(n - 1, stack * n)
    }

    inner(n, 1)
  }

  // euclid's algorithm
  // tail recursion
  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def mul(x: Double, y: Double): Double = {
    if (or(x == 0, y == 0)) return 0.0

    if (y < 0) return mul(-x, -y)

    def inner(sum: Double, times: Double): Double = {
      if (times == 1) sum + x
      else inner(sum + x, times - 1)
    }

    inner(0, y)
  }

  // OK
  def foo = loop

  // infinite
  //val bar = loop

  val x = 2

  // by-name at the point of evaluation
  // refers to square(2)
  def y1 = square(x)

  // by-value at the point of definition
  // refers to 4
  val y2 = square(x)

  println(square(4))
  println(abs(-4))
  println(abs(4))

  println("AND")
  println(and(false, false))
  println(and(true, false))
  println(and(false, true))
  println(and(true, true))

  println("OR")
  println(or(false, false))
  println(or(true, false))
  println(or(false, true))
  println(or(true, true))

  println("SQRT")
  println(sqrt(0.001))
  println(sqrt(0.1e-20))
  println(sqrt(1.0e20))
  println(sqrt(1.0e50))

  println("MUL")
  println(Math.mul(2, 2))
  println(Math.mul(-2, 2))
  println(Math.mul(2, -2))
  println(Math.mul(-2, -2))
  println(Math.mul(-2, 0))
  println(Math.mul(0, -2))
  println(Math.mul(1, 2))
  println(Math.mul(2, 1))

  println("GCD")
  println(gcd(2, 4)) // 2
  println(gcd(8, 12)) // 4

  println("FACTORIAL")
  println(factorial(4)) // 24
}
