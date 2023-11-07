class Trank(name: String = "Trank",anzahl: Int = 5): Items(name,anzahl) {
    override fun use() {
        val target = selectPlayerTeam()
        heal(target, 60)
        println("${target.name} wurde mit Trank geheilt.")
        target.displayHpBar()
    }
}