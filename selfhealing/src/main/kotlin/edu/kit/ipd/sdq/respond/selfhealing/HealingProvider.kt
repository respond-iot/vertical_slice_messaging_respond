package edu.kit.ipd.sdq.respond.selfhealing

import edu.kit.ipd.sdq.respond.selfhealing.`interface`.*
import java.util.*

class HealingProvider {
    private val solutionRepository = SolutionRepository()

    fun findSolution(failure: FailurePayload): HealingPayload {
        val processSolutions = solutionRepository.getSolutionForProcess(failure.definitionId.id)
            ?: return defaultPayload(failure.id)

        val solutions: List<Solution> = processSolutions.getSolutions(failure.failureId)
        return HealingPayload(
            solutions.map { it.toProcessPayload() },
            failure.task
        )
    }

    private fun defaultPayload(id: UUID) = HealingPayload(
        listOf(ProcessPayload(
            DefinitionIdPayload(UUID.fromString("15c81df0-509c-4459-b7d2-485c9f69f5be"), "1.0")
        )),
        TaskPayload(id)
    )
}

fun Solution.toProcessPayload() = ProcessPayload(DefinitionIdPayload(this.processId, "1.0"))
