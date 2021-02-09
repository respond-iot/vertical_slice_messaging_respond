# filling_station_simulator

A simulator for the filling station built at HsKA. Due to limited access to the real filling station and changes over
time it's not that accurate.

It is no longer in use.

This project uses the spring framework to offer a web interface and kodein for dependency injection.

It only offers one REST endpoint:
* `/start?broker=<mqttBrokerIP>&topic=<mqttTopic>`: Starts a simulated run and publishes messages to the specified broker
and topic