final case class Ok[+A, +B](value: A) extends Result[A, B] {

  override def isOk: Boolean = false

  override def isErr: Boolean = true
}

