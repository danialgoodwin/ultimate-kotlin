package dev.goodwin.experimental

object KtBasicHtml {

    inline fun html(crossinline value: () -> String): String {
        return "<!doctype html>\n<html lang=\"en\">${value.invoke()}\n</html>"
    }

    inline fun a(href: String, crossinline value: () -> String) = element("a", "href=\"$href\"", value)
    inline fun body(crossinline value: () -> String) = elementln("body", value)
    inline fun code(crossinline value: () -> String) = element("code", value)
    inline fun em(crossinline value: () -> String) = element("em", value)
    inline fun div(crossinline value: () -> String) = element("div", value)
    inline fun footer(crossinline value: () -> String) = elementln("footer", value)
    inline fun h1(crossinline value: () -> String) = elementln("h1", value)
    inline fun h2(crossinline value: () -> String) = elementln("h2", value)
    inline fun h3(crossinline value: () -> String) = elementln("h3", value)
    inline fun h4(crossinline value: () -> String) = elementln("h4", value)
    inline fun h5(crossinline value: () -> String) = elementln("h5", value)
    inline fun h6(crossinline value: () -> String) = elementln("h6", value)
    inline fun head(crossinline value: () -> String) = elementln("head", value)
    inline fun header(crossinline value: () -> String) = elementln("header", value)
    inline fun li(crossinline value: () -> String) = elementln("li", value)
    inline fun menu(crossinline value: () -> String) = elementln("menu", value)
    inline fun menuitem(crossinline value: () -> String) = elementln("menuitem", value)
    inline fun nav(crossinline value: () -> String) = elementln("nav", value)
    inline fun ol(crossinline value: () -> String) = elementln("ol", value)
    inline fun p(crossinline value: () -> String) = elementln("p", value)
    inline fun q(crossinline value: () -> String) = element("q", value)
    inline fun section(crossinline value: () -> String) = elementln("section", value)
    inline fun small(crossinline value: () -> String) = element("small", value)
    inline fun textarea(crossinline value: () -> String) = element("textarea", value)
    inline fun title(crossinline value: () -> String) = elementln("title", value)
    inline fun u(crossinline value: () -> String) = element("u", value)
    inline fun ul(crossinline value: () -> String) = elementln("ul", value)

    fun br() = "<br />"
    fun hr() = "<hr />"
    fun link(rel: String, href: String) = """<link rel="$rel" href="$href" />"""
    fun meta(attr: String) = "<meta $attr />"
    fun img(src: String, alt: String) = """<img src="$src" alt="$alt" />"""
    fun input(type: String, name: String) = """<input type="$type" name="$name" />"""

    inline fun element(name: String, crossinline value: () -> String): String {
        return "<$name>${value.invoke()}</$name>"
    }

    inline fun elementln(name: String, crossinline value: () -> String): String {
        return "\n<$name>${value.invoke()}</$name>"
    }

    inline fun element(name: String, attr: String, crossinline value: () -> String): String {
        return "<$name $attr>${value.invoke()}</$name>"
    }

}
