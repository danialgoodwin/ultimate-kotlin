package dev.goodwin.experimental

interface KtViews {

    fun col(items: List<String>)
    fun grid(items: List<List<String>>)
    fun row(items: List<String>)

    fun image(src: String, alt: String)
    fun text(content: String)

    fun intInput(label: String, min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE, defaultValue: String?)
    fun numberInput(label: String, min: Double = Double.MIN_VALUE, max: Double = Double.MAX_VALUE, defaultValue: String?)
    fun optionsInput(label: String, options: List<String>, isMultiSelect: Boolean = false, defaultValue: String?)
    fun textInput(label: String, defaultValue: String?)

    fun prompt(title: String, message: String, primaryAction: String, secondaryAction: String)
    fun promptOkay(title: String, message: String)
    fun promptOkayCancel(title: String, message: String)
    fun promptYesNo(title: String, message: String)

}
