package experimental

import kotlinx.browser.document
import org.w3c.dom.Document
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLImageElement

fun Document.div(id: String): HTMLDivElement = document.getElementById(id) as HTMLDivElement
fun Document.img(id: String): HTMLImageElement = document.getElementById(id) as HTMLImageElement
