package example.micronaut

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.micronaut")
                .mainClass(Application.javaClass)
                .start()
    }
}