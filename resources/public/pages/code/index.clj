(defn fizzbuzz-number
  [nb]
  (cond
    (zero? (mod nb 15)) "FizzBuzz"
    (zero? (mod nb 3)) "Fizz"
    (zero? (mod nb 5)) "Buzz"
    :default nb))

(defn fizzbuzz
  [start end]
  (map fizzbuzz-number (range start end)))

(fizzbuzz 1 16)
