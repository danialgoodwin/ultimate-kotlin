package dev.goodwin.experimental

class KtHtml(private inline val htmlContent: KtHtml.() -> Unit) {

    private val elements = mutableListOf<KtHttpElement>()

    fun body(content: KtHttpElement.() -> Unit) { elements.add(KtHttpElement.bln("body", content)) }
    fun head(content: KtHttpElement.() -> Unit) { elements.add(KtHttpElement.bln("head", content)) }

    fun build(): String {
        htmlContent.invoke(this)
        return "<!doctype html>" +
                "\n<html>${elements.joinToString("") { it.toHtml() }}\n</html>"
    }

    class KtHttpElement {
        private val name: String
        private val stringContent: String?
        private val elements: MutableList<KtHttpElement> = mutableListOf()
        private val elementContent: (KtHttpElement.() -> Unit)?
        private val newlineMode: NewlineMode

        constructor(name: String, elementContent: KtHttpElement.() -> Unit, isNewLine: NewlineMode = NewlineMode.NONE) {
            this.name = name
            this.stringContent = null
            this.elementContent = elementContent
            this.newlineMode = isNewLine
        }

        constructor(name: String, content: String = "", isNewLine: NewlineMode = NewlineMode.NONE) {
            this.name = name
            this.stringContent = content
            this.elementContent = null
            this.newlineMode = isNewLine
        }

        fun menu(content: KtHttpElement.() -> Unit) { elements.add(KtHttpElement.bln("menu", content)) }
        fun menuItem(name: String, onClick: () -> Unit) { elements.add(KtHttpElement.sln("menuitem", name)) }

        fun h1(content: () -> String) { elements.add(KtHttpElement.sln("h1", content.invoke())) }
        fun h2(content: () -> String) { elements.add(KtHttpElement.sln("h2", content.invoke())) }
        fun h3(content: () -> String) { elements.add(KtHttpElement.sln("h3", content.invoke())) }
        fun p(content: () -> String) { elements.add(KtHttpElement.sln("p", content.invoke())) }
        fun title(content: String) { elements.add(KtHttpElement.sln("title", content)) }

        fun toHtml(): String {
            elementContent?.invoke(this)
            val ln1 = if (newlineMode == NewlineMode.SINGLE || newlineMode == NewlineMode.BOTH) "\n" else ""
            val ln2 = if (newlineMode == NewlineMode.BOTH) "\n" else ""
            return if (stringContent == null) {
                "$ln1<$name>${elements.joinToString("") { it.toHtml() }}$ln2</$name>"
            } else {
                "$ln1<$name>$stringContent$ln2</$name>"
            }
        }

        companion object {
            fun sln(name: String, content: KtHttpElement.() -> Unit) = KtHttpElement(name, content, NewlineMode.SINGLE)
            fun sln(name: String, content: String = "") = KtHttpElement(name, content, NewlineMode.SINGLE)
            fun bln(name: String, content: KtHttpElement.() -> Unit) = KtHttpElement(name, content, NewlineMode.BOTH)
            fun bln(name: String, content: String = "") = KtHttpElement(name, content, NewlineMode.BOTH)
        }

    }

    enum class NewlineMode {
        NONE, SINGLE, BOTH
    }

}
