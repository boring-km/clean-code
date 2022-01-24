import utils.ArgumentMarshaler

class Args(s: String, args: Array<String>) {
    fun getBoolean(c: Char): Boolean {
        TODO("Not yet implemented")
    }

    fun getInt(c: Char): Any {
        TODO("Not yet implemented")
    }

    fun getString(c: Char): Any {
        TODO("Not yet implemented")
    }

    private var marshalers: Map<Char, ArgumentMarshaler>? = null
}



