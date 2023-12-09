file = open("inputs/day9.txt", "r")
lines = file.readlines()
seqs = [list(map(int, line.split())) for line in lines]


def rec_diffs(seq):
    diffs = [-1] * (len(seq) - 1)
    for (index, val) in enumerate(seq):
        if index > 0:
            prev = seq[index - 1]
            diffs[index - 1] = val - prev
    if (all(e == 0 for e in diffs)):
        return seq[0] # seq[-1] for part 1
    else:
        return seq[0] - rec_diffs(diffs) # seq[-1] - rec_diffs(diffs) for part 1


ans = 0
for seq in seqs:
    num = rec_diffs(seq)
    ans += num

print(ans)
