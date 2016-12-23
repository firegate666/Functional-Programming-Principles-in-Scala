package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
 @RunWith(classOf[JUnitRunner])
  class MathsSuite extends FunSuite {

  test("and is right") {
    assert(Math.and(false, false) == false)
    assert(Math.and(false, true) == false)
    assert(Math.and(true, false) == false)
    assert(Math.and(true, true) == true)

    assert(Math.and(false, Math.loop) == false)
  }

  test("or is right") {
    assert(Math.or(false, false) == false)
    assert(Math.or(false, true) == true)
    assert(Math.or(true, false) == true)
    assert(Math.or(true, true) == true)

    assert(Math.or(true, Math.loop) == true)
  }

  test("xor is right") {
    assert(Math.xor(false, false) == false)
    assert(Math.xor(false, true) == true)
    assert(Math.xor(true, false) == true)
    assert(Math.xor(true, true) == false)
  }

  test("sqrt is right") {
    assert(Math.sqrt(9).toInt == 3)
    assert(Math.sqrt(1).toInt == 1)
    assert(Math.sqrt(16).toInt == 4)
  }

  test("mul is right") {
    assert(Math.mul(2, 2).toInt == 4)
    assert(Math.mul(-2, 2).toInt == -4)
    assert(Math.mul(2, -2).toInt == -4)
    assert(Math.mul(-2, -2).toInt == 4)
    assert(Math.mul(-2, 0).toInt == 0)
    assert(Math.mul(0, -2).toInt == 0)
    assert(Math.mul(1, 2).toInt == 2)
    assert(Math.mul(2, 1).toInt == 2)
  }

  test("gcd is right") {
    assert(Math.gcd(2, 4) == 2)
    assert(Math.gcd(8, 12) == 4)
    assert(Math.gcd(0, 4) == 4)
  }

  test("factorial is right") {
    assert(Math.factorial(0) == 1)
    assert(Math.factorial(1) == 1)
    assert(Math.factorial(2) == 2)
    assert(Math.factorial(3) == 6)
    assert(Math.factorial(4) == 24)
  }

  test("factorial equals factorialBad") {
    assert(Math.factorial(0) == Math.factorialBad(0))
    assert(Math.factorial(1) == Math.factorialBad(1))
    assert(Math.factorial(2) == Math.factorialBad(2))
    assert(Math.factorial(3) == Math.factorialBad(3))
    assert(Math.factorial(4) == Math.factorialBad(4))
  }


}
