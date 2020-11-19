package rockz.marcelgross.processor.entity

data class Artefact(
    val id: String,
    val version: String,
    val lastCommit: Commit
)