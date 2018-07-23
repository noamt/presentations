import groovy.transform.*

@EqualsAndHashCode
class CocktailIngredients {
  List<String> names

  CocktailIngredients plus(CocktailIngredients ci) {
    new CocktailIngredients(names: names + ci.names)
  }  
}

def tequila = new CocktailIngredients(names: ["Tequila"])
def tripleSec = new CocktailIngredients(names: ["Triple Sec"])
def limeJuice = new CocktailIngredients(names: ["Lime Juice"])

def extraTequila = {CocktailIngredients ci ->
    plus(new CocktailIngredients(names: ["Tequila"]))
}

margarita = tripleSec + limeJuice + tequila
battleMargarita = margarita.with(extraTequila)
println(battleMargarita.names)