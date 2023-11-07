class Bisaflor(
    name: String = "Bisaflor",
    maxHp: Int = (750..1250).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..12).random() / 10.0,
    def: Double = (8..12).random() / 10.0,
    type1: String = "Pflanze",
    type2: String = "Gift"
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {
    fun rankenhieb() {
        val target = selectEnemyTeam()
        val damage = 40
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Wasser" -> multiplier1 = 2.0
            "Boden" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Planze" -> multiplier1 = 0.5
            "Feuer" -> multiplier1 = 0.5
            "Flug" -> multiplier1 = 0.5
            "Gift" -> multiplier1 = 0.5
            "Käfer" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Wasser" -> multiplier2 = 2.0
            "Boden" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Planze" -> multiplier2 = 0.5
            "Feuer" -> multiplier2 = 0.5
            "Flug" -> multiplier2 = 0.5
            "Gift" -> multiplier2 = 0.5
            "Käfer" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Rankenhieb an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
    }

    fun gigasauger() {
        val target = selectEnemyTeam()
        val damage = 60
        val accuracy = 90
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Wasser" -> multiplier1 = 2.0
            "Boden" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Planze" -> multiplier1 = 0.5
            "Feuer" -> multiplier1 = 0.5
            "Flug" -> multiplier1 = 0.5
            "Gift" -> multiplier1 = 0.5
            "Käfer" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Wasser" -> multiplier2 = 2.0
            "Boden" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Planze" -> multiplier2 = 0.5
            "Feuer" -> multiplier2 = 0.5
            "Flug" -> multiplier2 = 0.5
            "Gift" -> multiplier2 = 0.5
            "Käfer" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Gigasauger an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
            println("$name regeniert seine HP mit einem Teil des veursachten Schadens.")
            heal(this, (finalDamage / 2).toInt())
            this.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }

    fun reflektor() {
        print("$name setzt Reflektor ein.")
        for (i in PLAYERTEAM)
            i.def *= 1.1
        dots()
        println("Der DEF-Wert deines Teams wurde um 10% erhöht!")
    }

    fun matschbombe() {
        val target = selectEnemyTeam()
        val damage = 30
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Pflanze" -> multiplier1 = 2.0
            "Gift" -> multiplier1 = 0.5
            "Boden" -> multiplier1 = 0.5
            "Gestein" -> multiplier1 = 0.5
            "Geist" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Pflanze" -> multiplier2 = 2.0
            "Gift" -> multiplier2 = 0.5
            "Boden" -> multiplier2 = 0.5
            "Gestein" -> multiplier2 = 0.5
            "Geist" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Matschbombe an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        if (checkStatus(target)) {
            val accuracy = 30
            val randomizer = (1..100).random()
            if (randomizer <= accuracy) {
                target.poison = true
                println("${target.name} wurde vergiftet.")
            }
        } else println("Es kann nicht vergiftet werden.")
        target.displayHpBar()
    }
}