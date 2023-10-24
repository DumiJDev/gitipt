package org.github.dumijdev.gitipt.command

import org.github.dumijdev.gitipt.command.git.AddCommand
import org.github.dumijdev.gitipt.command.git.CloneCommand
import org.github.dumijdev.gitipt.command.git.CommitCommand
import org.github.dumijdev.gitipt.command.git.InitCommand
import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(name = "gitipt", subcommands = [CloneCommand::class, AddCommand::class, CommitCommand::class, InitCommand::class])
class GitCommand