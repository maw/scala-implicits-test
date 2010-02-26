import EmailAddress._

object ImplicitsTest {
  def printAnyString(str: String): Unit =
    println("This string could be anything: " + str)
  def printEmailAddress(str: EmailAddress): Unit =
    println("This string is is guaranteed to be an email address: " + str)
  
  def main(args: Array[String]): Unit = {
    try {
      val a = new EmailAddress("hehe")
      println("We'll never get here.")
    } catch { 
      case bse: BadEmailAddressException =>
        println("woops")
    }

    try {
      val b = EmailAddress("foo@example.com")
      println(b)
      printAnyString(b)
      
      printEmailAddress(b)
      
      // printEmailAddress("hehe") /* <-- this fails */
      printEmailAddress(new EmailAddress("remedios@example.com")) // <-- but not this

      println("Now we'll do stuff to the EmailAddress as though it were")
      println("a string.")
      println("ok? " + b.contains("@"))
      println("not ok?" + b.contentEquals("alksdjflkajsdlkjsdf"))
      
      val c = EmailAddress("taquito@example.com")
      printAnyString(c)
      printEmailAddress(c)
      println("ok? " + c.contains("@"))
      
      printEmailAddress(EmailAddress("kiwi@example.com"))
      printAnyString(EmailAddress("botas@example.com"))
    } catch { 
      case bse: BadEmailAddressException =>
        println("woops")
    }
  }
}
