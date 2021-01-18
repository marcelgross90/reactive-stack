package rockz.marcelgross.subscriber.entity

import org.springframework.data.annotation.Id

data class Artefact(
    @Id
    val id: String,
    val version: String,
    val lastCommit: Commit
)