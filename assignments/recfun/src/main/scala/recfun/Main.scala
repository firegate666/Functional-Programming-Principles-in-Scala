package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("\nParentheses Balancing")
    println("(if (zero? x) max (/ 1 x)): " + balance("(if (zero? x) max (/ 1 x))".toList))
    println("I told him (that it’s not (yet) done). (But he wasn’t listening): " + balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(":-): " + balance(":-)".toList))
    println("())(: " + balance("())(".toList))

    println("\nCounting Change")
    println("4 <= 1,2: " + countChange(4, List(1,2,6)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c < 0) 0
      else if (c > r) 0
      else if (r == 0) 1
      else if (r == 1) 1
      else pascal(c - 1, r -1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def inner(chars: List[Char], count: Int): Boolean = {
        if (chars.isEmpty) count == 0
        else if (chars.head == '(') inner(chars.tail, count + 1)
        else if (chars.head == ')' && count == 0) false
        else if (chars.head == ')') inner(chars.tail, count - 1)
        else inner(chars.tail, count)
      }

      inner(chars, 0)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, allCoins: List[Int]): Int = {
      // filter out coins that are of no use
      val(coins) = allCoins.filter(_ <= money)

      if (money == 0) 1 // money was successfully reduced to zero, count as change
      else if (coins.isEmpty) 0 // no coins, no change
      else // still money, still coins
        // count change for rest money for all coins
        countChange(money - coins.head, coins) +
          // count change for all money but rest coins
          countChange(money, coins.tail)
    }
  }
