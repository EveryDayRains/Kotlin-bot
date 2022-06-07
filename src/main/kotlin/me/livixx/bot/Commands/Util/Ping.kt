package me.livixx.bot.Commands.Util

import me.livixx.bot.Commands.Command
import me.livixx.bot.Settings
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Ping: Command("${Settings.PREFIX}ping") {
    override fun run(event: GuildMessageReceivedEvent) {
        event.channel.sendMessage("Pong! ${event.jda.gatewayPing}").queue();
    }
}