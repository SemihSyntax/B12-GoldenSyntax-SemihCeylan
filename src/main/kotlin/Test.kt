fun main() {
    var glurak = Glurak()
    val bisaflor = Bisaflor()
    bisaflor.displayHpBar()
    glurak.displayHpBar()
    bisaflor.currentHp = 500
    bisaflor.displayHpBar()
    glurak.currentHp = 494
    glurak.displayHpBar()
    glurak.currentHp = 200
    glurak.displayHpBar()
    println("${glurak.atk}")
}