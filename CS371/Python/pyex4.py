input_file = open('english.sorted', 'r')

word_lengths = {}

for word in input_file.readlines():
	length = len(word) - 1
	if length in word_lengths:
		word_lengths[length] += 1
	else:
		word_lengths[length] = 1
		
print('Word length\t\tOccurrences')
for key, value in word_lengths.items():
	print('%i\t\t\t%i' % (key, value))
