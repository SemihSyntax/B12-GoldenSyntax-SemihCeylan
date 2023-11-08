class Raidboss(pokemon: Mewtu) : Mewtu(
    name = "Raid-Boss ${pokemon.name}",
    maxHp = pokemon.maxHp * 2,
    currentHp = pokemon.currentHp * 2,
    atk = pokemon.atk * 2,
    def = pokemon.def * 2,
    type1 = pokemon.type1,
    type2 = pokemon.type2
) {
    fun erdbeben() {
        println("$name setzt Erdbeben ein.")
        Thread.sleep(1000)
        val damage = 20
        val playerTeam = PLAYERTEAM.filter { it.currentHp > 0 }
        for (target in playerTeam) {
            var multiplier1 = 1.0
            var multiplier2 = 1.0
            when (target.type1) {
                "Feuer" -> multiplier1 = 2.0
                "Elektro" -> multiplier1 = 2.0
                "Gift" -> multiplier1 = 2.0
                "Gestein" -> multiplier1 = 2.0
                "Pflanze" -> multiplier1 = 0.5
                "Käfer" -> multiplier1 = 0.5
                "Flug" -> multiplier1 = 0.0
            }
            when (target.type2) {
                "Feuer" -> multiplier2 = 2.0
                "Elektro" -> multiplier2 = 2.0
                "Gift" -> multiplier2 = 2.0
                "Gestein" -> multiplier2 = 2.0
                "Pflanze" -> multiplier2 = 0.5
                "Käfer" -> multiplier2 = 0.5
                "Flug" -> multiplier2 = 0.0
            }
            val damageMultiplied = damage * multiplier1 * multiplier2
            val finalDamage = damageMultiplied * atk / target.def
            if (damageMultiplied < 1){
                println("Die Attacke zeigt keine Wirkung bei ${target.name}.")
                Thread.sleep(1000)
            } else {
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
    }
    fun toxin() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
        println("$name greift ${target.name} mit Toxin an.")
        Thread.sleep(1000)
        if (checkStatus(target)) {
            val accuracy = 80
            val randomizer = (1..100).random()
            if (randomizer <= accuracy) {
                println("${target.name} wurde vergiftet.")
                Thread.sleep(1000)
                target.poison = true
            } else {
                println("Die Attacke ging daneben.")
                Thread.sleep(1000)
            }
        } else {
            println("Es kann nicht vergiftet werden.")
            Thread.sleep(1000)
        }
    }
    var apHelfer = 1
    fun helfer() {
        print("$name ruft einen Helfer")
        dots()
        val helfer = Helfer(Dragoran())
        ENEMYTEAM.add(helfer)
        println("${helfer.name} steht $name beim Kampf zur Seite.")
        Thread.sleep(1000)
        apHelfer--
    }
}