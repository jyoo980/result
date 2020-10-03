abstract class Result[+A, +B] {

  abstract def isOk: Boolean

  abstract def isErr: Boolean

  // TODO: implement concrete members
}
