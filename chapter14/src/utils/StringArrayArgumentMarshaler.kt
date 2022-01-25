package utils

import java.util.NoSuchElementException
import utils.ErrorCode.*

class StringArrayArgumentMarshaler: ArgumentMarshaler {
    private var stringArrayValue: Array<String> = emptyArray()

    @Throws(ArgsException::class)
    override fun set(currentArgument: Iterator<String>) {
        var parameter: String? = null
        try {
            parameter = currentArgument.next()
            stringArrayValue = parameter.split(",").toTypedArray()
        } catch (e: NoSuchElementException) {
            throw ArgsException(errorCode = MISSING_STRING)
        }
    }

    companion object {
        fun getValue(am: ArgumentMarshaler?): Array<String> {
            return if (am != null && am is StringArrayArgumentMarshaler) {
                am.stringArrayValue
            } else {
                emptyArray()
            }
        }
    }
}