package rockz.marcelgross.subscriber.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import rockz.marcelgross.subscriber.entity.Commit

interface CommitRepository: ReactiveCrudRepository<Commit, String> {
}