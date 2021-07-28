//import net.kostyukov.news_bot.crawler.MyCrawler4j
import net.kostyukov.news_bot.dbconfig.DatabaseConfig
import net.kostyukov.news_bot.domain.user.UserTransformer
import net.kostyukov.news_bot.telegram.NonCommand
import net.kostyukov.news_bot.telegram.command.AddSiteCommand
import net.kostyukov.news_bot.telegram.command.HelperCommand
import net.kostyukov.news_bot.telegram.command.StartCommand
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.meta.api.objects.Update

class Bot
    (private val BOT_NAME: String, private val BOT_TOKEN: String, val databaseConfig: DatabaseConfig)
        : TelegramLongPollingCommandBot() {

    val nonCommand = NonCommand()
    init {
        register(StartCommand("start", "Start", UserTransformer(), databaseConfig))
        register(HelperCommand("help", "Help"))
        register(AddSiteCommand("add_site", "Add site", databaseConfig))
    }

    override fun getBotToken(): String {
        return BOT_TOKEN
    }

    override fun getBotUsername(): String {
        return BOT_NAME
    }

    override fun processNonCommandUpdate(update: Update?) {
        execute(nonCommand.processNonCommand(update))
    }


}