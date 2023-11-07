import kotlin.system.exitProcess

class Helfer(pokemon: Dragoran) : Dragoran(
    name = "Helfer ${pokemon.name}",
    maxHp = (pokemon.maxHp * 0.5).toInt(),
    currentHp = (pokemon.currentHp * 0.5).toInt(),
    atk = pokemon.atk * 0.5,
    def = pokemon.def * 0.5,
    type1 = pokemon.type1,
    type2 = pokemon.type2
) {
    fun blizzard() {
        println("$name setzt Blizzard ein.")
        val damage = 120
        for (target in PLAYERTEAM) {
            var multiplier1 = 1.0
            var multiplier2 = 1.0
            when (target.type1) {
                "Pflanze" -> multiplier1 = 2.0
                "Flug" -> multiplier1 = 2.0
                "Boden" -> multiplier1 = 2.0
                "Drache" -> multiplier1 = 2.0
                "Feuer" -> multiplier1 = 0.5
                "Wasser" -> multiplier1 = 0.5
                "Eis" -> multiplier1 = 0.5
            }
            when (target.type2) {
                "Pflanze" -> multiplier2 = 2.0
                "Flug" -> multiplier2 = 2.0
                "Boden" -> multiplier2 = 2.0
                "Drache" -> multiplier2 = 2.0
                "Feuer" -> multiplier2 = 0.5
                "Wasser" -> multiplier2 = 0.5
                "Eis" -> multiplier2 = 0.5
            }
            val damageMultiplied = damage * multiplier1 * multiplier2
            val finalDamage = damageMultiplied * atk / target.def
            println("Der Angriff trifft ${target.name}.")
            if (damage < damageMultiplied)
                println("Das war sehr effektiv!")
            else if (damage > damageMultiplied)
                println("Das war nicht so effektiv.")
            target.currentHp -= finalDamage.toInt()
            target.displayHpBar()
        }
    }
    fun donnerwelle() {
        val target = PLAYERTEAM.random()
        println("$name greift ${target.name} mit Donnerwelle an.")
        if (checkStatus(target)) {
            target.paralyze = true
            println("${target.name} wurde paralysiert.")
        } else println("${target.name} kann nicht paralysiert werden.")
    }
    fun schlafrede() {
        val target = PLAYERTEAM.random()
        println("$name greift ${target.name} mit Schlafrede an.")
        if (checkStatus(target)) {
            target.sleep = true
            println("${target.name} schläft.")
        } else println("${target.name} kann nicht schlafen.")
    }
}
