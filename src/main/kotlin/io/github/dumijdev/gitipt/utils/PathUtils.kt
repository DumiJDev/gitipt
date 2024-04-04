package io.github.dumijdev.gitipt.utils

import java.nio.file.Path

class PathUtils {
    companion object {
        fun currentDirectory(): Path = Path.of(System.getProperty("user.dir")).toAbsolutePath()
    }
}