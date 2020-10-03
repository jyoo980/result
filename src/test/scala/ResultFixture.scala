trait ResultFixture {

  def toOk[A, B](b: B): Result[A, B] = Ok(b)

  def toErr[A, B](a: A): Result[A, B] = Err(a)
}
