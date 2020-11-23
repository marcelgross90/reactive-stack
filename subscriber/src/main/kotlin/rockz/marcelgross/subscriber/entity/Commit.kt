package rockz.marcelgross.subscriber.entity

import org.springframework.data.annotation.Id

data class Commit(
    @Id
    val pk: Long? = null,
    val id: String,
    val author: String,
    val message: String
)