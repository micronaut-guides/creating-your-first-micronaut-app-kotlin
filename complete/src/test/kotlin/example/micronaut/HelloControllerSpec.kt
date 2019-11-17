package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals

object HelloControllerSpec: Spek({
    describe("HelloController Suite") {
        var embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java) // <1>
        var client : HttpClient = HttpClient.create(embeddedServer.url) // <2>

        it("test /hello responds Hello World") {
            var rsp : String = client.toBlocking().retrieve("/hello")
            assertEquals("Hello World", rsp)
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})
