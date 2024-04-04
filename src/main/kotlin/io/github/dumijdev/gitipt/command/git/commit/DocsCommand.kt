package io.github.dumijdev.gitipt.command.git.commit

import org.eclipse.jgit.api.Git
import io.github.dumijdev.gitipt.utils.PathUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine.*

@Command(name = "doc")
class DocsCommand : Runnable {
    private val logger: Logger = LoggerFactory.getLogger("gitipt")

    @Parameters(index = "0")
    private var message: String? = null

    override fun run() {
        val currentDirectory = PathUtils.currentDirectory()
        logger.info("Abrindo o repositório local do git")
        val repo = Git.open(currentDirectory.toFile())

        val commit = repo.commit()

        if(message.isNullOrEmpty()) {
            logger.warn("Mensagem não pode estar em branco ou ausente")
            return
        }

        commit.message = "docs: $message"

        commit.call()
    }
}