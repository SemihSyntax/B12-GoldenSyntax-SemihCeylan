class Helfer(pokemon: Dragoran) : Dragoran(
    name = "Helfer ${pokemon.name}",
    maxHp = (pokemon.maxHp * 0.8).toInt(),
    currentHp = (pokemon.currentHp * 0.8).toInt(),
    atk = pokemon.atk * 0.8,
    def = pokemon.def * 0.8,
    type1 = pokemon.type1,
    type2 = pokemon.type2
) {
    fun blizzard() {
        println("$name setzt Blizzard ein.")
        Thread.sleep(1000)
        val damage = 120
        val playerTeam = PLAYERTEAM.filter { it.currentHp > 0 }
        for (target in playerTeam) {
            var multiplier1 = 1.0
            var multiplier2 = 1.0
            when (target.type1) {
                "Pflanze" -> multiplier1 = 2.0
                "Flug" -> multiplier1 = 2.0
                "Boden" -> multiplier1 = 2.0
                "Drache" -> multiplier1 = 2.0
                "Feuer" -> multiplier1 = 0.5
                "Wasser" -> multiplier1 = 0.5
                "Eis" -> multiplier1 = 0.5
            }
            when (target.type2) {
                "Pflanze" -> multiplier2 = 2.0
                "Flug" -> multiplier2 = 2.0
                "Boden" -> multiplier2 = 2.0
                "Drache" -> multiplier2 = 2.0
                "Feuer" -> multiplier2 = 0.5
                "Wasser" -> multiplier2 = 0.5
                "Eis" -> multiplier2 = 0.5
            }
            val damageMultiplied = damage * multiplier1 * multiplier2
            val finalDamage = damageMultiplied * atk / target.def
            println("Die Attacke trifft ${target.name}.")
            Thread.sleep(1000)
            if (damage < damageMultiplied) {
                println("Das war sehr effektiv!")
                Thread.sleep(1000)
            }
            else if (damage > damageMultiplied) {
                println("Das war nicht so effektiv.")
                Thread.sleep(1000)
            }
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
            Thread.sleep(1000)
            if (target.currentHp < 1) {
                println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
                Thread.sleep(1000)
            }
        }
    }
//    fun donnerwelle() {
//        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
//        println("$name greift ${target.name} mit Donnerwelle an.")
//        if (checkStatus(target)) {
//            target.paralyze = true
//            println("${target.name} wurde paralysiert.")
//        } else println("Es kann nicht paralysiert werden.")
//    }
//    fun schlafrede() {
//        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
//        println("$name greift ${target.name} mit Schlafrede an.")
//        if (checkStatus(target)) {
//            target.sleep = true
//            println("${target.name} schläft.")
//        } else println("Es kann nicht schlafen.")
//    }
}
