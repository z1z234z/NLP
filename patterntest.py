from pattern.en import parsetree
s = 'The mobile web is more important than mobile apps.'
s = parsetree(s)
for sentence in s:
	for chunk in sentence.chunks:
		for word in chunk.words:
			 print word,
		print