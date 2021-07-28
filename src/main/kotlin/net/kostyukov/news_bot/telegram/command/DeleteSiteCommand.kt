package net.kostyukov.news_bot.telegram.command

import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class DeleteSiteCommand(commandIdentifier: String?, description: String?) : AbstractCommand(commandIdentifier,
    description
) {
    override fun execute(absSender: AbsSender?, user: User?, chat: Chat?, arguments: Array<out String>?) {
        TODO("Not yet implemented")
    }
}