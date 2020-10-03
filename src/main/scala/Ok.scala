final case class Ok[+A, +B](value: B) extends Result[A, B] {

  override def isOk: Boolean = true

  override def isErr: Boolean = false
}

