# Bradley Aiken
# cssenews_rss.py
# Generates an rss file based on the 25 most recent MU CSSE news articles
#
# - headlines
# - descriptions
#  - consists of first 75 words followed by " ..."
#  - no newlines in description
# - headlines and descriptions must have no tags or unicode codes
# - urls
#  - must link to name or id
#
# Creates valid cssenews.rss.xml

import datetime
import re
import requests

import PyRSS2Gen

csse_news_url = "https://www.monmouth.edu/department-of-csse/news-events/"
html = str(requests.get(csse_news_url).content, "utf-8")

rss = PyRSS2Gen.RSS2(
    title="CSSE News Articles",
    link=csse_news_url,
    description="All news articles and urls from the Monmouth University computer science and software engineering department news archive.",
    lastBuildDate=datetime.datetime.now(),
    items=[]
)

# gets html for each article
article_html_list = re.findall(r'<a *class="anchorMargin".*?<hr.*?>', html, re.DOTALL)[:25]

for article_html in article_html_list:
    headline =  re.sub(r'(<.*?>|&.*?;|#.*?;)', '',
        re.findall(r'<strong>.*?</strong>', article_html, re.DOTALL)[0])  # headline in strong tag
    link = csse_news_url + "#" + re.findall(r'name=".+?"', article_html)[0][6:-1]
    description = []  # will hold all words, will be converted to string

    for p in re.findall(r'<p>.*?</p>', article_html, re.DOTALL)[1:]:  # first p is title
        if not re.match(r'.*?<img.*?', p, re.DOTALL) and len(p):  # do not want img or empty ps
            description.extend(re.split(r'\s+', re.sub(r'(<.*?>|&.*?;|#.*?;)', '', p)))  # add words to description

    # cut description to 74 words plus ...
    if len(description) > 75:
        description = description[:74]
        description.append('...')
    description = ' '.join(description)

    # add article information to rss items
    rss.items.append(PyRSS2Gen.RSSItem(
        title=headline,
        link=link,
        description=description))

rss.write_xml(open("csse_news.rss.xml", "w")) 
