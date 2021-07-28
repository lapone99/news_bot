package net.kostyukov.news_bot.dbconfig

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder

class DatabaseConfig {
    val CONFIG_FILE = "mybatis-config.xml"
    lateinit var sqlSessionFactory:SqlSessionFactory;

    fun init() {
        val inputStream = Resources.getResourceAsStream(CONFIG_FILE)
        sqlSessionFactory = SqlSessionFactoryBuilder().build(inputStream)
    }

    fun getSession() : SqlSession = sqlSessionFactory.openSession()

}