file = open("inputs/day3.txt", "r")

tmp_line = []
lines = []
valid_nums = []
gear_ratios = 0

while 1:
    # read by character
    char = file.read(1)
    if not char: 
        lines.append(tmp_line)
        break
    if char == '\n':
        lines.append(tmp_line)
        tmp_line = []
    else:
        tmp_line.append(char)

def check_adjacent(x,y,compare_string):
    adjacent_list = set()
    for xstep in [-1, 0, 1]:
        for ystep in [-1, 0, 1]:
            if (not (xstep == 0 and ystep == 0)) and y + ystep >= 0 and y + ystep < len(lines) and x + xstep >= 0 and x + xstep < len(lines[0]):
                if lines[y + ystep][x + xstep] in compare_string:
                    adjacent_list.add((x + xstep, y + ystep))
    return adjacent_list

def check_gear(x,y):
    adjacent_list = check_adjacent(x, y, "0123456789")
    num_dict = {}
    for item in adjacent_list:
        ((start, end), value) = get_num(item)
        num_dict[(start,end)] = value
    tmp_num = 1
    if len(num_dict) == 2:
        for item in num_dict:
            tmp_num *= num_dict[item]
        return tmp_num
    else:
        return 0

def get_num(tuple):
    num = ""
    x = tuple[0]
    y = tuple[1]
    char = lines[y][x]
    while x > 0:
        if lines[y][x - 1].isnumeric():
            x -= 1
            char = lines[y][x]
        else:
            break
    begin = (x,y)
    num += char
    while x < len(lines[0]) - 2:
        if lines[y][x+1].isnumeric():
            x += 1
            char = lines[y][x]
            num += char
        else:
            break
    end = (x,y)
    return ((begin,end),int(num))

for y, line in enumerate(lines):
    in_num = False
    tmp_num = ""
    adjacent = False
    for x, char in enumerate(line):
        if char == '*':
            if check_gear(x,y) > 0:
                gear_ratios += check_gear(x,y)
        if char.isnumeric() and not x == len(line) - 1:
            tmp_num += char
            in_num = True
            if not adjacent:
                adjacent = len(check_adjacent(x, y, "/!@#$%^&*+_-=")) > 0
        elif char.isnumeric() and x == len(line) - 1:
            if adjacent or len(check_adjacent(x, y, "/!@#$%^&*+_-=")) > 0:
                tmp_num += char
                valid_nums.append(int(tmp_num))
            tmp_num = ""
            adjacent = False
        elif in_num:
            if adjacent:
                valid_nums.append(int(tmp_num))
            tmp_num = ""
            adjacent = False 

print(sum(valid_nums))
print(gear_ratios)
