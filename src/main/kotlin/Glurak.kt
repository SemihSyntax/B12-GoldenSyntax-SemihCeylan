import kotlin.math.pow

open class Glurak(
    name: String = "Glurak",
    maxHp: Int = (750..1250).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..12).random() / 10.0,
    def: Double = (8..12).random() / 10.0,
    poison: Boolean = false,
    paralyzed: Boolean = false,
    sleep: Boolean = false,
    type1: String = "Feuer",
    type2: String = "Flug"
) : Pokemon(name, maxHp, currentHp, atk, def, poison, paralyzed, sleep, type1, type2) {
    fun glut() {
        val target = selectEnemyTeam()
        val damage = 40.0
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Pflanze" -> multiplier1 = 2.0
            "Käfer" -> multiplier1 = 2.0
            "Eis" -> multiplier1 = 2.0
            "Feuer" -> multiplier1 = 0.5
            "Wasser" -> multiplier1 = 0.5
            "Gestein" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Pflanze" -> multiplier2 = 2.0
            "Käfer" -> multiplier2 = 2.0
            "Eis" -> multiplier2 = 2.0
            "Feuer" -> multiplier2 = 0.5
            "Wasser" -> multiplier2 = 0.5
            "Gestein" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk * target.def
        println("$name greift ${target.name} mit Glut an.")
        if (damage > damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage < damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
    }

    fun flammenwurf() {
        val target = selectEnemyTeam()
        val damage = 80.0
        val accuracy = 70
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Pflanze" -> multiplier1 = 2.0
            "Käfer" -> multiplier1 = 2.0
            "Eis" -> multiplier1 = 2.0
            "Feuer" -> multiplier1 = 0.5
            "Wasser" -> multiplier1 = 0.5
            "Gestein" -> multiplier1 = 0.5
            "Drache" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Pflanze" -> multiplier2 = 2.0
            "Käfer" -> multiplier2 = 2.0
            "Eis" -> multiplier2 = 2.0
            "Feuer" -> multiplier2 = 0.5
            "Wasser" -> multiplier2 = 0.5
            "Gestein" -> multiplier2 = 0.5
            "Drache" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk * target.def
        val randomizer = (1..100).random()
        if (randomizer <= accuracy) {
            println("$name greift ${target.name} mit Flammenwurf an.")
            if (damage > damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage < damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }

    private var rasereiCounter = 0
    fun raserei() {
        val target = selectEnemyTeam()
        val damage = 20.0 * (1.35.pow(rasereiCounter))
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
        val finalDamage = damageMultiplied * atk * target.def
        val randomizer = (1..100).random()
        if (randomizer <= accuracy) {
            println("$name greift ${target.name} mit Raserei an.")
            if (damage > damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage < damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
            if (rasereiCounter < 6)
                rasereiCounter++
        } else println("Deine Attacke ging daneben.")
    }

    fun heuler() {
        val target = selectEnemyTeam()
        print("$name setzt Heuler bei ${target.name} ein.")
        dots()
        println("${target.name}'s Wert ist gesunken!")
        target.atk *= 0.9
    }

}