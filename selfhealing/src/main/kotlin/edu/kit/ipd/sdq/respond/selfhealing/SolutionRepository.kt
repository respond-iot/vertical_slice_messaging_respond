package edu.kit.ipd.sdq.respond.selfhealing

import java.util.*

class SolutionRepository {
    private val processes = mapOf<UUID, ProcessSolutions>()

    fun getSolutionForProcess(id: UUID): ProcessSolutions? {
        return processes[id]
    }

}

class ProcessSolutions {
    private val solutions = mapOf<UUID, List<Solution>>()

    fun getSolutions(id: UUID): List<Solution> {
        return solutions[id] ?: emptyList()
    }
}

class Solution(val processId: UUID)
