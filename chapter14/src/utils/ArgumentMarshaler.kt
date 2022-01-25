package utils

interface ArgumentMarshaler {
    @Throws(ArgsException::class)
    fun set(currentArgument: Iterator<String>)   // throws ArgsException
}