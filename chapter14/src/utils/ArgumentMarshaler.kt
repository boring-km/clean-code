package utils

interface ArgumentMarshaler {
    fun set(currentArgument: Iterator<String>)   // throws ArgsException
}