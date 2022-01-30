package dev.goodwin.experimental

import dev.goodwin.experimental.KtBasicHtml.body
import dev.goodwin.experimental.KtBasicHtml.head
import dev.goodwin.experimental.KtBasicHtml.html
import dev.goodwin.experimental.KtBasicHtml.title
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KtBasicHtmlTest {

    @Test
    fun html() {
        val html = html {
            head {
                title { "My Title" }
            } +
            body { "dan-test" }
        }
        assertEquals("<!doctype html>" +
                "\n<html lang=\"en\">" +
                "\n<head>" +
                "\n<title>My Title</title></head>" +
                "\n<body>dan-test</body>" +
                "\n</html>", html)
    }

}
