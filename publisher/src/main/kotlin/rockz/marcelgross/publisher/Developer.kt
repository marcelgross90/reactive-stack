package rockz.marcelgross.publisher

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import rockz.marcelgross.publisher.entity.Commit
import java.util.UUID
import kotlin.random.Random

@Component
class Developer(
    private val client: PublisherWebClient
) {

    val authors = listOf("Peter", "Hans", "Klaus")

    fun createCommit() = commitMessage().map {
        Commit(
            id = UUID.randomUUID().toString(),
            author = authors[Random.nextInt(authors.size)],
            message = it
        )
    }

    fun commitMessage(): Mono<String> {
        fun extractMessage(html: String) =
            html.substringAfter("<p>").substringBefore("</p>").replace("\\n".toRegex(), "")
        return client.webClient().get().retrieve().bodyToMono<String>().flatMap { Mono.just(extractMessage(it)) }
    }

}