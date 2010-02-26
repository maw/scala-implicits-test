class BadEmailAddressException extends Exception { }

object EmailAddress {
  implicit def wrapEmailAddress(s: EmailAddress): String = s.real_str
}

// This doesn't really inherit from String, but we can fake it.
case class EmailAddress(str: String) {
  // See http://stackoverflow.com/questions/210945/what-would-be-a-globally-accepted-regular-expression-to-match-e-mail-addresses
  // if you want to do this check for real.
  if (! str.contains("@")) throw new BadEmailAddressException
  val real_str = str
  
  override def toString(): String = real_str
}
