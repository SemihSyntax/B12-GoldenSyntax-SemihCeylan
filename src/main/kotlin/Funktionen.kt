fun selectEnemyTeam(): Pokemon {
    if (ENEMYTEAM.size == 1) {
        return ENEMYTEAM.first()
    } else {
        println("Welches Ziel möchtest du für deine Aktion auswählen?")
        var counter = 1
        for (i in ENEMYTEAM) {
            println("$counter -> ${i.name}")
            counter++
        }
        var input = readln().toInt()
        counter = 1
        while (input !in 1..ENEMYTEAM.size) {
            println("Leider ist deine Eingabe ungültig.")
            println("Welches Ziel möchtest du für deine Aktion auswählen?")
            for (i in ENEMYTEAM) {
                println("$counter -> ${i.name}")
                counter++
            }
            input = readln().toInt()
        }
        return ENEMYTEAM[input - 1]
    }
}

fun selectPlayerTeam(): Pokemon {
    println("Welches Ziel möchtest du für deine Aktion auswählen?")
    var counter = 1
    for (i in PLAYERTEAM) {
        println("$counter -> ${i.name}")
        counter++
    }
    var input = readln().toInt()
    counter = 1
    while (input !in 1..PLAYERTEAM.size) {
        println("Leider ist deine Eingabe ungültig.")
        println("Welches Ziel möchtest du für deine Aktion auswählen?")
        for (i in PLAYERTEAM) {
            val status = when {
                i.paralyze -> "⚡️[PAR]"
                i.sleep -> "💤[SLF]"
                i.poison -> "☠️[GIF]"
                else -> ""
            }
            println("$counter -> ${i.name} $status")
            counter++
        }
        input = readln().toInt()
    }
    return PLAYERTEAM[input - 1]
}

fun selectDeadPlayerTeam(): Pokemon {
    println("Welches Ziel möchtest du für deine Aktion auswählen?")
    var counter = 1
    for (i in DEADPLAYERTEAM) {
        println("$counter -> ${i.name}")
        counter++
    }
    var input = readln().toInt()
    counter = 1
    while (input !in 1..DEADPLAYERTEAM.size) {
        println("Leider ist deine Eingabe ungültig.")
        println("Welches Ziel möchtest du für deine Aktion auswählen?")
        for (i in DEADPLAYERTEAM) {
            println("$counter -> ${i.name}")
            counter++
        }
        input = readln().toInt()
    }
    return DEADPLAYERTEAM[input - 1]
}

fun dots() {
    repeat(3) {
        Thread.sleep(777)
        print(" .")
    }
    Thread.sleep(777)
}

fun heal(pokemon: Pokemon, amount: Int) {
    pokemon.currentHp += amount
    if (pokemon.currentHp > pokemon.maxHp)
        pokemon.currentHp = pokemon.maxHp
}

fun checkStatus(pokemon: Pokemon): Boolean {
    return if (pokemon.sleep || pokemon.poison || pokemon.paralyze) {
        print("${pokemon.name} hat bereits eine Statusveränderung. ")
        false
    } else true
}
fun resetPokemon(pokemon: Pokemon) {
    pokemon.sleep = false
    pokemon.paralyze = false
    pokemon.poison = false
    pokemon.confusion = false
}
//fun updateBeutel(spieler: Spieler){
//    for (item in spieler.beutel) {
//        if (item.anzahl == 0)
//            spieler.beutel.remove(item)
//    }
//}