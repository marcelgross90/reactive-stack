package rockz.marcelgross.subscriber

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import rockz.marcelgross.subscriber.entity.Artefact
import rockz.marcelgross.subscriber.repository.CommitRepository
import java.util.function.Consumer

@Configuration
class ApplicationServer(
    private val repo: CommitRepository
) {

    @Bean
    fun runArtefact(): Consumer<Flux<Artefact>> = Consumer {
        it.flatMap {artefact ->
            repo.save(artefact.lastCommit)

        }
        .subscribe {artefact ->
            println(artefact)
//            log(artefact)
        }

    }

    private fun log(artefact: Artefact) {
        println("Run artefact $artefact")
    }
}