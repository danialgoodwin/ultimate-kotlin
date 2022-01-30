package experimental

import org.w3c.dom.HTMLElement

fun HTMLElement.hide() { this.style.display = "none" }
fun HTMLElement.invisible() { this.style.visibility = "hidden" }
fun HTMLElement.show() { this.style.visibility = "visible" }

inline fun HTMLElement.onClick(crossinline listener: () -> Unit) {
    this.addEventListener("click", { listener.invoke() })
}
