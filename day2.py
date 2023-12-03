file = open("inputs/day2.txt", "r")
lines = file.readlines()
games = []
for line in lines:
    games.append([line.split(':')[0], line.split(':')[1].split(';')])

id_counter = 0
power_counter = 0

for game in games:
    id = int(game[0].split(' ')[1])
    possible_game = True
    max_green = 0
    max_red = 0
    max_blue = 0

    for hand in game[1]:
        red = 0
        blue = 0
        green = 0
        colors = hand.split(',')
        for color in colors:
            c = color.strip()
            val = int(c.split(' ')[0])
            if "red" in c:
                red += val
                max_red = max(val, max_red)
            elif "blue" in c:
                blue += val
                max_blue = max(val, max_blue)
            elif "green" in c:
                green += val
                max_green = max(val, max_green)
            
        if red > 12 or green > 13 or blue > 14:
            possible_game = False
            
    print(game, max_red, max_green, max_blue)
    if possible_game:
        id_counter += id
    power_counter += max_red * max_green * max_blue

print(power_counter)
