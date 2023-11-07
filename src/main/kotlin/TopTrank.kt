class TopTrank(name: String = "Top-Trank",anzahl: Int = 1): Items(name,anzahl) {
    override fun use() {
        val target = selectPlayerTeam()
        target.currentHp = target.maxHp
        println("${target.name} wurde mit Top-Trank geheilt.")
        target.displayHpBar()
    }
}