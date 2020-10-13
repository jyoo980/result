# result

This is a barebones implementation of Scala's own `Either[A, B]` library type, otherwise known as the 
[result monad](https://en.wikipedia.org/wiki/Result_type). 
Similar to my [implementation](https://github.com/jyoo980/maybe) of `Option[T]`, this is more of an
exercise for me to really understand how the result monad works than to be used in production code.

## Why Result?

If you've been programming, you've probably seen something like the code below (or some permuation of it)
```Java
public int factorialFromStr(String str) throws IllegalNumberException {
  try {
    int n = Integer.parseInt(str);
    int acc = 1;
    for (int i = 1; i <= n; i++) {
      acc *= i;
    }
    return acc;
  } catch (NumberFormatException e) {
    throw new IllegalNumberException(str + " was not a valid number");
  }
}
```
Pretty standard stuff, you've definitely seen exceptions before. That said, throwing an exception can often lead to some tangled control flow; they can even act like the dreaded `goto` statement in some use cases. 
In the space of functional programming, it also makes composition and function pipelining incredibly difficult.

---
It turns out there's another way to represent errors/exceptional program state _without_ resorting to breaking control-flow in unexpected ways. We can leverage the result monad to do this
```Scala
def factorialFromStr(str: String): Result[Error, Int] =
  if (str.forall(_.isDigit)) {
    val n = str.toInt
    val fact = (1 to n).product
    Ok(fact)
  } else {
    Err(Error(s"str was not a valid number"))
  }
```
You can think of the result monad as just a union of two types: `A` and `B`, commonly referred to as `Ok` and `Err` or in Scala, `Left` and `Right`.

TODO: add more detail

## Dependencies
* [Scala 2.12+](https://www.scala-lang.org/download/)
* [sbt (Scala Build Tool)](https://www.scala-sbt.org/)
* [IntelliJ IDEA + Scala Plugin](https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html)
  * this is optional if you have `sbt` installed

## Working with result
result is an `sbt` project so it's relatively easy to spin up

* Run `sbt` to start the build server
  * `compile` to build the project
  * `test` to run all tests under the `test` directory (spec files)
  * `clean` to remove all generated code
