package com.train


/**
 * Created by AlexHe on 2018-12-27.
 * Describe 假設只有台北到高雄的票，單程票價1000元，來回票為2000元再打九折
，		請設計 Tester.java與TestKotlin.kt ，讓它執行後完成以下規範 :

1. 詢問使用者要購買張數，如下:
Please enter number of tickets:
2. 取得使用者輸入的張數後，再詢問幾張來回票，如下:
How many round-trip tickets:
3. 最後印出本次的張數、來回票數與總金額，如下:
Total tickets: 5
Round-trip: 3
Total: 7400


 */
var ticket : ticketKotlin? = null

fun main(args: Array<String>) {
    println("\n*********Kotlin*********\n")
    inputTicket()
    println("Total tickets: " + ticket?.total)
    println("Round-trip: " + ticket?.roundTrip)
    println("Total: " + ticket?.totalAmout())
}

private fun inputTicket() {
    var total: Int
    var roundTrip: Int
    println("Please enter number of tickets:")
    total = checkNumber()
    println("How many round-trip tickets:")
    while (true) {
        roundTrip = checkNumber()
        if (roundTrip <= total) {
            break
        } else
            println("Error,please enter again.")
    }
    ticket = ticketKotlin(total, roundTrip)
}



private fun checkNumber(): Int {
    var number: Int
    while (true) {
        var readLine = readLine()
        if (readLine!!.matches(Regex("\\d+"))) {
            if (readLine.toInt() >= 0) {
                number = readLine.toInt()
                break
            }
            else println("Error,please enter again.")
        } else println("Error,please enter again.")
    }
    return number
}