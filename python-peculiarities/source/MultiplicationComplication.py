# https://codegolf.stackexchange.com/a/11480

multiplication = []
for i in range(10):
    multiplication.append(i * (i + 1))

for x in multiplication:
    print(x)