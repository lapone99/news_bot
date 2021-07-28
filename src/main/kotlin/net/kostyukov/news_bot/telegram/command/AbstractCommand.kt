package net.kostyukov.news_bot.telegram.command

import org.slf4j.LoggerFactory
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.bots.AbsSender

abstract class AbstractCommand
    (commandIdentifier: String?, description: String?) :
    BotCommand(commandIdentifier, description) {

    val logger = LoggerFactory.getLogger(AbstractCommand::class.java)

        fun sendAnswer(absSender: AbsSender, chatId : Long, commandName : String, userName: String, text: String) {
            val message = SendMessage()
            message.enableMarkdown(true)
            message.chatId = "$chatId"
            message.text = text
            logger.info("Trying to send message $message")
            absSender.execute(message)
            logger.info("Sent message $message")


            //TODO: add logging

        }
}