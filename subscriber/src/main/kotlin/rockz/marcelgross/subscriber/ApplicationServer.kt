package rockz.marcelgross.subscriber

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import rockz.marcelgross.subscriber.entity.Artefact
import java.util.function.Consumer

@Configuration
class ApplicationServer {

    @Bean
    fun runArtefact(): Consumer<Flux<Artefact>> = Consumer {
        it.subscribe {
            log(it)
        }
    }

    private fun log(artefact: Artefact) {
        println("Run artefact $artefact")
    }
}