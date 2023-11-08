fun selectEnemyTeam(): Pokemon {
    val enemyTeam = ENEMYTEAM.filter { it.currentHp > 0 }
    if (enemyTeam.size == 1) {
        return enemyTeam.first()
    } else {
        println("Welches Ziel möchtest du für deine Aktion auswählen?")
        var counter = 1
        for (i in enemyTeam) {
            println("$counter -> ${i.name}")
            counter++
        }
        var input = readln().toInt()
        counter = 1
        while (input !in 1..enemyTeam.size) {
            println("Leider ist deine Eingabe ungültig.")
            println("Welches Ziel möchtest du für deine Aktion auswählen?")
            for (i in enemyTeam) {
                println("$counter -> ${i.name}")
                counter++
            }
            input = readln().toInt()
        }
        return enemyTeam[input - 1]
    }
}

fun selectPlayerTeam(): Pokemon {
    val playerTeam = PLAYERTEAM.filter { it.currentHp > 0 }
    println("Welches Ziel möchtest du für deine Aktion auswählen?")
    var counter = 1
    for (i in playerTeam) {
        println("$counter -> ${i.name}:")
        i.displayHpBar()
        counter++
    }
    var input = readln().toInt()
    counter = 1
    while (input !in 1..playerTeam.size) {
        println("Leider ist deine Eingabe ungültig.")
        println("Welches Ziel möchtest du für deine Aktion auswählen?")
        for (i in playerTeam) {
            println("$counter -> ${i.name}:")
            i.displayHpBar()
            counter++
        }
        input = readln().toInt()
    }
    return playerTeam[input - 1]
}

//fun selectDeadPlayerTeam(): Pokemon {
//    println("Welches Ziel möchtest du für deine Aktion auswählen?")
//    var counter = 1
//    for (i in DEADPLAYERTEAM) {
//        println("$counter -> ${i.name}")
//        counter++
//    }
//    var input = readln().toInt()
//    counter = 1
//    while (input !in 1..DEADPLAYERTEAM.size) {
//        println("Leider ist deine Eingabe ungültig.")
//        println("Welches Ziel möchtest du für deine Aktion auswählen?")
//        for (i in DEADPLAYERTEAM) {
//            println("$counter -> ${i.name}")
//            counter++
//        }
//        input = readln().toInt()
//    }
//    return DEADPLAYERTEAM[input - 1]
//}

fun dots() {
    repeat(3) {
        Thread.sleep(777)
        print(" . ")
    }
    Thread.sleep(777)
}

fun heal(pokemon: Pokemon, amount: Int) {
    pokemon.currentHp += amount
    if (pokemon.currentHp > pokemon.maxHp)
        pokemon.currentHp = pokemon.maxHp
}

fun checkStatus(pokemon: Pokemon): Boolean {
    return if (/*pokemon.sleep || || pokemon.paralyze */pokemon.poison) {
        print("${pokemon.name} hat bereits eine Statusveränderung. ")
        false
    } else true
}
//fun resetPokemon(pokemon: Pokemon) {
//    pokemon.sleep = false
//    pokemon.paralyze = false
//    pokemon.poison = false
//    pokemon.confusion = false
//}
//fun updateBeutel(spieler: Spieler){
//    for (item in spieler.beutel) {
//        if (item.anzahl == 0)
//            spieler.beutel.remove(item)
//    }
//}
//fun checkEnemyTeam() {
//    for (i in ENEMYTEAM) {
//        if (i.currentHp < 1) {
//            println("${i.name}'s HP sind auf 0 gefallen. ${i.name} ist kampfunfähig!")
//        }
//    }
//}
//fun checkPlayerTeam() {
//    for (i in PLAYERTEAM) {
//        if (i.currentHp < 1) {
//            println("${i.name}'s HP sind auf 0 gefallen. ${i.name} ist kampfunfähig!")
//        }
//    }
//}
//fun checkTeams() {
//    checkPlayerTeam()
//    checkEnemyTeam()
//}
fun checkGame(player: Spieler): Boolean {
    if (PLAYERTEAM.none { it.currentHp > 0 } || ENEMYTEAM.none { it.currentHp > 0 }) {
        return if (PLAYERTEAM.none { it.currentHp > 0 }) {
            print("Deine Pokemon sind kampfunfähig. ${player.name} fällt in Ohnmacht")
            dots()
            print("Game Over")
            true
        } else {
            println("${player.name} hat gewonnen. Mach weiter so! Vielleicht wirst du bald der Champion!")
            true
        }
    }
    return false
}
fun startgame() {
    println("Willkommen bei dem Golden Syntax RPG - Pokemon Edition. Wie heißt du?")
    val input = readln()
    val player = Spieler(input)
    println("Hiermit beginnt deine Reise:")
    Thread.sleep(1000)
    player.infoTeam()
    Thread.sleep(1000)
    player.infoBeutel()
    Thread.sleep(3000)
    println("Dann lass uns loslegen ${player.name}!")
    Thread.sleep(1500)
    print("${player.name} geht in die Azuria-Höhle")
    dots()
    println("ein wildes Mewto erscheint!")
    Thread.sleep(1500)
    for (i in player.team)
        PLAYERTEAM.add(i)
    ENEMYTEAM.add(Raidboss(Mewtu()))
    println("Der Kampf beginnt!")
    Thread.sleep(1000)
    println("Dein Team:")
    Thread.sleep(1000)
    for (i in PLAYERTEAM) {
        i.displayHpBar()
        Thread.sleep(1000)
    }
    println("Dein Gegner:")
    Thread.sleep(1000)
    for (i in ENEMYTEAM) {
        i.displayHpBar()
        Thread.sleep(1000)
    }
    while (true) {
        val listGlurak = PLAYERTEAM.filterIsInstance<Glurak>()
        if (listGlurak.isNotEmpty() && listGlurak.first().currentHp > 0) {
            val i = listGlurak.first()
            println(
                """
                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
                            1 -> Attacken
                            2 -> Beutel
                        """.trimIndent()
            )
            var inputInt = readln().toInt()
            while (inputInt !in 1..2) {
                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                inputInt = readln().toInt()
            }
            if (inputInt == 1) {
                println(
                    """
                                Welche Attacke möchtest du auswählen?
                                1 -> Glut [SCH 40 / GEN 100]
                                2 -> Flammenwurf [SCH 80 / GEN 80]
                                3 -> Geowurf [SCH 40-120 / GEN 80]
                                4 -> Heuler [ATK reduzieren]
                            """.trimIndent()
                )
                inputInt = readln().toInt()
                while (inputInt !in 1..4) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                when (inputInt) {
                    1 -> i.glut()
                    2 -> i.flammenwurf()
                    3 -> i.geowurf()
                    4 -> i.heuler()
                }

            } else {
                println("Was möchtest du aus deinem Beutel benutzen?")
                var counterItems = 1
                for (item in player.beutel) {
                    println("$counterItems -> $item")
                    counterItems++
                }
                inputInt = readln().toInt()
                while (inputInt !in 1..player.beutel.size) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                val targetItem = player.beutel[inputInt - 1]
                targetItem.use()
                targetItem.anzahl -= 1
                if (targetItem.anzahl == 0)
                    player.beutel.remove(targetItem)
            }
            if (i.poison) {
                print("${i.name} ist vergiftet")
                if (i.currentHp < i.maxHp/5) {
                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
                    dots()
                    println("${i.name} ist nicht mehr vergiftet!")
                    i.poison = false
                    Thread.sleep(1000)
                } else {
                    println(" und verliert einen Teil seiner HP!")
                    i.currentHp -= i.maxHp / 10
                    Thread.sleep(1000)
                }
                i.displayHpBar()
                Thread.sleep(1000)
            }
            if (checkGame(player)) break
        }
        val listBisaflor = PLAYERTEAM.filterIsInstance<Bisaflor>()
        if (listBisaflor.isNotEmpty() && listBisaflor.first().currentHp > 0) {
            val i = listBisaflor.first()
            println(
                """
                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
                            1 -> Attacken
                            2 -> Beutel
                        """.trimIndent()
            )
            var inputInt = readln().toInt()
            while (inputInt !in 1..2) {
                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                inputInt = readln().toInt()
            }
            if (inputInt == 1) {
                println(
                    """
                                Welche Attacke möchtest du auswählen?
                                1 -> Rankenhieb [SCH 40 / GEN 100]
                                2 -> Gigasauger [SCH 60 / GEN 90 / Heilt Teil vom Schaden]
                                3 -> Matschbombe [SCH 30 / GEN 100] & [GIF Gegner / GEN 30]
                                4 -> Reflektor [Erhöht DEF vom Team]
                            """.trimIndent()
                )
                inputInt = readln().toInt()
                while (inputInt !in 1..4) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                when (inputInt) {
                    1 -> i.rankenhieb()
                    2 -> i.gigasauger()
                    3 -> i.matschbombe()
                    4 -> i.reflektor()
                }

            } else {
                println("Was möchtest du aus deinem Beutel benutzen?")
                var counterItems = 1
                for (item in player.beutel) {
                    println("$counterItems -> $item")
                    counterItems++
                }
                inputInt = readln().toInt()
                while (inputInt !in 1..player.beutel.size) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                val targetItem = player.beutel[inputInt - 1]
                targetItem.use()
                targetItem.anzahl -= 1
                if (targetItem.anzahl == 0)
                    player.beutel.remove(targetItem)
            }
            if (i.poison) {
                print("${i.name} ist vergiftet")
                if (i.currentHp < i.maxHp/5) {
                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
                    dots()
                    println("${i.name} ist nicht mehr vergiftet!")
                    i.poison = false
                    Thread.sleep(1000)
                } else {
                    println(" und verliert einen Teil seiner HP!")
                    i.currentHp -= i.maxHp / 10
                    Thread.sleep(1000)
                }
                i.displayHpBar()
                Thread.sleep(1000)
            }
            if (checkGame(player)) break
        }
        val listTurtok = PLAYERTEAM.filterIsInstance<Turtok>()
        if (listTurtok.isNotEmpty() && listTurtok.first().currentHp > 0) {
            val i = listTurtok.first()
            println(
                """
                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
                            1 -> Attacken
                            2 -> Beutel
                        """.trimIndent()
            )
            var inputInt = readln().toInt()
            while (inputInt !in 1..2) {
                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                inputInt = readln().toInt()
            }
            if (inputInt == 1) {
                println(
                    """
                                Welche Attacke möchtest du auswählen?
                                1 -> Blubber [SCH 40 / GEN 100]
                                2 -> Aquaknarre [SCH 80 / GEN 80]
                                3 -> Hydropumpe [SCH 120 / GEN 60]
                                4 -> Bodycheck [SCH 150 / GEN 90] & [Anwender erleidet Schaden durch Rückstoß]
                            """.trimIndent()
                )
                inputInt = readln().toInt()
                while (inputInt !in 1..4) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                when (inputInt) {
                    1 -> i.blubber()
                    2 -> i.aquaknarre()
                    3 -> i.hydropumpe()
                    4 -> i.bodycheck()
                }

            } else {
                println("Was möchtest du aus deinem Beutel benutzen?")
                var counterItems = 1
                for (item in player.beutel) {
                    println("$counterItems -> $item")
                    counterItems++
                }
                inputInt = readln().toInt()
                while (inputInt !in 1..player.beutel.size) {
                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
                    inputInt = readln().toInt()
                }
                val targetItem = player.beutel[inputInt - 1]
                targetItem.use()
                targetItem.anzahl -= 1
                if (targetItem.anzahl == 0)
                    player.beutel.remove(targetItem)
            }
            if (i.poison) {
                print("${i.name} ist vergiftet")
                if (i.currentHp < i.maxHp/5) {
                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
                    dots()
                    println("${i.name} ist nicht mehr vergiftet!")
                    i.poison = false
                    Thread.sleep(1000)
                } else {
                    println(" und verliert einen Teil seiner HP!")
                    i.currentHp -= i.maxHp / 10
                    Thread.sleep(1000)
                }
                i.displayHpBar()
                Thread.sleep(1000)
            }
            if (checkGame(player)) break
        }
        val listRaidboss = ENEMYTEAM.filterIsInstance<Raidboss>()
        if (listRaidboss.isNotEmpty() && listRaidboss.first().currentHp > 0) {
            val i = listRaidboss.first()
            println("${i.name} ist dran!")
            Thread.sleep(1000)
            if (i.apHelfer == 1) {
                val randomizer = (1..7).random()
                when (randomizer) {
                    1 -> i.helfer()
                    2 -> i.erdbeben()
                    3 -> i.toxin()
                    4 -> i.konfusion()
                    5 -> i.raserei()
                    6 -> i.psychokinese()
                    7 -> i.genesung()
                }

            } else {
                val randomizer = (1..6).random()
                when (randomizer) {
                    1 -> i.erdbeben()
                    2 -> i.toxin()
                    3 -> i.konfusion()
                    4 -> i.raserei()
                    5 -> i.psychokinese()
                    6 -> i.genesung()
                }
            }
            if (i.poison) {
                print("${i.name} ist vergiftet")
                if (i.currentHp < i.maxHp/5) {
                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
                    dots()
                    println("${i.name} ist nicht mehr vergiftet!")
                    i.poison = false
                    Thread.sleep(1000)
                } else {
                    println(" und verliert einen Teil seiner HP!")
                    i.currentHp -= i.maxHp / 10
                    Thread.sleep(1000)
                }
                i.displayHpBar()
                Thread.sleep(1000)
            }
            if (checkGame(player)) break
        }
        val listHelfer = ENEMYTEAM.filterIsInstance<Helfer>()
        if (listHelfer.isNotEmpty() && listHelfer.first().currentHp > 0) {
            val i = listHelfer.first()
            println("${i.name} ist dran!")
            Thread.sleep(1000)
            val randomizer = (1..5).random()
            when (randomizer) {
                1 -> i.blizzard()
                2 -> i.felsgrab()
                3 -> i.windhose()
                4 -> i.fluegelschlag()
                5 -> i.wutanfall()
            }
            if (i.poison) {
                print("${i.name} ist vergiftet")
                if (i.currentHp < i.maxHp/5) {
                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
                    dots()
                    println("${i.name} ist nicht mehr vergiftet!")
                    i.poison = false
                    Thread.sleep(1000)
                } else {
                    println(" und verliert einen Teil seiner HP!")
                    i.currentHp -= i.maxHp / 10
                    Thread.sleep(1000)
                }
                i.displayHpBar()
                Thread.sleep(1000)
            }
            if (checkGame(player)) break
        }
    }
}