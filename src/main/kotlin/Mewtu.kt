import kotlin.math.pow

open class Mewtu(
    name: String = "Mewtu",
    maxHp: Int = (750..1250).random(),
    currentHp: Int = maxHp,
    atk: Double = (8..12).random() / 10.0,
    def: Double = (8..12).random() / 10.0,
    type1: String = "Psycho",
    type2: String = ""
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {
    open fun konfusion(){
        val target = PLAYERTEAM.random()
        val damage = 40
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Kampf" -> multiplier1 = 2.0
            "Gift" -> multiplier1 = 2.0
            "Psycho" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Kampf" -> multiplier2 = 2.0
            "Gift" -> multiplier2 = 2.0
            "Psycho" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Konfusion an.")
        if (damage < damageMultiplied)
            println("Das war sehr effektiv!")
        else if (damage > damageMultiplied)
            println("Das war nicht so effektiv.")
        target.currentHp -= finalDamage.toInt()
        target.displayHpBar()
        val accuracy = 10
        val randomizer = (1..100).random()
        if (randomizer <= accuracy && !target.confusion) {
            target.confusion = true
            println("${target.name} wurde verwirrt.")
        }
    }
    fun psychokinese() {
        val target = PLAYERTEAM.random()
        val damage = 80
        val accuracy = 80
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Kampf" -> multiplier1 = 2.0
            "Gift" -> multiplier1 = 2.0
            "Psycho" -> multiplier1 = 0.5
        }
        when (target.type2) {
            "Kampf" -> multiplier2 = 2.0
            "Gift" -> multiplier2 = 2.0
            "Psycho" -> multiplier2 = 0.5
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Psychokinese an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        } else println("Deine Attacke ging daneben.")
    }
    fun genesung() {
        println("$name setzt Genesung ein und stellt einen Teil seiner HP wieder her.")
        heal(this, (maxHp*0.33).toInt())
        this.displayHpBar()
    }
    var rasereiCounter = 0
    fun raserei() {
        val target = PLAYERTEAM.random()
        val damage = 20 * (1.35.pow(rasereiCounter))
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
        println("$name greift ${target.name} mit Raserei an.")
        if (randomizer <= accuracy) {
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
            if (rasereiCounter < 6)
                rasereiCounter++
        } else println("Deine Attacke ging daneben.")
    }
}