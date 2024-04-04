package io.github.dumijdev.gitipt.command.git

import io.github.dumijdev.gitipt.command.git.commit.DocsCommand
import io.github.dumijdev.gitipt.command.git.commit.FeatCommand
import picocli.CommandLine.Command
import picocli.CommandLine.RunAll

@Command(name = "confirma", subcommands = [FeatCommand::class, DocsCommand::class])
class CommitCommand