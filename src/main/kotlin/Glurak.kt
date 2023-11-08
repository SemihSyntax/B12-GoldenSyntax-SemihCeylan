open class Glurak(
    name: String = "Glurak",
    maxHp: Int = (300..500).random(),
    currentHp: Int = maxHp,
    atk: Double = (10..12).random() / 10.0,
    def: Double = (8..10).random() / 10.0,
    type1: String = "Feuer",
    type2: String = "Flug"
) : Pokemon(name, maxHp, currentHp, atk, def, type1, type2) {
    fun glut() {
        val target = selectEnemyTeam()
        val damage = 40
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
        val finalDamage = damageMultiplied * atk / target.def
        println("$name greift ${target.name} mit Glut an.")
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

    fun flammenwurf() {
        val target = selectEnemyTeam()
        val damage = 80
        val accuracy = 80
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
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Flammenwurf an.")
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
            println("Deine Attacke ging daneben.")
            Thread.sleep(1000)
        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }

    fun geowurf() {
        val target = selectEnemyTeam()
        val damage = (40..120).random()
        val accuracy = 80
        var multiplier1 = 1.0
        var multiplier2 = 1.0
        when (target.type1) {
            "Normal" -> multiplier1 = 2.0
            "Gestein" -> multiplier1 = 2.0
            "Eis" -> multiplier1 = 2.0
            "Flug" -> multiplier1 = 0.5
            "Gift" -> multiplier1 = 0.5
            "Käfer" -> multiplier1 = 0.5
            "Psycho" -> multiplier1 = 0.5
            "Geist" -> multiplier1 = 0.0
        }
        when (target.type2) {
            "Normal" -> multiplier2 = 2.0
            "Gestein" -> multiplier2 = 2.0
            "Eis" -> multiplier2 = 2.0
            "Flug" -> multiplier2 = 0.5
            "Gift" -> multiplier2 = 0.5
            "Käfer" -> multiplier2 = 0.5
            "Psycho" -> multiplier2 = 0.5
            "Geist" -> multiplier2 = 0.0
        }
        val damageMultiplied = damage * multiplier1 * multiplier2
        val finalDamage = damageMultiplied * atk / target.def
        val randomizer = (1..100).random()
        println("$name greift ${target.name} mit Geowurf an.")
        Thread.sleep(1000)
        if (damageMultiplied < 1){
            println("Der Angriff zeigt keine Wirkung bei ${target.name}.")
            Thread.sleep(1000)
        } else {
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
                println("Deine Attacke ging daneben.")
                Thread.sleep(1000)
            }
        }
        if (target.currentHp < 1) {
            println("${target.name}'s HP sind auf 0 gefallen. ${target.name} ist kampfunfähig!")
            Thread.sleep(1000)
        }
    }

    fun heuler() {
        val target = selectEnemyTeam()
        print("$name setzt Heuler bei ${target.name} ein")
        dots()
        println("${target.name}'s ATK-Wert ist gesunken!")
        Thread.sleep(1000)
        target.atk *= 0.9
    }

}