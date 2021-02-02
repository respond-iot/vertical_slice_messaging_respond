package edu.kit.ipd.sdq.respond.selfhealing

import edu.kit.ipd.sdq.respond.selfhealing.`interface`.*
import java.util.*

class HealingProvider {
    fun findSolution(failure: FailurePayload): HealingPayload {
        return defaultPayload(failure.task.id)
    }

    private fun defaultPayload(id: UUID) = HealingPayload(
        ProcessPayload(
            DefinitionIdPayload(UUID.fromString("15c81df0-509c-4459-b7d2-485c9f69f5be"), "1.0")
        ),
        TaskPayload(id)
    )
}