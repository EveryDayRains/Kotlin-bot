package me.livixx.bot.Commands.Info

import me.livixx.bot.Commands.Command
import me.livixx.bot.Settings
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import java.awt.Color

class Avatar: Command("${Settings.PREFIX}avatar") {
    override fun run(event: GuildMessageReceivedEvent) {
        var user = event.author;

        if(!event.message.mentionedMembers.isEmpty()) user = event.message.mentionedUsers.get(0)

        val avatar: String = user.effectiveAvatarUrl
        val x64: String = "$avatar?size=64"
        val x128: String = "$avatar?size=128"
        val x256: String = "$avatar?size=256"
        val x512: String = "$avatar?size=512"
        val x1024: String = "$avatar?size=1024"
        val x2048: String = "$avatar?size=2048"


        val embed = EmbedBuilder()
            .setAuthor("Аватарка ${user.asTag}")
            .setDescription("Ссылки:\n"+
            "\u2022 [x64](${x64})\n"+
            "\u2022 [x128](${x128})\n"+
            "\u2022 [x256](${x256})\n"+
            "\u2022 [x512](${x512})\n"+
            "\u2022 [x1024](${x1024})\n"+
            "\u2022 [x2048](${x2048})\n")
            .setImage(x1024)
            .setColor(Color.CYAN)

        event.channel.sendMessageEmbeds(embed.build()).queue();
    }
}