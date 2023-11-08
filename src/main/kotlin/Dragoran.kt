open class Dragoran(
    name: String = "Dragoran",
    maxHp: Int = (300..500).random(),
    currentHp: Int = maxHp,
    atk: Double = (9..11).random() / 10.0,
    def: Double = (9..11).random() / 10.0,
    type1: String = "Drache",
    type2: String = "Flug"
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {

    fun windhose() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
    fun wutanfall() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
        val damage = 80
        val accuracy = 80
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
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Wutanfall an.")
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
        } else {
            println("Die Attacke ging daneben.")
            Thread.sleep(1000)
        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }
    fun fluegelschlag() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
    fun felsgrab() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
        } else {
            println("Die Attacke ging daneben.")
            Thread.sleep(1000)
        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }
}