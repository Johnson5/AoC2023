import math

file = open("inputs/day8.txt", "r")
directions = file.readline().strip()
_ = file.readline()
map_lines = [line.strip().split("=") for line in file.readlines()]

map_dict = { line[0].strip() : (line[1].split(',')[0][2:], line[1].split(',')[1][1:-1]) for line in map_lines }

# part 1
#pos = ["AAA"]

#part 2
pos = [x for x in map_dict if x[-1] == 'A']
steps = [0 for x in pos]

len_dir = len(directions)

for (index,p) in enumerate(pos):
    while not p[-1] == 'Z':
        next_dir = directions[steps[index] % len_dir]
        if next_dir == 'R':
            p = map_dict[p][1]
        else:
            p = map_dict[p][0]
        steps[index] += 1

print(pos)
print(steps)
print(math.lcm(*steps))