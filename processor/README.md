# Processor

This is the processor of a project with a reactive pipline with Kotlin & Spring.

This processor uses rabbitmq to consume a `Commit` within a Flux, transform it to an `Artefacct` and than publishit again as a Flux.