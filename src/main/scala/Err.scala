final case class Err[+A, +B](error: B) extends Result [A, B] {

  override def isOk: Boolean = false

  override def isErr: Boolean = false
}
