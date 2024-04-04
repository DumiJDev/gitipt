package io.github.dumijdev.gitipt.command.git

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.CredentialsProvider
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import java.util.*

@Command(name = "clona")
class CloneCommand : Runnable {

    @Parameters(index = "0")
    var repositoryUrl: String? = null

    override fun run() {



        val cloneCommand = Git.cloneRepository()
            .setCredentialsProvider(CredentialsProvider.getDefault())
            .setURI(repositoryUrl)

        try {
            val git = cloneCommand.call()

            println("Clonado com sucesso!!!")
        } catch (ex: Exception) {
            if (CredentialsProvider.getDefault() != null) {
                val input = Scanner(System.`in`)

                print("Digite o usuário ou email: ")
                val username = input.nextLine()

                print("Digite a senha: ")
                val password = readPassword()

                CredentialsProvider.setDefault(UsernamePasswordCredentialsProvider(username, password))
            }

            val git = cloneCommand.setCredentialsProvider(CredentialsProvider.getDefault()).call()

            println("Clonado com sucesso!!!")
        }
    }

    private fun readPassword(): String {
        val senha = StringBuilder()
        val console = System.console()
        if (console == null) {
            // Se o console não estiver disponível, usar Scanner
            val scanner = Scanner(System.`in`)
            senha.append(scanner.nextLine())
        } else {
            // Se o console estiver disponível, usar Console
            val senhaArray = console.readPassword()
            for (c in senhaArray) {
                senha.append(c)
            }
        }
        return senha.toString()
    }
}