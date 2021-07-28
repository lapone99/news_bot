package net.kostyukov.news_bot.domain.user

import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.SelectProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertBatch
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.id
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.firstName
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.lastName
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.username
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.isBot
import net.kostyukov.news_bot.domain.user.UserDynamicSqlSupport.user
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter


interface UserMapper : CommonInsertMapper<UserRecord>, CommonDeleteMapper, CommonSelectMapper, CommonUpdateMapper {

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "UserRecordResult", value = [
            Result(column = "id", property = "id"),
            Result(column = "first_name", property = "firstName"),
            Result(column = "last_name", property = "lastName"),
            Result(column = "username", property = "username"),
            Result(column = "is_bot", property = "isBot")
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<UserRecord>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("UserRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): UserRecord?
}

fun UserMapper.insert(row: UserRecord) =
    insert(this::insert, row, user) {
        map(id).toProperty("id")
        map(firstName).toProperty("firstName")
        map(lastName).toProperty("lastName")
        map(username).toProperty("username")
        map(isBot).toProperty("isBot")
    }

private val columnList = listOf(
    id,
    firstName,
    lastName,
    username,
    isBot,
)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(
        this::selectOne,
        columnList,
        user,
        completer
    )

fun UserMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where(id, isEqualTo(id_))
    }
