package utils

import java.util.NoSuchElementException
import utils.ErrorCode.*

class StringArgumentMarshaler: ArgumentMarshaler {
    private var stringValue = ""

    override fun set(currentArgument: Iterator<String>) {
        try {
            stringValue = currentArgument.next()
        } catch (e: NoSuchElementException) {
            throw ArgsException(MISSING_STRING)
        }
    }

    fun getValue(am: ArgumentMarshaler?): String {
        return if (am != null && am is StringArgumentMarshaler) {
            am.stringValue
        } else {
            ""
        }
    }
}