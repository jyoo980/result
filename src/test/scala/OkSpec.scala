import org.scalatest.matchers._
import org.scalatest.flatspec.AnyFlatSpec

class OkSpec extends AnyFlatSpec with should.Matchers with ResultFixture {

  "an Ok[A]" should "return true for Result.isOk" in {
    val okNum = toOk(2)
    okNum.isOk shouldBe true
  }

  it should "return false for Result.isErr" in {
    val okNum = toOk(3)
    okNum.isErr shouldBe false
  }

  it should "return true for contains given a valid element" in {
    val okStr = toOk("hello")
    okStr.contains("hello") shouldBe true
  }

  it should "return false for contains given an invalid element" in {
    val okStr = toOk("not hello")
    okStr.contains("hello") shouldBe false
  }

  it should "return true for exists when the value fulfills f" in {
    val okNum = toOk(10)
    okNum.exists(_ > 9) shouldBe true
  }

  it should "return false for exists when the value does not fulfill f" in {
    val okNum = toOk(0)
    okNum.exists(_ < 0)
  }

  it should "apply the correct fold function for Ok" in {
    val okStr = toOk("123")
    okStr.fold(_ => -1, Integer.parseInt) shouldBe 123
  }

  it should "return true given a predicate that the value fulfils" in {
    final case class StudentId(name: String, number: Integer)
    val id   = StudentId("John Smith", 1234123)
    val okId = toOk(id)
    okId.forall(_.name == "John Smith") shouldBe true
  }

  it should "apply an effect-ful function for a value" in {
    final case class Course(code: Int, description: String)
    val course   = Course(310, "Software Engineering")
    val okCourse = toOk(course)
    okCourse.foreach { course =>
      println(s"Course code: ${course.code}, Description: ${course.description}")
    } shouldBe ()
  }

  it should "return the value and not execute the alternative for .getOrElse" in {
    val okNum = toOk(1)
    okNum.getOrElse(() => println("should not print")) shouldBe 1
  }
}
