import utils.ArgsException

class ArgsMain {
    fun main(args: Array<String>) {
        try {
            var arg: Args = Args("l,p#,d*", args)
            var logging: Boolean = arg.getBoolean('l')
            var port = arg.getInt('p')
            var directory = arg.getString('d')
            executeApplication(logging, port, directory)
        } catch (e: ArgsException) {
            System.out.printf("Argument error: %s\n", e.errorMessage())
        }

    }

    private fun executeApplication(logging: Boolean, port: Any, directory: Any) {
        TODO("Not yet implemented")
    }
}