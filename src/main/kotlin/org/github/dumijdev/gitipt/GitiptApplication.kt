package org.github.dumijdev.gitipt

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class GitiptApplication

fun main(args: Array<String>) {
    val app = SpringApplication(GitiptApplication::class.java)
    app.setBannerMode(Banner.Mode.OFF)
    app.setLogStartupInfo(false)
    app.run(*args)
}
