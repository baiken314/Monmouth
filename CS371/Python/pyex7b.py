# Bradley Aiken
# pyex7b.py
# parse titles and urls from https://www.monmouth.edu/news/archives/ with bs4

from bs4 import BeautifulSoup
from mechanize._urllib2 import urlopen

url = "https://www.monmouth.edu/news/archives/"
html = urlopen(url).read()

soup = BeautifulSoup(html, "html.parser")

titles = []
hrefs = []
newsfeed = {}

# populate lists and dict
for article in soup.find_all("article", {
    "class": "article-preview"
}):
    titles.append(article.a["title"])
    hrefs.append(article.a["href"])
    newsfeed[article.a["title"]] = article.a["href"]
    
# print dict
for key, value in newsfeed.items():
    print(key, ": ", value, sep="")