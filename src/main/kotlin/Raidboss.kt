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
        val damage = 20
        for (target in PLAYERTEAM) {
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
                println("Der Angriff zeigt keine Wirkung bei ${target.name}.")
            } else {
                println("Der Angriff trifft ${target.name}.")
                if (damage < damageMultiplied)
                    println("Das war sehr effektiv!")
                else if (damage > damageMultiplied)
                    println("Das war nicht so effektiv.")
                target.currentHp -= finalDamage.toInt()
                target.displayHpBar()
            }
        }
    }
    fun toxin() {
        val target = PLAYERTEAM.random()
        println("$name greift ${target.name} mit Toxin an.")
        val accuracy = 80
        val randomizer = (1..100).random()
        if (randomizer <= accuracy) {
            println("${target.name} wurde vergiftet.")
            target.poison = true
        } else println("Der Angriff ging daneben.")
    }
    var apHelfer = 1
    fun helfer() {
        print("$name ruft einen Helfer")
        dots()
        val helfer = Helfer(Dragoran())
        ENEMYTEAM.add(helfer)
        println("${helfer.name} steht $name beim Kampf zur Seite.")
        apHelfer--
    }
}