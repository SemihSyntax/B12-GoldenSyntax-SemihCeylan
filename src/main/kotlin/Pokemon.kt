open class Pokemon(
    var name: String,
    var maxHp: Int,
    var currentHp: Int,
    var atk: Double,
    var def: Double,
    var type1: String,
    var type2: String
) {
    var poison: Boolean = false
    var paralyze: Boolean = false
    var sleep: Boolean = false
    var confusion: Boolean = false
    override fun toString(): String {
        return name
    }

    fun renamePokemon() {
        println("Willst du den Namen von $name ändern?\n1 --> Ja\n2 --> Nein")
        var input = readln().toInt()
        while (input !in 1..2) {
            println("Leider ist deine Eingabe ungültig.")
            println("Willst du den Namen von $name ändern?\n1 --> Ja\n2 --> Nein")
            input = readln().toInt()
        }
        if (input == 1) {
            println("Wie soll dein Pokemon heißen?")
            name = readln()
        }
    }

    fun displayHpBar() {
        if (currentHp < 1)
            currentHp = 0
        val hpBarLength = 20
        val hpPercentage = (currentHp.toDouble() / maxHp.toDouble() * 100.0).toInt()
        val currentHPBarLength = (hpPercentage * hpBarLength / 100).coerceIn(0, hpBarLength)
        val maxHPBarLength = hpBarLength - currentHPBarLength

        val resetColor = "\u001B[0m"
        val currentHPColor =
            if (hpPercentage > 60) "\u001B[42m"
            else if (hpPercentage in 30..60) "\u001B[43m"
            else "\u001B[41m"
        val maxHPColor = "\u001B[47m"

        val currentHPBar = " ".repeat(currentHPBarLength)
        val maxHPBar = " ".repeat(maxHPBarLength)

        val status = when {
            paralyze -> "⚡️[PAR]"
            sleep -> "💤[SLF]"
            poison -> "☠️[GIF]"
            else -> ""
        }
        val hpInfo = "[$currentHp/$maxHp]".padStart("$name's HP: $currentHPBar$maxHPBar".length)
        println("${name}'s HP: $currentHPColor$currentHPBar$resetColor$maxHPColor$maxHPBar$resetColor $status\n$hpInfo\n")
    }

//    fun heal(amount: Int) {
//        currentHp += amount
//        if (currentHp > maxHp)
//            currentHp = maxHp
//    }
}