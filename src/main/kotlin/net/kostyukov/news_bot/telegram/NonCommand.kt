package net.kostyukov.news_bot.telegram

//import edu.uci.ics.crawler4j.crawler.WebCrawler
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class NonCommand {
//    class NonCommand(val webCrawler: WebCrawler) {

    fun processNonCommand(update: Update?) : SendMessage {
        val message = update?.message
        val chatId = message?.chatId
        val sendMessage = SendMessage()
        sendMessage.chatId = chatId.toString()
        sendMessage.text = "Unrecognized command. Please use /help to find possible bot commands"
        return sendMessage
    }



}
