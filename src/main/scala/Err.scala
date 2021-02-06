final case class Err[+A, +B](error: A) extends Result[A, B] {

  override def isOk: Boolean = false

  override def isErr: Boolean = true
}
