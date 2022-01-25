import utils.*
import utils.ErrorCode.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Args(schema: String, args: Array<String>) {

    private var marshalers: MutableMap<Char, ArgumentMarshaler> = HashMap()
    private var argsFound: MutableSet<Char> = HashSet()
    private lateinit var currentArgument: ListIterator<String>

    init {
        parseSchema(schema)
        parseArgumentStrings(args.toMutableList())
    }

    @Throws(ArgsException::class)
    private fun parseSchema(schema: String) {
        for (element in schema.split(","))
            if (element.isNotEmpty())
                parseSchemaElement(element.trim())
    }

    @Throws(ArgsException::class)
    private fun parseSchemaElement(element: String) {
        val elementId = element[0]
        val elementTail = element.substring(1)
        validateSchemaElementId(elementId)
        if (elementTail.isEmpty())
            marshalers[elementId] = BooleanArgumentMarshaler()
        else if (elementTail.equals("*"))
            marshalers[elementId] = StringArgumentMarshaler()
        else if (elementTail.equals("#"))
            marshalers[elementId] = IntegerArgumentMarshaler()
        else if (elementTail.equals("##"))
            marshalers[elementId] = DoubleArgumentMarshaler()
        else if (elementTail.equals("[*]"))
            marshalers[elementId] = StringArrayArgumentMarshaler()
        else
            throw ArgsException(errorCode = INVALID_ARGUMENT_FORMAT, errorArgumentId = elementId, errorParameter = elementTail)
    }

    @Throws(ArgsException::class)
    private fun validateSchemaElementId(elementId: Char) {
        if (!Character.isLetter(elementId)) {
            throw ArgsException(errorCode = INVALID_ARGUMENT_NAME, errorArgumentId = elementId, errorParameter = null)
        }
    }

    @Throws(ArgsException::class)
    private fun parseArgumentStrings(argsList: MutableList<String>) {
        currentArgument = argsList.listIterator()
        while (currentArgument.hasNext()) {
            val argsString = currentArgument.next()
            if (argsString.startsWith("-")) {
                parseArgumentCharacters(argsString.substring(1))
            } else {
                currentArgument.previous()
                break
            }
        }
    }

    @Throws(ArgsException::class)
    private fun parseArgumentCharacters(argChars: String) {
        for (i in argChars.indices)
            parseArgumentCharacter(argChars[i])
    }

    @Throws(ArgsException::class)
    private fun parseArgumentCharacter(argChar: Char) {
        val m = marshalers[argChar]
        if (m == null) {
            throw ArgsException(errorCode = UNEXPECTED_ARGUMENT, errorArgumentId = argChar, errorParameter = null)
        } else {
            argsFound.add(argChar)
            try {
                m.set(currentArgument)
            } catch (e: ArgsException) {
                e.errorArgumentId = argChar
                throw e
            }
        }
    }

    fun has(arg: Char): Boolean {
        return argsFound.contains(arg)
    }

    fun nextArgument(): Int {
        return currentArgument.nextIndex()
    }

    fun getBoolean(arg: Char): Boolean {
        return BooleanArgumentMarshaler.getValue(marshalers[arg])
    }

    fun getString(arg: Char): String {
        return StringArgumentMarshaler.getValue(marshalers[arg])
    }

    fun getInt(arg: Char): Int {
        return IntegerArgumentMarshaler.getValue(marshalers[arg])
    }

    fun getDouble(arg: Char): Double {
        return DoubleArgumentMarshaler.getValue(marshalers[arg])
    }

    fun getStringArray(arg: Char): Array<String> {
        return StringArrayArgumentMarshaler.getValue(marshalers[arg])
    }

}



