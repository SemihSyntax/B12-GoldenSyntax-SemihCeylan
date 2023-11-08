class Gegengift(name: String = "Gegengift", anzahl: Int = 1): Items(name,anzahl) {
    override fun use() {
        val target = selectPlayerTeam()
        target.poison = false
        println("${target.name} wurde mit Gegengift geheilt.")
        Thread.sleep(1000)
    }
}