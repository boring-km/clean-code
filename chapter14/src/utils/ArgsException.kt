package utils

import utils.ErrorCode.*

class ArgsException : Throwable {

    var errorArgumentId: Char = '0'
    var errorParameter: String? = null
    var errorCode: ErrorCode = ErrorCode.OK

    constructor(
        errorCode: ErrorCode
    ) : super() {
        this.errorCode = errorCode
    }

    constructor(
        errorParameter: String?,
        errorCode: ErrorCode
    ) : super() {
        this.errorParameter = errorParameter
        this.errorCode = errorCode
    }

    constructor(
        errorArgumentId: Char,
        errorParameter: String?,
        errorCode: ErrorCode
    ) : super() {
        this.errorArgumentId = errorArgumentId
        this.errorParameter = errorParameter
        this.errorCode = errorCode
    }

    constructor(message: String) : super(message)

    fun errorMessage(): String {
        when (errorCode) {
            OK -> return "TILT: Should not get here."
            UNEXPECTED_ARGUMENT -> return String.format("Argument -%c unexpected.", errorArgumentId)
            MISSING_STRING -> return String.format("Argument -%c expects an integer but was '%s'.", errorArgumentId)
            INVALID_INTEGER -> return String.format("Could not find integer parameter for -%c.", errorArgumentId)
            INVALID_DOUBLE -> return String.format("Argument -%c expects a double but was '%s'.", errorArgumentId)
            MISSING_DOUBLE -> return String.format("Could not find double parameter for -%c.", errorArgumentId)
            INVALID_ARGUMENT_NAME -> return String.format("'%c' is not a valid argument name.", errorArgumentId)
            INVALID_ARGUMENT_FORMAT -> return String.format("'%s' is not a valid argument format.", errorParameter)
            else -> return ""
        }
    }
}

