import org.scalatest.matchers._
import org.scalatest.flatspec.AnyFlatSpec

class OkSpec extends AnyFlatSpec with should.Matchers
  with ResultFixture {

  "an Ok[A]" should "return true for Result.isOk" in {
    val okNum = toOk("error", 2)
    okNum.isOk shouldBe true
  }

  it should "return false for Result.isErr" in {
    val okNum = toOk("error", 3)
    okNum.isErr shouldBe false
  }
}
