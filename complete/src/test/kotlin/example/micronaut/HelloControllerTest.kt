package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest // <1>
class HelloControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient // <2>

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello") // <3>
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Hello World", body)
    }
}