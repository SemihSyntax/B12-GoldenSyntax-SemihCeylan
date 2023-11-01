class Raidboss(pokemon: Pokemon) : Pokemon(
    name = "Raid-Boss ${pokemon.name}",
    maxHp = pokemon.maxHp * 2,
    currentHp = pokemon.currentHp * 2,
    atk = pokemon.atk * 2,
    def = pokemon.def * 2,
    poison = pokemon.poison,
    paralyzed = pokemon.paralyzed,
    sleep = pokemon.sleep,
    type1 = pokemon.type1,
    type2 = pokemon.type2) {

}