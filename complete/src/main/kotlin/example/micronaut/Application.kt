package example.micronaut

import io.micronaut.runtime.Micronaut.*
object Application {
}

fun main(args: Array<String>) {
	build()
		.mainClass(Application::class.java)
		.packages("example.micronaut")
		.start()
}

