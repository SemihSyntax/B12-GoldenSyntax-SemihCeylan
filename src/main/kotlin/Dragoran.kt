open class Dragoran(
    name: String = "Dragoran",
    maxHp: Int = (750..1250).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..12).random() / 10.0,
    def: Double = (8..12).random() / 10.0,
    type1: String = "Drache",
    type2: String = "Flug"
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {

    fun windhose() {
        val target = PLAYERTEAM.random()
        val damage = 40
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Drache" -> multiplier1 = 2.0
        }
        when (target.type2) {
            "Drache" -> multiplier2 = 2.0
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Windhose an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
    }
    fun wutanfall() {
        val target = PLAYERTEAM.random()
        val damage = 80
        val accuracy = 80
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Drache" -> multiplier1 = 2.0
        }
        when (target.type2) {
            "Kampf" -> multiplier2 = 2.0
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Wutanfall an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }
    fun flügelschlag() {
        val target = PLAYERTEAM.random()
        val damage = 40
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Pflanze" -> multiplier1 = 2.0
            "Kampf" -> multiplier1 = 2.0
            "Käfer" -> multiplier1 = 2.0
            "Elektro" -> multiplier1 = 0.5
            "Gestein" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Pflanze" -> multiplier2 = 2.0
            "Kampf" -> multiplier2 = 2.0
            "Käfer" -> multiplier2 = 2.0
            "Elektro" -> multiplier2 = 0.5
            "Gestein" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Flügelschlag an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
    }
    fun felsgrab() {
        val target = selectEnemyTeam()
        val damage = 80
        val accuracy = 80
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Feuer" -> multiplier1 = 2.0
            "Flug" -> multiplier1 = 2.0
            "Käfer" -> multiplier1 = 2.0
            "Eis" -> multiplier1 = 2.0
            "Kampf" -> multiplier1 = 0.5
            "Boden" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Feuer" -> multiplier2 = 2.0
            "Flug" -> multiplier2 = 2.0
            "Käfer" -> multiplier2 = 2.0
            "Eis" -> multiplier2 = 2.0
            "Kampf" -> multiplier2 = 0.5
            "Boden" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Felsgrab an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }

}