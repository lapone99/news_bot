package net.kostyukov.news_bot.telegram.command

import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class HelperCommand(commandIdentifier: String?, description: String?) : AbstractCommand(commandIdentifier, description) {
    val helperText = "Suported commands:\n" +
            "   /help               - help message\n" +
            "   /start              - registration for saving anchor sites and queries\n" +
            "   /add_sites          - add anchor url for search\n" +
            "   /delete_sites       - delete anchor url from search\n" +
            "   /list_sites         - list all anchor urls for search"
//            "   /list_sites         - list all base urls for search\n"
    override fun execute(absSender: AbsSender?, user: User?, chat: Chat?, arguments: Array<out String>?) {
        if(user?.userName != null && chat != null && absSender != null) {
            sendAnswer(
                absSender,
                chat.id,
                commandIdentifier,
                user.userName,
                helperText
            )
        }
    }
}