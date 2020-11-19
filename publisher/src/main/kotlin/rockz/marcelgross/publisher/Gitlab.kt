package rockz.marcelgross.publisher

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import rockz.marcelgross.publisher.entity.Commit
import java.time.Duration
import java.util.function.Supplier

@Configuration
class Gitlab(
    private val developer: Developer
) {

    @Bean
    fun deployCommit() = Supplier {
        Flux.interval(Duration.ofSeconds(1))
            .onBackpressureDrop()
            .flatMap { developer.createCommit() }
            .map { log(it) }
    }

    private fun log(commit: Commit): Commit {
        println("Send: $commit")
        return commit
    }
}