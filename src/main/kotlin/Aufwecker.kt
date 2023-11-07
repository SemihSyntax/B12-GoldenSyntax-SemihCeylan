class Aufwecker(name: String = "Aufwecker", anzahl: Int = 1): Items(name,anzahl) {
    override fun use() {
        val target = selectPlayerTeam()
        target.sleep = false
        println("${target.name} wurde mit Aufwecker geheilt.")
    }
}