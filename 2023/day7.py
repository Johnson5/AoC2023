import math

file = open("inputs/day7.txt", "r")
hands = [[0, *line.split()] for line in file.readlines()]

def score(hands):
    score = 0
    for (index, hand) in enumerate(sorted(hands)):
        score += (index + 1) * int(hand[2])
    return score

def no_joker(hand):
        h = list(hand[1])
        sort_h = sorted(h)
        set_h = set(h)
        if len(set_h) == 1:
            #5 of a kind
            hand[0] = 7
        elif len(set_h) == 2:
            if(sort_h.count(sort_h[0]) == 4 or sort_h.count(sort_h[-1]) == 4):
                #4 of a kind
                hand[0] = 6
            else:
                #full house
                hand[0] = 5
        elif len(set_h) == 3:
            if(sort_h.count(sort_h[0]) == 3 or sort_h.count(sort_h[1]) == 3 or sort_h.count(sort_h[-1]) == 3):
                #3 of a kind
                hand[0] = 4
            else:
                #two pair
                hand[0] = 3
        elif len(set_h) == 4:
            #one pair
            hand[0] = 2
        elif len(set_h) == 5:
            #high card
            hand[0] = 1
        return hand

def replace1(hand):
    hand[1] = hand[1].replace('A', 'E')
    hand[1] = hand[1].replace('T', 'A')
    hand[1] = hand[1].replace('J', 'B')
    hand[1] = hand[1].replace('Q', 'C')
    hand[1] = hand[1].replace('K', 'D')
    return hand

def replace2(hand):
    hand[1] = hand[1].replace('A', 'E')
    hand[1] = hand[1].replace('T', 'A')
    hand[1] = hand[1].replace('J', '0')
    hand[1] = hand[1].replace('Q', 'C')
    hand[1] = hand[1].replace('K', 'D')
    return hand

map = {
    1: [7,0,0,0,0,7],
    2: [5,7,7,7,7,0],
    3: [3,5,6,6,0,0],
    4: [2,4,4,0,0,0],
    5: [1,2,0,0,0,0]
}

def maybe_joker(hand):
    num_of_j = hand[1].count('0')
    if num_of_j == 0:
        hand = no_joker(hand)
    else:
        h = list(hand[1]) 
        len_set = len(set(h))
        if len_set == 3 and num_of_j == 1:
            tmp_hand = hand[1].replace('0', '')
            sort_h = sorted(tmp_hand)
            if(sort_h.count(sort_h[0]) == 3 or sort_h.count(sort_h[-1]) == 3):
                # four of a kind
                hand[0] = 6
            else:
                hand[0] = 5
        else:
            hand[0] = map[len_set][num_of_j]
    return hand


#part1_hands = [no_joker(replace1(hand)) for hand in hands1]
#print(score(part1_hands))

part2_hands = [maybe_joker(replace2(hand)) for hand in hands]
print(score(part2_hands))
