class Spieler(
    var name: String,
    var team: MutableList<Pokemon> = mutableListOf(Glurak(), Bisaflor(), Turtok()),
    var beutel: MutableList<Items> = mutableListOf(Trank(), TopTrank(), Gegengift())
) {
    fun infoTeam() {
        print("Dein Team besteht aus: ")
        for (i in team) {
            print("$i")
            if (i != team.last())
                print(", ")
        }
        println()
    }
    fun infoBeutel() {
        print("In deinem Beutel ist: ")
        for (i in beutel) {
            print("$i")
            if (i != beutel.last())
                print(", ")
        }
        println()
    }
}