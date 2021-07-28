package net.kostyukov.news_bot.domain.user

data class UserRecord (
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val username: String? = null,
    val isBot: Boolean? = null
)