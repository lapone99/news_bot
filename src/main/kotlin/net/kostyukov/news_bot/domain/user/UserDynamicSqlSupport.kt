package net.kostyukov.news_bot.domain.user

import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType
import java.time.LocalDate


object UserDynamicSqlSupport {
    val user = User()
    val id = user.id
    val firstName = user.firstName
    val lastName = user.lastName
    val username = user.username
    val isBot = user.isBot


    class User : SqlTable("users") {
        val id = column<Int>(name = "id", jdbcType = JDBCType.INTEGER)
        val firstName = column<String>(name = "first_name", jdbcType = JDBCType.VARCHAR)
        val lastName = column<String>(name = "last_name", jdbcType = JDBCType.VARCHAR)
        val username = column<LocalDate>(name = "username", jdbcType = JDBCType.VARCHAR)
        val isBot = column<Boolean>(name = "is_bot", jdbcType = JDBCType.BOOLEAN)
    }
}