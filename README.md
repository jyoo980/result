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

