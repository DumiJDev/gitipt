package io.github.dumijdev.gitipt.runner

import io.github.dumijdev.gitipt.command.GitCommand
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import picocli.CommandLine

@Component
class CLIRunner(private val gitCommandLine: GitCommand) : CommandLineRunner {
    override fun run(vararg args: String?) {
        CommandLine(gitCommandLine).execute(*args);
    }
}