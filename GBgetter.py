import guidebox
import json
import urllib
from pprint import pprint

guidebox.api_key = "525ee679bd87a0f0b00e062f6e805e7ad0e578b4"
guidebox.region = "US"
movies = guidebox.Movie.list()
sources = guidebox.Source.list(limit=250)
channels = guidebox.Channel.list(limit=100, type='online')
test = json.dumps(channels)
test = json.loads(test)
print(channels)
for chan in test['results']:
    print(chan)
