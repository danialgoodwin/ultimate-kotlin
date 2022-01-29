package dev.goodwin.experimental

import dev.goodwin.experimental.KtBasicHttp.body
import dev.goodwin.experimental.KtBasicHttp.head
import dev.goodwin.experimental.KtBasicHttp.html
import dev.goodwin.experimental.KtBasicHttp.title
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KtBasicHttpTest {

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
