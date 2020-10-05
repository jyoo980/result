abstract class Result[+A, +B] {

  def isOk: Boolean

  def isErr: Boolean

  final def contains[B1 >: B](elem: B1): Boolean = this match {
    case Ok(value) => elem == value
    case _ => false
  }

  def exists(f: B => Boolean): Boolean = this match {
    case Ok(value) => f(value)
    case _ => false
  }

  def filterOrElse[A1 >: A](p: B => Boolean, zero: => A1): Result[A1, B] = this match {
    case Ok(value) =>
      if (p(value)) Ok(value)
      else Err(zero)
    case Err(value) => Err(value)
  }

  def flatMap[A1 >: A, B1](f: B => Result[A1, B1]): Result[A1, B1] = this match {
    case Ok(value) => f(value)
    case Err(value) => Err(value)
  }

  def fold[C](fa: A => C, fb: B => C): C = this match {
    case Ok(value) => fb(value)
    case Err(value) => fa(value)
  }

  def forall(f: B => Boolean): Boolean = this match {
    case Ok(value) => f(value)
    case _ => true
  }

  def foreach[U](f: B => U): Unit = this match {
    case Ok(value) => f(value)
    case _ => ()
  }

  def getOrElse[B1 >: B](or: => B1): B1 = this match {
    case Ok(value) => value
    case _ => or
  }
}
