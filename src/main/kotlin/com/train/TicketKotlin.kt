package com.train


/**
 * Created by AlexHe on 2018-12-27.
 * Describe
 */

data class ticketKotlin(var total : Int, var roundTrip : Int, val single : Int = total-roundTrip){
    fun totalAmout(): Double {
        return single * 1000 + roundTrip.toDouble() * 0.9 * 2000.0
    }
}

