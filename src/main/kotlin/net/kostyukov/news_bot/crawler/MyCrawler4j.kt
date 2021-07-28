//package net.kostyukov.news_bot.crawler
//
//import edu.uci.ics.crawler4j.crawler.Page
//import edu.uci.ics.crawler4j.crawler.WebCrawler
//import edu.uci.ics.crawler4j.parser.HtmlParseData
//import edu.uci.ics.crawler4j.url.WebURL
//import java.io.File
//import java.util.concurrent.atomic.AtomicInteger
//
//class MyCrawler4j : WebCrawler() {
//
//    private val FILTERS: Regex = Regex(".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|" +
//            "mov|mpeg|ram|m4v|pdf|rm|smil|wmv|swf|wma|zip|rar|gz|tar|ico))$", RegexOption.IGNORE_CASE)
//    private val FILTERS_TO_MATCH: Regex = Regex(".*(Линейное%20уравнение|.*linein.*-uravnen.*|.*linejn.*-uravnen.*|.*uravnen.*)", RegexOption.IGNORE_CASE)
//
//    private val counter = AtomicInteger()
//
//    override fun shouldVisit(referringPage: Page?, url: WebURL?): Boolean {
//        counter.incrementAndGet()
//        if (url != null) {
//            return !FILTERS.matches(url.url) && FILTERS_TO_MATCH.matches(url.url)
//        }
//        return false
//
//    }
//
//    override fun visit(page: Page?) {
//        if (page != null) {
//            val parseData = page.parseData
//            if(parseData is HtmlParseData) {
//                val title = parseData.title
//                val text = parseData.text
//                File("/tmp/crawler4j/test_$title.txt").writeText(text)
//            }
//            println("Fucking message")
//        }
//    }
//
//    override fun onBeforeExit() {
//        println("Total number of tried pages is $counter")
//    }
//
//}