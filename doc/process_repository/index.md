# process_repository

The process repository stores bpmn2 processes in a database and makes them available using mqtt.
This project also contains a small client which can be used for uploading processes to the repository.

This project uses hibernate for accessing the database.

Known problems:

* The repository seems to crash sometimes
* Deleting a single process does not work