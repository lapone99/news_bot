package net.kostyukov.news_bot.domain.user

import org.telegram.telegrambots.meta.api.objects.User

class UserTransformer {
    companion object {
        fun map(user: User) : UserRecord = UserRecord(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            username = user.userName,
            isBot = user.isBot
        )
    }
}