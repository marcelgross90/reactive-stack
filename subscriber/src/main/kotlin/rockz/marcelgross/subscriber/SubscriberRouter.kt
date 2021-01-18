package rockz.marcelgross.subscriber

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SubscriberRouter {

    @Bean
    fun router(subscriberHandler: SubscriberHandler) = org.springframework.web.reactive.function.server.router {

        GET("/count", subscriberHandler::count)
        GET("/all", subscriberHandler::all)
    }
}