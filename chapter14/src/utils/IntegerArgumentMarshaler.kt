package utils

import java.util.NoSuchElementException
import java.lang.NumberFormatException
import utils.ErrorCode.*

class IntegerArgumentMarshaler: ArgumentMarshaler {
    private var intValue = 0

    @Throws(ArgsException::class)
    override fun set(currentArgument: Iterator<String>) {
        var parameter: String? = null
        try {
            parameter = currentArgument.next()
            intValue = Integer.parseInt(parameter)
        } catch (e: NoSuchElementException) {
            throw ArgsException(errorCode = MISSING_INTEGER)
        } catch (e: NumberFormatException) {
            throw ArgsException(errorCode = INVALID_INTEGER, errorParameter = parameter)
        }
    }

    companion object {
        fun getValue(am: ArgumentMarshaler?): Int {
            return if (am != null && am is IntegerArgumentMarshaler) {
                am.intValue
            } else {
                0
            }
        }
    }
}