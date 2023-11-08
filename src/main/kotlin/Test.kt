fun main() {
//    println("Willkommen bei dem Golden Syntax RPG - Pokemon Edition. Wie heißt du?")
//    val input = readln()
//    val player = Spieler(input)
//    println("Hiermit startest du:")
//    Thread.sleep(1000)
//    player.infoTeam()
//    Thread.sleep(1000)
//    player.infoBeutel()
//    Thread.sleep(1000)
//    println("Dann lass uns loslegen ${player.name}!")
//    Thread.sleep(1000)
//    print("${player.name} geht in die Azuria-Höhle")
//    dots()
//    println("ein wildes Mewto erscheint!")
//    Thread.sleep(1000)
//    // Sound?
//    for (i in player.team)
//        PLAYERTEAM.add(i)
//    ENEMYTEAM.add(Raidboss(Mewtu()))
//    println("Der Kampf beginnt!")
//    println("Dein Team:")
//    Thread.sleep(1000)
//    for (i in PLAYERTEAM) {
//        i.displayHpBar()
//        Thread.sleep(1000)
//    }
//    println("Dein Gegner:")
//    Thread.sleep(1000)
//    for (i in ENEMYTEAM) {
//        i.displayHpBar()
//        Thread.sleep(1000)
//    }
//    while (true) {
//        val listGlurak = PLAYERTEAM.filterIsInstance<Glurak>()
//        if (listGlurak.isNotEmpty() && listGlurak.first().currentHp > 0) {
//            val i = listGlurak.first()
//            println(
//                """
//                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
//                            1 -> Attacken
//                            2 -> Beutel
//                        """.trimIndent()
//            )
//            var inputInt = readln().toInt()
//            while (inputInt !in 1..2) {
//                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                inputInt = readln().toInt()
//            }
//            if (inputInt == 1) {
//                println(
//                    """
//                                Welche Attacke möchtest du auswählen?
//                                1 -> Glut
//                                2 -> Flammenwurf
//                                3 -> Geowurf
//                                4 -> Heuler
//                            """.trimIndent()
//                )
//                inputInt = readln().toInt()
//                while (inputInt !in 1..4) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                when (inputInt) {
//                    1 -> i.glut()
//                    2 -> i.flammenwurf()
//                    3 -> i.geowurf()
//                    4 -> i.heuler()
//                }
//
//            } else {
//                println("Was möchtest du aus deinem Beutel benutzen?")
//                var counterItems = 1
//                for (item in player.beutel) {
//                    println("$counterItems -> $item")
//                    counterItems++
//                }
//                inputInt = readln().toInt()
//                while (inputInt !in 1..player.beutel.size) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                val targetItem = player.beutel[inputInt - 1]
//                targetItem.use()
//                targetItem.anzahl -= 1
//                if (targetItem.anzahl == 0)
//                    player.beutel.remove(targetItem)
//            }
//            if (i.poison) {
//                print("${i.name} ist vergiftet")
//                if (i.currentHp < i.maxHp/5) {
//                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
//                    dots()
//                    println("${i.name} ist nicht mehr vergiftet!")
//                    i.poison = false
//                } else {
//                    println(" und verliert einen Teil seiner HP!")
//                    i.currentHp -= i.maxHp / 10
//                }
//                i.displayHpBar()
//            }
//            if (checkGame(player)) break
//        }
//        val listBisaflor = PLAYERTEAM.filterIsInstance<Bisaflor>()
//        if (listBisaflor.isNotEmpty() && listBisaflor.first().currentHp > 0) {
//            val i = listBisaflor.first()
//            println(
//                """
//                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
//                            1 -> Attacken
//                            2 -> Beutel
//                        """.trimIndent()
//            )
//            var inputInt = readln().toInt()
//            while (inputInt !in 1..2) {
//                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                inputInt = readln().toInt()
//            }
//            if (inputInt == 1) {
//                println(
//                    """
//                                Welche Attacke möchtest du auswählen?
//                                1 -> Rankenhieb
//                                2 -> Gigasauger
//                                3 -> Matschbombe
//                                4 -> Reflektor
//                            """.trimIndent()
//                )
//                inputInt = readln().toInt()
//                while (inputInt !in 1..4) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                when (inputInt) {
//                    1 -> i.rankenhieb()
//                    2 -> i.gigasauger()
//                    3 -> i.matschbombe()
//                    4 -> i.reflektor()
//                }
//
//            } else {
//                println("Was möchtest du aus deinem Beutel benutzen?")
//                var counterItems = 1
//                for (item in player.beutel) {
//                    println("$counterItems -> $item")
//                    counterItems++
//                }
//                inputInt = readln().toInt()
//                while (inputInt !in 1..player.beutel.size) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                val targetItem = player.beutel[inputInt - 1]
//                targetItem.use()
//                targetItem.anzahl -= 1
//                if (targetItem.anzahl == 0)
//                    player.beutel.remove(targetItem)
//            }
//            if (i.poison) {
//                print("${i.name} ist vergiftet")
//                if (i.currentHp < i.maxHp/5) {
//                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
//                    dots()
//                    println("${i.name} ist nicht mehr vergiftet!")
//                    i.poison = false
//                } else {
//                    println(" und verliert einen Teil seiner HP!")
//                    i.currentHp -= i.maxHp / 10
//                }
//                i.displayHpBar()
//            }
//            if (checkGame(player)) break
//        }
//        val listTurtok = PLAYERTEAM.filterIsInstance<Turtok>()
//        if (listTurtok.isNotEmpty() && listTurtok.first().currentHp > 0) {
//            val i = listTurtok.first()
//            println(
//                """
//                            ${i.name} ist dran! Welche Aktion möchtest du ausführen?
//                            1 -> Attacken
//                            2 -> Beutel
//                        """.trimIndent()
//            )
//            var inputInt = readln().toInt()
//            while (inputInt !in 1..2) {
//                println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                inputInt = readln().toInt()
//            }
//            if (inputInt == 1) {
//                println(
//                    """
//                                Welche Attacke möchtest du auswählen?
//                                1 -> Blubber
//                                2 -> Aquaknarre
//                                3 -> Hydropumpe
//                                4 -> Bodycheck
//                            """.trimIndent()
//                )
//                inputInt = readln().toInt()
//                while (inputInt !in 1..4) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                when (inputInt) {
//                    1 -> i.blubber()
//                    2 -> i.aquaknarre()
//                    3 -> i.hydropumpe()
//                    4 -> i.bodycheck()
//                }
//
//            } else {
//                println("Was möchtest du aus deinem Beutel benutzen?")
//                var counterItems = 1
//                for (item in player.beutel) {
//                    println("$counterItems -> $item")
//                    counterItems++
//                }
//                inputInt = readln().toInt()
//                while (inputInt !in 1..player.beutel.size) {
//                    println("Deine Eingabe ist leider ungültig. Versuche es erneut...")
//                    inputInt = readln().toInt()
//                }
//                val targetItem = player.beutel[inputInt - 1]
//                targetItem.use()
//                targetItem.anzahl -= 1
//                if (targetItem.anzahl == 0)
//                    player.beutel.remove(targetItem)
//            }
//            if (i.poison) {
//                print("${i.name} ist vergiftet")
//                if (i.currentHp < i.maxHp/5) {
//                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
//                    dots()
//                    println("${i.name} ist nicht mehr vergiftet!")
//                    i.poison = false
//                } else {
//                    println(" und verliert einen Teil seiner HP!")
//                    i.currentHp -= i.maxHp / 10
//                }
//                i.displayHpBar()
//            }
//            if (checkGame(player)) break
//        }
//        val listRaidboss = ENEMYTEAM.filterIsInstance<Raidboss>()
//        if (listRaidboss.isNotEmpty() && listRaidboss.first().currentHp > 0) {
//            val i = listRaidboss.first()
//            println("${i.name} ist dran!")
//            if (i.apHelfer == 1) {
//                val randomizer = 1//(1..7).random()
//                when (randomizer) {
//                    1 -> i.helfer()
//                    2 -> i.erdbeben()
//                    3 -> i.toxin()
//                    4 -> i.konfusion()
//                    5 -> i.raserei()
//                    6 -> i.psychokinese()
//                    7 -> i.genesung()
//                }
//
//            } else {
//                val randomizer = (1..6).random()
//                when (randomizer) {
//                    1 -> i.erdbeben()
//                    2 -> i.toxin()
//                    3 -> i.konfusion()
//                    4 -> i.raserei()
//                    5 -> i.psychokinese()
//                    6 -> i.genesung()
//                }
//            }
//            if (i.poison) {
//                print("${i.name} ist vergiftet")
//                if (i.currentHp < i.maxHp/5) {
//                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
//                    dots()
//                    println("${i.name} ist nicht mehr vergiftet!")
//                    i.poison = false
//                } else {
//                    println(" und verliert einen Teil seiner HP!")
//                    i.currentHp -= i.maxHp / 10
//                }
//                i.displayHpBar()
//            }
//            if (checkGame(player)) break
//        }
//        val listHelfer = ENEMYTEAM.filterIsInstance<Helfer>()
//        if (listHelfer.isNotEmpty() && listHelfer.first().currentHp > 0) {
//            val i = listHelfer.first()
//            println("${i.name} ist dran!")
//            val randomizer = (1..7).random()
//            when (randomizer) {
//                1 -> i.blizzard()
//                2 -> i.donnerwelle()
//                3 -> i.schlafrede()
//                4 -> i.felsgrab()
//                5 -> i.windhose()
//                6 -> i.fluegelschlag()
//                7 -> i.wutanfall()
//            }
//            if (i.poison) {
//                print("${i.name} ist vergiftet")
//                if (i.currentHp < i.maxHp/5) {
//                    print(", da seine HP unter 20% gefallen sind, lässt die Wirkung des Gifts nach")
//                    dots()
//                    println("${i.name} ist nicht mehr vergiftet!")
//                    i.poison = false
//                } else {
//                    println(" und verliert einen Teil seiner HP!")
//                    i.currentHp -= i.maxHp / 10
//                }
//                i.displayHpBar()
//            }
//            if (checkGame(player)) break
//        }
//    }
}


//for (i in ENEMYTEAM) {
//    if (i is Raidboss) {
//        println("${i.name} ist dran!")
//        if (i.apHelfer == 1) {
//            val randomizer = (1..7).random()
//            when (randomizer) {
//                1 -> i.helfer()
//                2 -> i.erdbeben()
//                3 -> i.toxin()
//                4 -> i.konfusion()
//                5 -> i.raserei()
//                6 -> i.psychokinese()
//                7 -> i.genesung()
//            }
//
//        } else {
//            val randomizer = (1..6).random()
//            when (randomizer) {
//                1 -> i.erdbeben()
//                2 -> i.toxin()
//                3 -> i.konfusion()
//                4 -> i.raserei()
//                5 -> i.psychokinese()
//                6 -> i.genesung()
//            }
//        }
//        checkPlayerTeam()
//    } else if (i is Helfer) {
//        println("${i.name} ist dran!")
//        val randomizer  =(1..7).random()
//        when (randomizer) {
//            1 -> i.blizzard()
//            2 -> i.donnerwelle()
//            3 -> i.schlafrede()
//            4 -> i.felsgrab()
//            5 -> i.windhose()
//            6 -> i.flügelschlag()
//            7 -> i.wutanfall()
//        }
//        checkPlayerTeam()
//    }
//}