# NumberReducer

This is a little sample project that I did after an interview to showcase:
  * Factory Pattern
  * Visitor Pattern
  * Groovy unit testing with the spock framework

It is built on the premise that you are given an integer and you need to reduce the number down by adding the digits
of the number together iteratively until the final number is less than 10.

So for example, given the number 1919
first iteration: 20
final iteration: 2

The application lets the user choose between two implementations as well as choose how the results are displayed.

The Application is run by:

java NumberReducerApp [options...] [list of number to reduce]
 -d [PRETTY_PRINT | JSON]     : specifies how to display the result
 -t [BYTE_BASED | MATH_BASED] : specifies the type of reducer

  Example: java NumberReducerApp  -d JSON -t BYTE_BASED 101 1919 123456790
