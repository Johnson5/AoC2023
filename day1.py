import regex
file = open("day1.txt", "r")
listStr = file.readlines()
listNum = []

def parse_from_string(string):
    if string.isnumeric():
        return int(string)
    else:
        match string:
            case "one":
                return 1
            case "two":
                return 2
            case "three":
                return 3
            case "four":
                return 4
            case "five":
                return 5
            case "six":
                return 6
            case "seven":
                return 7
            case "eight":
                return 8
            case "nine":
                return 9

for i in range(len(listStr)):
    digs = regex.findall('\d|one|two|three|four|five|six|seven|eight|nine', listStr[i], overlapped=True)
    print(listStr[i], digs)
    first = parse_from_string(digs[0])
    last = parse_from_string(digs[-1])
    listNum.append((first * 10) + last)
    
print(sum(listNum))
