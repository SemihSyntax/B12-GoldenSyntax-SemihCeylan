open class Items(var name: String, var anzahl: Int) {
    override fun toString(): String {
        return "$name: ${anzahl}x"
    }
    open fun use() {
        println("Fehler")
    }
}