package me.livixx.bot

import lavalink.client.io.Lavalink
import lavalink.client.io.jda.JdaLavalink

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        val bot = Bot(Settings.BOT_TOKEN)

        bot.start()

    }
}