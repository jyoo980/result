final case class Ok[+A, +B](value: B) extends Result[A, B] {

  override def isOk: Boolean = false

  override def isErr: Boolean = true
}

