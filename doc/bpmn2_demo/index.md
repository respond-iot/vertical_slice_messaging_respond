# bpmn2_demo

This is a small proof-of-concept for loading and editing bpmn2 models in code.
It's not currently used for anything productive.

It uses `org.eclipse.bpmn2` to load and represent bpmn2 models.
As `org.eclipse.bpmn2` is not officially available on any maven repositories we instead use the gradle `p2asmaven`
plugin to download it from an eclipse p2 repository.

The `p2asmaven` plugin is added in the main project, so other subprojects can also use libraries from p2 in the future
(although currently none do).