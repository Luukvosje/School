package machine

//Twee functies:
//fun sum - som van 4 getallen
//fun average - Gemiddelde van 4 getallen
//Create a function called average that calculates the average of the numbers passed as parameters. The previously created method sum must be used inside this function!
fun Sum(a: Int, b: Int, c: Int, d: Int): Int {
    return a + b + c + d;
}

fun main() {
    christmasTree(10)
    countDigits("aaapen 2 4padkmawd5")
    onlyLetters("Geen witruimte cijfers 1,2,3 of leestekens..")
//    multiplicationTable(3)
//        println("Enter gift:")
//        val gift = readln().toInt()
//        val tax = calculateGiftTax(gift)
//        if (tax == 0.0) {
//            println("No tax!")
//        } else {
//            println("For the gift of $gift euro you need to pay $tax euro.")
//        }
}

// Kotlin Playground runs instantly and cannot read from console
// Here we simulate reading from console using our own function readln()

private fun calculateGiftTax(gift: Int): Double {
    val tax = when (gift) {
        in 5000..25000 -> return 100 + ((gift - 5000) * 0.08)
        in 25000..55000 -> return 1700 + ((gift - 25000) * 0.1)
        in 55000..200000 -> return 4700 + ((gift - 55000) * 0.12)
        in 20000..1000000 -> return 22100 + ((gift - 20000) * 0.15)
        in 1000000..Int.MAX_VALUE -> return 142100 + ((gift - 1000000) * 0.17)
        in 0..Int.MIN_VALUE -> 0
        else -> gift
    }
    /* https://www.vero.fi/en/individuals/property/gifts/:
       A gift is a transfer of property to another person against no compensation or payment.
       If the total value of the gifts you receive from the same donor in the course of 3 years is €5,000 or more, you must pay gift tax.

      When a gift is given by a close relative or a family member, the amount of gift tax is determined by the following table (source vero.fi):
      Value of gift
      For example 6000€ gift implies 180€ of gift tax (100 + (6000-5000) * 0.08),
      and 75000€ gift implies 7100€ of gift tax (4700 + (75000-55000) * 0.12).

      Tax at the lower limit	Tax rate(%) for exceeding pa rt
       5.000 — 25.000  	    100	                    8
       25.000 — 55.000	    1700                 	10
       55.000 — 200.000     4 700					12
       200.000 — 1000.000   22 100					15
       1.000.000 —		    142.100					17
     */
    return tax.toDouble();
}


//Tafel van vermenigvuldigingen
//Create the function multiplicationTable that prints the multiplication table of the given number.
// The multiplication table prints the rows with the help of the printMultiplicationTableRow function.

private fun multiplicationTable(max: Int): Int {
    for (i in 1..max) {
        printMultiplicationTableRow(max, i)
    }
    return 0;
}

private fun printMultiplicationTableRow(number: Int, coefficient: Int): Unit {
    for (i in 1..number) {
        print(i * coefficient)
    }
    println();
}

//Oefenen met loops en doorlopen String, gebruik predicaten op Char zoals isLetter():
fun sumOfEven(n: Int): Int {
    var sum = 0;
    for (i in 2..n step 2) {
        sum += i
    }
    return sum;
}

fun countDigits(s: String): Int {
    var sum = 0
    for (i in s) {
        if (i.isDigit()) {
            sum++;
        }
    }
    println(sum);
    return sum;
}

fun onlyLetters(s: String): String {
    var str = ""
    for (i in s) {
        if (i.isLetter()) {
            str += i;
        }
    }
    println(str);
    return str;
}

fun printSpaces(count: Int) {
    repeat(count) { print(" ") }
}

fun printStars(count: Int) {
    repeat(count) { print("*") }
}

private fun christmasTree(size: Int): Unit {
    for (i in 1..size) {
        val spaces = size - i
        val stars = 2 * i - 1
        printSpaces(spaces)
        printStars(stars)
        println()
    }
    for (i in 1..2) {
        printSpaces(size - 2)
        printStars(3)
        println()
    }
//    for (i in 1..height) {
//        println("".repeat((height -i) / 2 - 1))
//        print("*")
//        println("".repeat((height -i) / 2 - 1))
//    }
    // given: christmasTree(4)
    // expected:
    //

    //    *
    //   ***
    //  *****
    // *******
    //   ***
    //   ***

    // given: christmasTree(9)
    // expected:
    //

    /*
             *
            ***
           *****
          *******
         *********
        ***********
       *************
      ***************
     *****************
    *******************
            ***
            ***
      */
}

