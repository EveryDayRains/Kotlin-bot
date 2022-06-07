package me.livixx.bot.Listeners
import me.livixx.bot.Bot
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Events(val bot: Bot): ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return

        println("${event.message.guild.name} : [${event.message.channel.name}] ${event.author.name}: ${event.message.contentRaw}")

        for (command in bot.commands) {
            if (command.handle(event)) {
                return
            }

        }
    }

    override fun onReady(event: ReadyEvent) {
        super.onReady(event)
        println("Online!"+event.jda.selfUser.asTag)
    }
}