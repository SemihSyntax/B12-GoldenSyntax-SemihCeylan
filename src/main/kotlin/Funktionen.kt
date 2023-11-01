//fun selectTarget(team: MutableList<Pokemon>): Pokemon {
//    if (team.size == 1) {
//        return team.first()
//    } else {
//        println("Welches Ziel möchtest du für deine Aktion auswählen?")
//        var counter = 1
//        for (i in team) {
//            println("$counter -> ${i.name}")
//            counter++
//        }
//        var input = readln().toInt()
//        counter = 1
//        while (input !in 1..team.size) {
//            println("Leider ist deine Eingabe ungültig.")
//            println("Welches Ziel möchtest du für deine Aktion auswählen?")
//            for (i in team) {
//                println("$counter -> ${i.name}")
//                counter++
//            }
//            input = readln().toInt()
//        }
//        return team[input-1]
//    }
//}
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
        return ENEMYTEAM[input-1]
    }
}
fun dots() {
    repeat(3) {
        Thread.sleep(333)
        print(".")
    }
}
fun heal(pokemon: Pokemon, amount: Int){
    pokemon.currentHp += amount
    if (pokemon.currentHp > pokemon.maxHp)
        pokemon.currentHp = pokemon.maxHp
}