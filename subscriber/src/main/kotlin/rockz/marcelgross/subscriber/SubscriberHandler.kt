package rockz.marcelgross.subscriber

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import rockz.marcelgross.subscriber.entity.Commit
import rockz.marcelgross.subscriber.repository.CommitRepository

@Component
class SubscriberHandler(
    private val repository: CommitRepository
) {

    fun count(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
            .body(BodyInserters.fromValue("Count ${repository.count()}"))
    }

    fun all(req: ServerRequest) = ServerResponse.ok()
        .body(repository.findAll(), Commit::class.java)

}