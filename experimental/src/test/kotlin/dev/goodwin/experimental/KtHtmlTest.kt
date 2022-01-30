package dev.goodwin.experimental

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KtHtmlTest {

    @Test
    fun html() {
        val html = KtHtml {
            head {
                title("My Title")
            }
            body {
                h1 { "My h1" }
                p { "My p" }
            }
        }.build()
        assertEquals("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>My Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>My h1</h1>\n" +
                "<p>My p</p>\n" +
                "</body>\n" +
                "</html>", html)
    }

    @Test
    fun html_single() {
        val titleHtml = KtHtml {
            head { title("My Head Title") }
        }.build()
        assertEquals("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>My Head Title</title>\n" +
                "</head>\n" +
                "</html>", titleHtml)

        val menuHtml = KtHtml {
            body {
                menu {
                    menuItem("mi1") { "" }
                    menuItem("mi2") { "" }
                }
            }
        }.build()
        assertEquals("<!doctype html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<menu>\n" +
                "<menuitem>mi1</menuitem>\n" +
                "<menuitem>mi2</menuitem>\n" +
                "</menu>\n" +
                "</body>\n" +
                "</html>", menuHtml)
    }

}
