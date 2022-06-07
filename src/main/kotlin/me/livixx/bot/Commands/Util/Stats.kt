package me.livixx.bot.Commands.Util

import me.livixx.bot.Commands.Command
import me.livixx.bot.Settings
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDAInfo
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import java.awt.Color
import java.lang.management.ManagementFactory
import java.lang.management.OperatingSystemMXBean

class Stats: Command("${Settings.PREFIX}stats"){
    override fun run(event: GuildMessageReceivedEvent) {
//        event.jda
        val maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024)
        val totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024)
        val freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024)
        val usedMemory: Long = totalMemory - freeMemory

//        val cores: Int = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors()
        val OS: String = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean::class.java).getName()
//        val hostname: String = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean::class.java).hos


        var eb: EmbedBuilder = EmbedBuilder()
            .setColor(Color.BLUE)
             .setTitle("Информация о ${event.jda.selfUser.name}")
             .setThumbnail(event.jda.selfUser.avatarUrl)
             .addField("RAM",
        "\u276F" + " **Max:** " + maxMemory + " MB\n"
        + "\u276F" + " **Total:** " + totalMemory + " MB\n"
        + "\u276F" + " **Free:** " + freeMemory + " MB\n"
        + "\u276F" + " **Used:** " + usedMemory + " MB\n"
        , true)
            .addField("Прочее",
             "Библиотека JDA(${JDAInfo.VERSION})\n"+
                "OS ${OS}",false)

        event.channel.sendMessageEmbeds(eb.build()).queue()
    }

}