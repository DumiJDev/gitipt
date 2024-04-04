package io.github.dumijdev.gitipt.command

import io.github.dumijdev.gitipt.command.git.AddCommand
import io.github.dumijdev.gitipt.command.git.CloneCommand
import io.github.dumijdev.gitipt.command.git.CommitCommand
import io.github.dumijdev.gitipt.command.git.InitCommand
import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(name = "", subcommands = [CloneCommand::class, AddCommand::class, CommitCommand::class, InitCommand::class])
class GitCommand