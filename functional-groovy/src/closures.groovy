def measurement = "ounce" 

def tequila = { x -> "${x} ${measurement} Tequila" }
def tripleSec = { x -> "${x} ${measurement} Triple Sec" }
def limeJuice = { x -> "${x} ${measurement} Lime Juice" }

def margarita = {
    [tequila, tripleSec, limeJuice].collect({x -> x(1.5)}).join(', ')
}

margarita()

// $ 1.5 ounce Tequila, 1.5 ounce Triple Sec, 1.5 ounce Lime Juice