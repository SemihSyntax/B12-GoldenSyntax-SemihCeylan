class Paraheiler(name: String = "Para-Heiler", anzahl: Int = 1): Items(name,anzahl) {
    override fun use() {
        val target = selectPlayerTeam()
        target.paralyze = false
        println("${target.name} wurde mit Para-Heiler geheilt.")
    }
}