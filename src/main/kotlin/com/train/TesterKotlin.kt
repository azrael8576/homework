package com.train

import java.util.*


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
var ticket : TicketKotlin? = null
var leave = false

fun main(args: Array<String>) {
    println("\n*********Kotlin*********\n")
    while (true) {
        inputTicket()
        if (leave == true) {
            println("leave!!")
            break
        }
        println("Total tickets: " + ticket?.total)
        println("Round-trip: " + ticket?.roundTrip)
        println("Total: " + ticket?.totalAmout())
        println("-----------------------------")
    }
}

//確認是否leave
private fun inputTicket() {
    var total: Int
    var roundTrip = 0
    if (leave == false) {
        println("Please enter number of tickets:")
        total = checkNumber()
        if (total == -1) {
            leave = true
        }
        while (leave == false) {
            println("How many round-trip tickets:")
            roundTrip = checkNumber()
            if (roundTrip == -1) {
                leave = true
            }
            if (roundTrip <= total) {
                ticket = TicketKotlin(total, roundTrip)
                break
            } else
                println("Error,please enter again.")
        }
    }
}


//確認是否大於-1且為數字
private fun checkNumber(): Int {
    var number: Int
    while (true) {
        val scanner = Scanner(System.`in`)
        if (scanner.hasNextInt()) {
            number = scanner.nextInt()
            if (number < -1)
                println("Error,please enter again.")
            else
                break
        } else
            println("Error,please enter a number.")
    }
    return number
}