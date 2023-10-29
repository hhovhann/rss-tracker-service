# rss-tracker-service
RSS/Atom feeds update tracker Rest API service project for Spring Boot


## Testing Rest API

1. Get list of stored resources faceted by given categories and date range
``` 
POST http://localhost:8080/feeds/search

REQUEST BODY:
{
    "categories" : ["Java"],
    "dateFrom" : "2010-04-27T04:30:45.123Z",
    "dateTo" : "2023-10-30T22:30:45.123Z"
}
    
RESPONSE BODY:
[
    {
        "title": "The man rescuing Britain's 'magical' glow worms",
        "link": "https://www.bbc.co.uk/news/science-environment-67240450?at_medium=RSS&at_campaign=KARANGA",
        "description": "Glow worms are a rare sight in the UK but one young conservationist is trying to bring them back.",
        "getPublicationDate": "2023-10-28T03:52:02+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67240450"
    },
    {
        "title": "Reintroducing wildlife species 'not a priority'",
        "link": "https://www.bbc.co.uk/news/science-environment-67230751?at_medium=RSS&at_campaign=KARANGA",
        "description": "Bringing previously extinct native species like beavers back to England is not on the Environment Secretary's priority list.",
        "getPublicationDate": "2023-10-27T06:59:02+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67230751"
    },
    {
        "title": "Bacterium found in African elephants may explain sudden deaths",
        "link": "https://www.bbc.co.uk/news/science-environment-67197251?at_medium=RSS&at_campaign=KARANGA",
        "description": "A bacterium found in several wild elephants may explain why hundreds died suddenly in Botswana in 2020.",
        "getPublicationDate": "2023-10-25T16:04:34+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67197251"
    },
    {
        "title": "Bull semen: Artificial insemination tanks stolen in County Tyrone",
        "link": "https://www.bbc.co.uk/news/uk-northern-ireland-67235631?at_medium=RSS&at_campaign=KARANGA",
        "description": "The size of the tanks stolen is not known but police say their contents were of \"significant value\".",
        "getPublicationDate": "2023-10-27T12:41:23+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/uk-northern-ireland-67235631"
    },
    {
        "title": "Regulator reveals water firms with worst finances",
        "link": "https://www.bbc.co.uk/news/business-67225011?at_medium=RSS&at_campaign=KARANGA",
        "description": "Thames Water is among firms being closely monitored due to concerns over their performance.",
        "getPublicationDate": "2023-10-26T20:11:38+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/business-67225011"
    },
    {
        "title": "Big banks linked to products with pangolin and leopard parts",
        "link": "https://www.bbc.co.uk/news/business-67191069?at_medium=RSS&at_campaign=KARANGA",
        "description": "The companies include UK multinationals such as HSBC, Prudential, and Legal & General.",
        "getPublicationDate": "2023-10-25T03:29:05+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/business-67191069"
    },
    {
        "title": "World shift to clean energy is unstoppable, IEA report says",
        "link": "https://www.bbc.co.uk/news/science-environment-67198206?at_medium=RSS&at_campaign=KARANGA",
        "description": "The world is shifting rapidly to clean energy but still investing too much in fossil fuels, the IEA says.",
        "getPublicationDate": "2023-10-24T08:00:32+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67198206"
    },
    {
        "title": "Skeletons discovered in rare 5,000-year-old tomb in Orkney",
        "link": "https://www.bbc.co.uk/news/uk-scotland-north-east-orkney-shetland-67195563?at_medium=RSS&at_campaign=KARANGA",
        "description": "Archaeologists say pottery and stone tools have also been found at the site in Orkney.",
        "getPublicationDate": "2023-10-24T21:46:57+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/uk-scotland-north-east-orkney-shetland-67195563"
    },
    {
        "title": "Sea-level rise: West Antarctic ice shelf melt 'unavoidable'",
        "link": "https://www.bbc.co.uk/news/science-environment-67171231?at_medium=RSS&at_campaign=KARANGA",
        "description": "Future sea-level rise may have been underestimated, a new study warns, with more melt \"locked in\".",
        "getPublicationDate": "2023-10-23T19:00:08+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67171231"
    },
    {
        "title": "Could the UK's tides help wean us off fossil fuels?",
        "link": "https://www.bbc.co.uk/news/science-environment-67170625?at_medium=RSS&at_campaign=KARANGA",
        "description": "The UK has some of the world's most powerful tides - and is well placed to exploit their power.",
        "getPublicationDate": "2023-10-22T03:43:12+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67170625"
    },
    {
        "title": "What is COP28 in Dubai and why is it important?",
        "link": "https://www.bbc.co.uk/news/science-environment-67143989?at_medium=RSS&at_campaign=KARANGA",
        "description": "The climate change summit comes after a year of weather extremes and broken temperature records.",
        "getPublicationDate": "2023-10-25T14:56:08+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67143989"
    },
    {
        "title": "Climate Change Committee says UK no longer a world leader",
        "link": "https://www.bbc.co.uk/news/science-environment-66032607?at_medium=RSS&at_campaign=KARANGA",
        "description": "The UK's statutory climate body criticises the government for backing new oil and gas projects.",
        "getPublicationDate": "2023-06-28T03:01:50+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-66032607"
    },
    {
        "title": "Africa proposes global carbon taxes to fight climate change",
        "link": "https://www.bbc.co.uk/news/world-africa-66733557?at_medium=RSS&at_campaign=KARANGA",
        "description": "Despite suffering some of the worst impacts of climate change, the continent only gets 12% of financing.",
        "getPublicationDate": "2023-09-07T11:39:58+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/world-africa-66733557"
    },
    {
        "title": "Ocean heat record broken, with grim implications for the planet",
        "link": "https://www.bbc.co.uk/news/science-environment-66387537?at_medium=RSS&at_campaign=KARANGA",
        "description": "The oceans are a vital regulator for the climate and our weather but are rapidly heating up.",
        "getPublicationDate": "2023-08-04T08:00:03+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-66387537"
    },
    {
        "title": "Will the Gulf Stream really collapse by 2025?",
        "link": "https://www.bbc.co.uk/news/science-environment-66289494?at_medium=RSS&at_campaign=KARANGA",
        "description": "A new paper says its collapse could be imminent, but some experts argue science is not established.",
        "getPublicationDate": "2023-07-26T18:13:07+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-66289494"
    },
    {
        "title": "What is net zero and how are the UK and other countries doing?",
        "link": "https://www.bbc.co.uk/news/science-environment-58874518?at_medium=RSS&at_campaign=KARANGA",
        "description": "The UK may weaken some key green commitments, despite its pledge to reach \"net zero\" by 2050.",
        "getPublicationDate": "2023-09-21T01:15:05+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-58874518"
    },
    {
        "title": "US issues first ever fine for space junk to Dish Network",
        "link": "https://www.bbc.co.uk/news/technology-66993647?at_medium=RSS&at_campaign=KARANGA",
        "description": "Dish Network will have to pay $150,000 for failing to move an old satellite far enough away from the Earth.",
        "getPublicationDate": "2023-10-03T20:25:37+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/technology-66993647"
    },
    {
        "title": "James Webb telescope makes 'JuMBO' discovery of planet-like objects in Orion",
        "link": "https://www.bbc.co.uk/news/science-environment-66974738?at_medium=RSS&at_campaign=KARANGA",
        "description": "The new space observatory sees pairs of Jupiter-sized objects floating free between the stars.",
        "getPublicationDate": "2023-10-02T13:59:57+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-66974738"
    },
    {
        "title": "Osiris-Rex: Nasa confirms return of asteroid Bennu samples",
        "link": "https://www.bbc.co.uk/news/science-environment-66893661?at_medium=RSS&at_campaign=KARANGA",
        "description": "A capsule carrying debris from asteroid Bennu lands safely in the Utah desert.",
        "getPublicationDate": "2023-09-25T06:27:12+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-66893661"
    }
]
```
# Questions:

1. Fields
2. Entities relational or simple structure
3. Rest APi endpoints 
4. Estimations
5. Unclear requirements: Configuration table may have an arbitrary number of feeds for ingestion. Note that there are maybe several feeds as per site/domain. We should be able to disable ingestion of a particular feed without removing it from the config table.
   
#References
[RSS](https://en.wikipedia.org/wiki/RSS)
