# selfhealing

The selfhealing project is responsible for handling failures reported over mqtt and suggesting possible solutions. The
actual solution-finding-algorithm hasn't been written yet, so this is currently only a proof-of-concept.

Structure
---------

`Main.kt`: Contains the main method and commandline parsing logic. Commandline parameters are parsed using
`com.xenomachina:kotlin-argparser`

`interface/MqttHealingProviderInterface.kt`: All code related to sending, receiving, parsing and encoding MQTT messages.
Because there is currently only one endpoint it doesn't use [PathMatcher](../mqttutils/pathmatcher.md), but if more are
added it should be used.

`interface/Payloads.kt`: The payloads which are sent or received by the healing provider. This code is technology agnostic. If
in the future MQTT would be replaced by another protocol only `MqttHealingProviderInterface` would need to be changed.

`HealingProvider.kt`: This class handles selecting possible healing strategies.

`SolutionRepository.kt`: This file contains classes related to storing and querying possible solutions. It is currently
only a stub implementation and will likely be replaced with a EMF based implementation for easy creation of solutions.

