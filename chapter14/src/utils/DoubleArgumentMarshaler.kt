package utils

import java.util.NoSuchElementException
import java.lang.NumberFormatException
import utils.ErrorCode.*

class DoubleArgumentMarshaler: ArgumentMarshaler {
    private var doubleValue = 0.0

    @Throws(ArgsException::class)
    override fun set(currentArgument: Iterator<String>) {
        var parameter: String? = null
        try {
            parameter = currentArgument.next()

            doubleValue = parameter.toDouble()
        } catch (e: NoSuchElementException) {
            throw ArgsException(MISSING_DOUBLE)
        } catch (e: NumberFormatException) {
            throw ArgsException(errorCode = INVALID_DOUBLE, errorParameter = parameter)
        }
    }

    companion object {
        fun getValue(am: ArgumentMarshaler?): Double {
            return if (am != null && am is DoubleArgumentMarshaler) {
                am.doubleValue
            } else {
                0.0
            }
        }
    }
}