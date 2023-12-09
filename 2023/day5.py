import math
import sys

file = open("inputs/day5.txt", "r")
seeds = list(map(int, file.readline().split(":")[1].split()))
seed_ranges = [[seeds[i], seeds[i+1]] for i in range(0, len(seeds), 2)]

_ = file.readline()

maps_str = file.read().split("\n\n")
maps = []

for map_str in maps_str:
    head, *tail = map_str.split("\n")
    map = []
    for range_str in tail:
        nums = range_str.split()
        tup = (int(nums[0]), int(nums[1]), int(nums[2]))
        map.append(tup)
    maps.append(map)

def lookup(map, num):
    found = False
    for tuple in map:
        if num >= tuple[1] and num <= tuple[1] + tuple[2]:
            res = num - tuple[1] + tuple[0]
            found = True
            return res
    if not found:
        return num
    
def lookup_range(s_range):
    smallest = (sys.maxsize, -1)
    for seed in s_range:
        soil    = lookup(maps[0], seed)
        fert    = lookup(maps[1], soil)
        water   = lookup(maps[2], fert)
        light   = lookup(maps[3], water)
        temp    = lookup(maps[4], light)
        hum     = lookup(maps[5], temp)
        loc     = lookup(maps[6], hum)
        if loc < smallest[0]:
            smallest = (loc, seed)
    return smallest

small_ranges = []
for seed_range in seed_ranges:
    step_size = math.sqrt(seed_range[1])
    small_range = [x for x in range(seed_range[0], seed_range[0] + seed_range[1], math.floor(step_size))]
    small_ranges.append(small_range)

smallest = []
for s_range in small_ranges:
    smallest.append(lookup_range(s_range))

first_guess = sorted(smallest)[0]
snd_guess = lookup_range(range(first_guess[1] - 10_000_000, first_guess[1] + 10_000_000, 1000))
third_guess = lookup_range(range(snd_guess[1] - 1_000_000, snd_guess[1] + 1_000_000))
print("first guess: ", first_guess)
print("second guess: ", snd_guess)
print("third guess: ", third_guess)
