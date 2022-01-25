package utils

import java.util.NoSuchElementException
import utils.ErrorCode.*

class StringArgumentMarshaler: ArgumentMarshaler {
    private var stringValue = ""

    @Throws(ArgsException::class)
    override fun set(currentArgument: Iterator<String>) {
        try {
            stringValue = currentArgument.next()
        } catch (e: NoSuchElementException) {
            throw ArgsException(errorCode = MISSING_STRING)
        }
    }

    companion object {
        fun getValue(am: ArgumentMarshaler?): String {
            return if (am != null && am is StringArgumentMarshaler) {
                am.stringValue
            } else {
                ""
            }
        }
    }
}