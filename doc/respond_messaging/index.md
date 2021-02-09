# respond_messaging

This contains mqtt messages for the filling station simulator. Originally it was planned for it to also contain mqtt
messages for other projects, but this has not happened in favour of not having to include unrelated messages in all
projects.

This also contains `com.google.gson.typeadapters.RuntimeTypeAdapterFactory`, which belongs to, but is not shipped with
`com.google.gson`, as it is not officially supported. It is used to convert json objects to instances of the correct
class in a type-hierarchy.