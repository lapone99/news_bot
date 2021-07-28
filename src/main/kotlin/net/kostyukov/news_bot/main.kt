import net.kostyukov.news_bot.dbconfig.DatabaseConfig
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.util.*

var BOT_PROPERTIES = Properties()

fun main() {
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
    val databaseConfig = DatabaseConfig()
    databaseConfig.init()
    initBotProperties()
    telegramBotsApi.registerBot(
        Bot(BOT_PROPERTIES.getProperty("BOT_NAME"),
            BOT_PROPERTIES.getProperty("BOT_TOKEN"),
            databaseConfig
        )
    )
}

fun initBotProperties() {
    val fis = object {}.javaClass.getResourceAsStream("bot.properties")
    BOT_PROPERTIES.load(fis)
}