def measurement = "ounce" 

def tequila = { x -> "${x} ${measurement} Tequila" }
def tripleSec = { x -> "${x} ${measurement} Triple Sec" }
def limeJuice = { x -> "${x} ${measurement} Lime Juice" }

def margarita = {
    [tequila, tripleSec, limeJuice].collect({x -> x(1.5)}).join(', ')
}

def prepareCocktail = { glasses, cocktail ->
    glasses.times({x -> println("Glass ${x+1}: ${cocktail()}")})
}.memoize()

prepareCocktail(2, margarita)
prepareCocktail(2, margarita)

// $ Glass 1: 1.5 ounce Tequila, 1.5 ounce Triple Sec, 1.5 ounce Lime Juice
// $ Glass 2: 1.5 ounce Tequila, 1.5 ounce Triple Sec, 1.5 ounce Lime Juice