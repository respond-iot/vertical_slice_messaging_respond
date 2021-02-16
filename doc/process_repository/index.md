# process_repository

The process repository stores bpmn2 processes in a database and makes them available using mqtt.
This project also contains a small client which can be used for uploading processes to the repository.

This project uses hibernate for accessing the database.

Structure
---------

`Main.kt`: Contains the main method and commandline parsing logic. Commandline parameters are parsed using
`com.xenomachina:kotlin-argparser`

`interface/MqttRepositoryInterface.kt`: All code related to sending, receiving, parsing and encoding MQTT messages.
This makes use of [PathMatcher](../mqttutils/pathmatcher.md) and Kotlin Extension Functions.

`interface/Payloads.kt`: The payloads which are sent or received by the repository. This code is technology agnostic. If
in the future MQTT would be replaced by another protocol only `MqttRepositoryInterface` would need to be changed.

`Repository.kt`: This class handles all communication with the database. The Hibernate library is used for this.

`tables/*`: Data classes encoding data stored in the database. These classes are annotated using Hibernate and
`javax.persistance` annotations.

`client/*`: This directory contains code for a small CLI client for interacting with the database. It's meant for
debugging and testing. It uses the payloads from `interface/Payloads.kt`, so it is always in sync with the actual
repository.

Known problems
--------------

* The repository seems to crash sometimes
* Deleting a single process does not work