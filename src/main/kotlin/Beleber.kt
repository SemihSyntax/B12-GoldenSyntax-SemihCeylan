class Beleber(name: String = "Beleber", anzahl: Int = 1): Items(name,anzahl) {
    override fun use() {
        val target = selectDeadPlayerTeam()
        target.currentHp = (target.maxHp*0.2).toInt()
        resetPokemon(target)
        PLAYERTEAM.add(target)
        DEADPLAYERTEAM.remove(target)
        println("${target.name} wurde mit einem Teil seiner HP wiederbelebt.")
    }
}