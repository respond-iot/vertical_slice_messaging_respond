# PathMatcher

A small kotlin dsl for matching mqtt topics  (or other path like string, such as file system paths).

Create a `PathMatcher` instance like this:
```kotlin
val paths = PathMatcher(prefix = "<path_prefix>") {
    "<path1>" { callback1() }
    "<path_with_regex_capture_groups>" { callback2(it[0]) }
    default {
        print("Unknown path")
    }
}
```
The `prefix` parameter is optional. Both the prefix and the paths are regex strings. If the regex contains capture
groups the captured strings are available as `it[number]`.

Then match a topic using 
```kotlin
paths.match("<topic>")
```
This will automatically call the correct callback for the path.