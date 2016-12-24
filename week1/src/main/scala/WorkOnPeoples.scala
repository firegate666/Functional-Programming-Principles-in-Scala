class Person(var name: String, var age: Int) {
  override def toString: String = s"Name: {$name}, Age: {$age}"
}

object WorkOnPeoples extends App {
  val people: Array[Person] = new Array[Person](4)

  people(0) = new Person("Marco", 40)
  people(1) = new Person("Janina", 37)
  people(2) = new Person("Bodhi", 7)
  people(3) = new Person("Felix", 5)

  println((people deep) toString)

  println("Partition")
  val(minors, majors) = people partition(_.age < 18)

  println((minors deep) toString)
  println((majors deep) toString)

  println("Parallel Partition")
  val(minors2, majors2) = people.par partition(_.age < 18)

  /*println((minors2 deep) toString)
  println((majors2 deep) toString)*/
}

