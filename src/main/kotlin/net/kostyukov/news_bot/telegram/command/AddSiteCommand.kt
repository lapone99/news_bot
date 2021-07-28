package net.kostyukov.news_bot.telegram.command

import net.kostyukov.news_bot.dbconfig.DatabaseConfig
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class AddSiteCommand(commandIdentifier: String?, description: String?, val databaseConfig: DatabaseConfig)
        : AbstractCommand(commandIdentifier, description) {

    init {

    }

    override fun execute(absSender: AbsSender?, user: User?, chat: Chat?, arguments: Array<out String>?) {

        //todo send help message or figure out how to get arg with command
        registerSite()
    }

    fun registerSite() {
        databaseConfig.getSession()
    }


}