package rockz.marcelgross.publisher

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class PublisherWebClient {

    @Bean
    fun webClient() = WebClient.create("http://whatthecommit.com/").mutate().build()
}