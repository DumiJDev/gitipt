package io.github.dumijdev.gitipt.command.git

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.GitCommand
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import java.io.File
import java.nio.file.Paths
import java.util.logging.Logger

@Command(name = "inicializa")
class InitCommand : Runnable {

    private val logger = Logger.getLogger("gitipt")

    @Parameters(index = "0")
    private var directory: String? = null

    override fun run() {

        val currentDirectory = File(directory ?: Paths.get("").toAbsolutePath().toString())

        if (!currentDirectory.isDirectory){
            logger.warning("Diretório inválido ($currentDirectory)")
            return
        }

        val init = Git.init().setDirectory(currentDirectory).setInitialBranch("master").call()

        val dir = init.add().addFilepattern(".").call()

        val commit = init.commit().setMessage("Primeira confirmação").call()

        logger.info("Repositório criado com sucesso ($currentDirectory)")

    }
}