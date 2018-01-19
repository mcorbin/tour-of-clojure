(defn fizzbuzz-number
  [nb]
  (condp = 0
    (mod nb 15) "FizzBuzz"
    (mod nb 3) "Fizz"
    (mod nb 5) "Buzz"
    nb))

(defn fizzbuzz
  [start end]
  (map fizzbuzz-number (range start end)))

(fizzbuzz 1 16)
