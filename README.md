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
    "dateTo" : "2023-10-29T22:30:45.123Z"
}
    
RESPONSE BODY:
[
    {
        "title": "Mexico ready to retaliate by hurting US farmers",
        "link": "http://money.cnn.com/2017/02/13/news/economy/mexico-trump-us-corn/index.html?section=money_news_international",
        "description": "Mexican Senator Armando Rios Piter told CNN that he plans to introduce a bill this week that would stop Mexican purchases of American corn. ",
        "getPublicationDate": "2017-02-13T21:37:06+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/news/economy/mexico-trump-us-corn/index.html?section=money_news_international"
    },
    {
        "title": "Will the next iPhone charge wirelessly? ",
        "link": "http://money.cnn.com/2017/02/13/technology/apple-wireless-charging/index.html?section=money_news_international",
        "description": "The days of plugging in an iPhone to charge won't last forever.",
        "getPublicationDate": "2017-02-13T23:42:14+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/technology/apple-wireless-charging/index.html?section=money_news_international"
    },
    {
        "title": "How 'America First' could turn into to 'India First'",
        "link": "http://money.cnn.com/2017/02/13/technology/india-h1b-visa-trump-nandan-nilekani/index.html?section=money_news_international",
        "description": "Nandan Nilekani, co-founder of one of India's biggest outsourcing companies, says an H-1B visa crackdown would ultimately hurt the U.S. ",
        "getPublicationDate": "2017-02-13T23:20:08+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/technology/india-h1b-visa-trump-nandan-nilekani/index.html?section=money_news_international"
    },
    {
        "title": "Swiss voters reject corporate tax overhaul",
        "link": "http://money.cnn.com/2017/02/13/pf/taxes/switzerland-tax-referendum-vote/index.html?section=money_news_international",
        "description": "Read full story for latest details.",
        "getPublicationDate": "2017-02-13T19:45:35+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/pf/taxes/switzerland-tax-referendum-vote/index.html?section=money_news_international"
    },
    {
        "title": "Stocks hit record again. Is Trump the reason?",
        "link": "http://money.cnn.com/2017/02/13/investing/stocks-all-time-highs-donald-trump-janet-yellen-fed/index.html?section=money_news_international",
        "description": "The market is at all-time highs and many say Trump is the reason. But stocks were rallying when investors thought Hillary Clinton would win. Janet Yellen and the Fed may deserve more of the credit for the market's move.",
        "getPublicationDate": "2017-02-13T21:35:07+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/investing/stocks-all-time-highs-donald-trump-janet-yellen-fed/index.html?section=money_news_international"
    },
    {
        "title": "Apple stock nears record high",
        "link": "http://money.cnn.com/2017/02/13/technology/apple-stock-record/index.html?section=money_news_international",
        "description": "Apple stock is less than $1 away from its all-time high amid renewed optimism for the iPhone. ",
        "getPublicationDate": "2017-02-13T21:24:58+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/technology/apple-stock-record/index.html?section=money_news_international"
    },
    {
        "title": "America's NAFTA nemesis: Canada, not Mexico",
        "link": "http://money.cnn.com/2017/02/13/news/economy/nafta-canada-trudeau-trump-mexico/index.html?section=money_news_international",
        "description": "President-elect Donald Trump focuses his criticism of NAFTA on Mexico. But Canada and America have a rocky trade history too.",
        "getPublicationDate": "2017-02-13T20:59:43+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/news/economy/nafta-canada-trudeau-trump-mexico/index.html?section=money_news_international"
    },
    {
        "title": "Verizon's plan: Consumers win, investors lose",
        "link": "http://money.cnn.com/2017/02/13/investing/verizon-stock-unlimited-data-plan/index.html?section=money_news_international",
        "description": "Verizon has decided to bring back unlimited data plans. But while that's great for its subscribers, it's awful news for investors. It's another sign of how brutally competitive the telecom business is. And it's hurting Verizon's stock.",
        "getPublicationDate": "2017-02-13T20:32:13+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/investing/verizon-stock-unlimited-data-plan/index.html?section=money_news_international"
    },
    {
        "title": "Oil prices have doubled in a year. Here's why",
        "link": "http://money.cnn.com/2017/02/13/investing/oil-prices-opec-deal/index.html?section=money_news_international",
        "description": "The price of crude oil has more than doubled over the past year after bottoming out at $26 per barrel in February 2016. ",
        "getPublicationDate": "2017-02-13T18:39:58+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/investing/oil-prices-opec-deal/index.html?section=money_news_international"
    },
    {
        "title": "Tesla will sell electric cars in the Middle East",
        "link": "http://money.cnn.com/2017/02/13/investing/tesla-uae-elon-musk/index.html?section=money_news_international",
        "description": "The automaker announced Monday that its first official venture in the oil-rich Middle East will be in the United Arab Emirates. ",
        "getPublicationDate": "2017-02-13T20:18:47+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/investing/tesla-uae-elon-musk/index.html?section=money_news_international"
    },
    {
        "title": "Indian rival slams Uber's business model",
        "link": "http://money.cnn.com/2017/02/13/technology/uber-ola-india-pranay-jivrajka/index.html?section=money_news_international",
        "description": "Uber's top rival in India has some unsolicited advice for the U.S. startup: Go local.",
        "getPublicationDate": "2017-02-13T17:48:42+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/13/technology/uber-ola-india-pranay-jivrajka/index.html?section=money_news_international"
    },
    {
        "title": "Cook calls for campaign against fake news",
        "link": "http://money.cnn.com/2017/02/11/media/fake-news-apple-ceo-tim-cook/index.html?section=money_news_international",
        "description": "Apple CEO Tim Cook wants the tech industry to take action against \"fake news\" stories that are polluting the web.",
        "getPublicationDate": "2017-02-12T23:50:17+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/11/media/fake-news-apple-ceo-tim-cook/index.html?section=money_news_international"
    },
    {
        "title": "Trump brand takes another hit",
        "link": "http://money.cnn.com/2017/02/12/news/companies/trump-brand-sears-kmart/index.html?section=money_news_international",
        "description": "Sears Holdings, the company that owns retail stores Sears and Kmart, said this weekend that it would remove 31 Trump-branded items from its website. ",
        "getPublicationDate": "2017-02-13T20:07:44+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/12/news/companies/trump-brand-sears-kmart/index.html?section=money_news_international"
    },
    {
        "title": "Cutting down trash with bamboo packaging ",
        "link": "http://money.cnn.com/2017/02/12/news/thailand-bamboo-cassava-packaging-universal-biopack/index.html?section=money_news_international",
        "description": "Universal Biopack makes packaging that it sells to restaurants and manufacturers. But rather than plastic, it uses a mixture of bamboo and cassava.",
        "getPublicationDate": "2017-02-13T06:14:26+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/12/news/thailand-bamboo-cassava-packaging-universal-biopack/index.html?section=money_news_international"
    },
    {
        "title": "Nike stars champion 'Equality' in new ad",
        "link": "http://money.cnn.com/2017/02/12/news/companies/nike-equality-lebron-serena/index.html?section=money_news_international",
        "description": "Nike on Sunday launched a star-studded short film titled \"Equality\" that coincides with Black History Month.",
        "getPublicationDate": "2017-02-12T23:49:31+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/12/news/companies/nike-equality-lebron-serena/index.html?section=money_news_international"
    },
    {
        "title": "'Lego Batman' producer, then Treasury sec?",
        "link": "http://money.cnn.com/2017/02/12/media/lego-batman-movie-steven-mnuchin/index.html?section=money_news_international",
        "description": "Treasury secretary pick Steven Mnuchin is an executive producer on Warner Bros.' \"The Lego Batman Movie,\" which pulled in an estimated $55.6 million from U.S. audiences during its opening weekend.",
        "getPublicationDate": "2017-02-13T02:57:47+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/12/media/lego-batman-movie-steven-mnuchin/index.html?section=money_news_international"
    },
    {
        "title": "Are we heading for another Greek debt crisis?",
        "link": "http://money.cnn.com/2017/02/08/news/economy/greece-imf-bailout-eurozone/index.html?section=money_news_international",
        "description": "It may seem like a recurring nightmare, but Greece is in danger of running out of money again. ",
        "getPublicationDate": "2017-02-09T14:54:49+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/08/news/economy/greece-imf-bailout-eurozone/index.html?section=money_news_international"
    },
    {
        "title": "Verizon is bringing back unlimited data",
        "link": "http://money.cnn.com/2017/02/12/technology/verizon-unlimited-data-plan/index.html?section=money_news_international",
        "description": "Read full story for latest details.",
        "getPublicationDate": "2017-02-13T17:20:28+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/12/technology/verizon-unlimited-data-plan/index.html?section=money_news_international"
    },
    {
        "title": "Visa crackdown puts these rural doctors at risk ",
        "link": "http://money.cnn.com/2017/02/10/news/economy/visa-ban-rural-doctor-shortage/index.html?section=money_news_international",
        "description": "Read full story for latest details.",
        "getPublicationDate": "2017-02-11T05:02:55+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/10/news/economy/visa-ban-rural-doctor-shortage/index.html?section=money_news_international"
    },
    {
        "title": "Trump isn't killing the bull market. Here's why",
        "link": "http://money.cnn.com/2017/02/10/investing/stocks-united-states-trump-europe-china-japan/index.html?section=money_news_international",
        "description": "Read full story for latest details.",
        "getPublicationDate": "2017-02-10T20:55:17+04:00",
        "author": "",
        "thumbnails": "http://i.cnn.net/money/images/cnnmoney_logo_144x30.gif",
        "categories": [],
        "relatedIdentifiers": "http://money.cnn.com/2017/02/10/investing/stocks-united-states-trump-europe-china-japan/index.html?section=money_news_international"
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
