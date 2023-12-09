file = open("inputs/day4.txt", "r")
lines = file.readlines()
cards = {}
total_score = 0
total_cards = 0

def parse_string_to_num_list(string):
    nums = []
    nums_str = string.strip().split()
    for num in nums_str:
        if num.isnumeric():
            nums.append(int(num))
    return nums

for line in lines:
    id = int(line.split(':')[0].strip().split()[1])
    nums = parse_string_to_num_list(line.split(':')[1].split('|')[0])
    winning_nums = parse_string_to_num_list(line.split(':')[1].split('|')[1])
    cards[id] = (nums, winning_nums, 1)

for id in cards:
    hits = 0
    score = 0
    nums = cards[id][0]
    w_nums = cards[id][1]
    copies = cards[id][2]
    for num in nums:
        if num in w_nums:
            hits += 1
            if score == 0:
                score += 1
            else:
                score *= 2
    if score > 0:
        for offset in range(1, hits + 1):
            if id + offset <= len(cards):
                card = cards[id + offset]
                cards[id + offset] = (card[0], card[1], card[2] + copies)
    total_cards += copies
    total_score += score

print(total_cards)