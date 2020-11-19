package rockz.marcelgross.processor

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import rockz.marcelgross.processor.entity.Artefact
import rockz.marcelgross.processor.entity.Commit
import java.util.UUID
import java.util.function.Function
import kotlin.random.Random

@Configuration
class BuildServer {

    @Bean
    fun prepareBuild(): Function<Flux<Commit>, Flux<Artefact>> = Function {
        it.map { commit ->
            val artefact = Artefact(
                id = UUID.randomUUID().toString(),
                version = "",
                lastCommit = commit
            )
            logPrepare(commit)

            artefact
        }
    }

    @Bean
    fun build(): Function<Flux<Artefact>, Flux<Artefact>> = Function {
        it.map {
            val artefact = it.copy(version = "release/${Random.nextInt()}")
            logBuild(artefact)

            artefact
        }
    }

    private fun logBuild(artefact: Artefact) {
        log("Build Artefact: $artefact")
    }

    private fun logPrepare(commit: Commit) {
        log("Prepare Commit: $commit")
    }

    private fun log(logMessage: String) {
        println(logMessage)
    }
}