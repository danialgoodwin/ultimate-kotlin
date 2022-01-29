package dev.goodwin.common

import java.util.Date

/** Helper methods for dealing with date and time. */
object DateTime {

    fun localMillis(): Long = Date().time

    fun utcMillis(): Long = System.currentTimeMillis()

}
