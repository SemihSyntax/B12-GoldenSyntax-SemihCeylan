import kotlin.math.pow

open class Mewtu(
    name: String = "Mewtu",
    maxHp: Int = (300..500).random(),
    currentHp: Int = maxHp,
    atk: Double = (10..12).random() / 10.0,
    def: Double = (8..10).random() / 10.0,
    type1: String = "Psycho",
    type2: String = ""
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {
    open fun konfusion(){
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
//        val accuracy = 10
//        val randomizer = (1..100).random()
//        if (randomizer <= accuracy && !target.confusion) {
//            target.confusion = true
//            println("${target.name} wurde verwirrt.")
//        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }
    fun psychokinese() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
    fun genesung() {
        println("$name setzt Genesung ein und stellt einen Teil seiner HP wieder her.")
        Thread.sleep(1000)
        heal(this, (maxHp*0.1).toInt())
        this.displayHpBar()
        Thread.sleep(1000)
    }
    private var rasereiCounter = 0
    fun raserei() {
        val target = PLAYERTEAM.filter { it.currentHp > 0 }.random()
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
            if (rasereiCounter < 6)
                rasereiCounter++
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