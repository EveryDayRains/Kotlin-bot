package me.livixx.bot

import me.livixx.bot.Commands.Info.Avatar
import me.livixx.bot.Commands.Util.Ping
import me.livixx.bot.Commands.Util.Stats
import me.livixx.bot.Listeners.Events
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.cache.CacheFlag


class Bot(val Token: String) {

    val commands = listOf (
        Stats(),
        Ping(),
        Avatar()
    )

    fun start() {
        println("Commands available: ${commands.size}\n")
        println("Stating..")



      JDABuilder.createDefault(Token)
            .setAutoReconnect(true)
            .setEnabledIntents(GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.GUILD_EMOJIS
            )
            .setStatus(OnlineStatus.IDLE)
            .setActivity(Activity.playing("Hello world!"))
            .enableCache(CacheFlag.VOICE_STATE, CacheFlag.ACTIVITY, CacheFlag.EMOTE)
            .addEventListeners(Events(this))
            .build()

    }
}