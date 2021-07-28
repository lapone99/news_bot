package net.kostyukov.news_bot.telegram.command

import net.kostyukov.news_bot.dbconfig.DatabaseConfig
import net.kostyukov.news_bot.domain.user.*
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

class StartCommand(commandIdentifier: String?, description: String?, val userTransformer: UserTransformer, val dbConfig: DatabaseConfig)
    : AbstractCommand(commandIdentifier, description) {

    override fun execute(absSender: AbsSender?, user: User?, chat: Chat?, arguments: Array<out String>?) {
        registerUser(user)
        if(user?.userName != null && chat != null && absSender != null) {
            sendAnswer(
                absSender,
                chat.id,
                commandIdentifier,
                user.userName,
                "User registered"
            )
        }
    }

    fun registerUser(user: User?) {
        user?.let {
            dbConfig.getSession().use { session ->
                val mapper = session.getMapper(UserMapper::class.java)
                mapper.insert(UserTransformer.map(it))
                session.commit()
            }
            logger.info("User ${user} is registered")
        } ?: run {
            logger.warn("There was a problem registering user}")
        }


    }
}