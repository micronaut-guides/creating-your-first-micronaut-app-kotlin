package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello") // <1>
class HelloController {

    @Get("/")  // <2>
    fun index(): String {
        return "Hello World"  // <3>
    }
}