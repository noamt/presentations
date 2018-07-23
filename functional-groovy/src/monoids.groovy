import groovy.transform.*

@EqualsAndHashCode
class CocktailIngredients {
  Set<String> names

  CocktailIngredients plus(CocktailIngredients ci) {
    new CocktailIngredients(names: names + ci.names)
  }  
}

def tequila = new CocktailIngredients(names: ["Tequila"] as Set)
def tripleSec = new CocktailIngredients(names: ["Triple Sec"] as Set)
def limeJuice = new CocktailIngredients(names: ["Lime Juice"] as Set)

tequila + tripleSec + limeJuice == tripleSec + limeJuice + tequila

//using GPars
def proceduralSum = [tequila, tripleSec, limeJuice].sum()
def parallelSum = withPool { [tequila, tripleSec, limeJuice].sumParallel() }
proceduralSum == parallelSum