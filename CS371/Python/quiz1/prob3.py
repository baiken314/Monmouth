# Bradley Aiken
# prob3.py

word_lengths = {}

for word in open("english.sorted", "r").readlines():
    word_length = len(word.rstrip())
    if word_length not in word_lengths.keys():
        word_lengths[word_length] = 1
    else:
        word_lengths[word_length] += 1

for i in range(1, sorted(list(word_lengths.keys()))[-1]):
    if i not in word_lengths.keys():
        word_lengths[i] = 0

print("Length\t\tOccurances")
for key, value in sorted(word_lengths.items()):
    print(key, "\t\t", value, sep="")