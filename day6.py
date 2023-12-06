import math

file = open("inputs/day6.txt", "r")
lines = file.readlines()
_, *times = lines[0].split()
_, *distances = lines[1].split()


def calc_speed(time, distance):
    t = int(time)
    d = int(distance)
    speed1 = (-t + math.sqrt(t**2 - 4 * -1 * -d)) / -2
    speed2 = (-t - math.sqrt(t**2 - 4 * -1 * -d)) / -2
    return math.ceil(speed2) - math.floor(speed1) - 1

# part 1
ans = 1

for time, distance in zip(times,distances):
    ans *= calc_speed(time, distance)

print(ans)

#part 2
ans2 = calc_speed(''.join(times),''.join(distances))
print(ans2)
