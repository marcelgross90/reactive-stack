package rockz.marcelgross.subscriber.entity

data class Artefact(
    val id: String,
    val version: String,
    val lastCommit: Commit
)