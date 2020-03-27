# Bradley Aiken
# pyex7a.py
# parse titles and urls from https://www.monmouth.edu/news/archives/

import re
import requests 

url = "https://www.monmouth.edu/news/archives/"
html = requests.get(url).text

titles = []
hrefs = []
newsfeed = {}

# find titles
headlines_re = re.compile('<div class="article-header">.*?\n(.+?)</div>')
headlines = headlines_re.findall(html)

for headline in headlines:
    titles.append(headline.lstrip().rstrip())

# find urls
links_re = re.compile('<a href=\'(.+?)\' title="')
links = links_re.findall(html)

for link in links:
    hrefs.append(link.lstrip().rstrip())

for i in range((len(titles))):
    newsfeed[titles[i]] = hrefs[i]

for key, value in newsfeed.items():
    print(key, ": ", value, sep="")