class Turtok(
    name: String = "Turtok",
    maxHp: Int = (750..1250).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..12).random() / 10.0,
    def: Double = (8..12).random() / 10.0,
    type1: String = "Wasser",
    type2: String = ""
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {
    fun blubber() {
        val target = selectEnemyTeam()
        val damage = 40
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Feuer" -> multiplier1 = 2.0
            "Boden" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Pflanze" -> multiplier1 = 0.5
            "Wasser" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Feuer" -> multiplier2 = 2.0
            "Boden" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Pflanze" -> multiplier2 = 0.5
            "Wasser" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Blubber an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
    }
    fun aquaknarre() {
        val target = selectEnemyTeam()
        val damage = 80
        val accuracy = 80
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Feuer" -> multiplier1 = 2.0
            "Boden" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Pflanze" -> multiplier1 = 0.5
            "Wasser" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Feuer" -> multiplier2 = 2.0
            "Boden" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Pflanze" -> multiplier2 = 0.5
            "Wasser" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Aquaknarre an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }
    fun hydropumpe() {
        val target = selectEnemyTeam()
        val damage = 120
        val accuracy = 60
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Feuer" -> multiplier1 = 2.0
            "Boden" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Pflanze" -> multiplier1 = 0.5
            "Wasser" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Feuer" -> multiplier2 = 2.0
            "Boden" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Pflanze" -> multiplier2 = 0.5
            "Wasser" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Hydropumpe an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }
    fun bodycheck() {
        val target = selectEnemyTeam()
        val damage = 150
        val accuracy = 90
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Gestein" -> multiplier1 = 0.5
            "Geist" -> multiplier1 = 0.0
        }
        when (target.type2) {
            "Gestein" -> multiplier2 = 0.5
            "Geist" -> multiplier2 = 0.0
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Bodycheck an.")
        if (damageMultiplied < 1){
            println("Der Angriff zeigt keine Wirkung bei ${target.name}.")
        } else {
            if (randomizer <= accuracy) {
                if (damage < damageMultiplied)
                    println("Das war sehr effektiv!")
                else if (damage > damageMultiplied)
                    println("Das war nicht so effektiv.")
                target.currentHp -= finalDamage.toInt()
                target.displayHpBar()
                dots()
                println("$name erleidet Schaden durch den Rückstöß.")
                this.currentHp -= (finalDamage/4).toInt()
                this.displayHpBar()
            } else println("Deine Attacke ging daneben.")
        }
    }
}