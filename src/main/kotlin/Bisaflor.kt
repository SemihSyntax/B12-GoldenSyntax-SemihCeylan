class Bisaflor(
    name: String = "Bisaflor",
    maxHp: Int = (300..500).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..10).random() / 10.0,
    def: Double = (10..12).random() / 10.0,
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
        Thread.sleep(1000)
        if (randomizer <= accuracy) {
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
            println("$name regeniert seine HP mit einem Teil des veursachten Schadens.")
            Thread.sleep(1000)
            heal(this, (finalDamage / 2).toInt())
            this.displayHpBar()
            Thread.sleep(1000)
        } else {
            println("Deine Attacke ging daneben.")
            Thread.sleep(1000)
        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }

    fun reflektor() {
        print("$name setzt Reflektor ein")
        for (i in PLAYERTEAM)
            i.def *= 1.1
        dots()
        println("Der DEF-Wert deines Teams wurde um 10% erhöht!")
        Thread.sleep(1000)
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
        if (checkStatus(target)) {
            val accuracy = 30
            val randomizer = (1..100).random()
            if (randomizer <= accuracy) {
                target.poison = true
                println("${target.name} wurde vergiftet.")
                Thread.sleep(1000)
            }
        } else {
            println("Es kann nicht vergiftet werden.")
            Thread.sleep(1000)
        }
        target.displayHpBar()
        Thread.sleep(1000)
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }
}