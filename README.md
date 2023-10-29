# rss-tracker-service
RSS/Atom feeds update tracker Rest API service project for Spring Boot


## Testing Rest API

1. Get list of stored resources faceted by given categories and date range
``` 
POST http://localhost:8080/feeds/search

REQUEST BODY:
    {
      "categories" : ["Java"],
      "dateFrom" : "2020-04-27T04:30:45.123Z",
      "dateTo" : "2023-10-27T22:30:45.123Z"
    }
    
RESPONSE BODY:
[
    {
        "title": "Bankman-Fried says he worried his company's management team 'might not be great'",
        "link": "https://www.cnn.com/business/live-news/sbf-testimony-before-jurors-ftx-fraud-trial/index.html",
        "description": "Sam Bankman-Fried took the witness stand Friday for the first time in front of jurors in his criminal fraud trial. Bankman-Fried, 31, has pleaded not guilty to seven counts of federal fraud and conspiracy."
    },
    {
        "title": "At age 13, he was an avid volunteer who wanted to be a pastor and an engineer. A stranger's bullets destroyed those dreams",
        "link": "https://www.cnn.com/2023/10/27/us/deshon-dubose-us-gun-deaths-gdpr/index.html",
        "description": "The dust on Charles DuBose's motorcycle belies his meticulous care of his prized Harley Davidson. But he refuses to disturb the handprints pressed in the dust. They belong to his grandson Deshon, who loved riding on the back seat and couldn't wait until he was old enough to drive."
    },
    {
        "title": "Sam Bankman-Fried takes the stand in his fraud trial",
        "link": "https://www.cnn.com/business/live-news/ftx-sam-bankman-fried-testimony-fraud-trial/index.html",
        "description": "Lawyers for 31-year-old former billionaire and FTX founder Sam Bankman-Fried started to present their case Thursday in federal court in Manhattan."
    },
    {
        "title": "GM self-driving car subsidiary withheld video of a crash, California DMV says",
        "link": "https://www.cnn.com/2023/10/24/business/california-dmv-cruise-permit-revoke/index.html",
        "description": "The California Department of Motor Vehicles Tuesday revoked Cruise's permits to test and operate fully driverless vehicles on the state's roads. The California DMV said, in part, it was because Cruise, which is GM's self-driving vehicle technology subsidiary, withheld video and information about a crash involving a pedestrian."
    },
    {
        "title": "The three-year cruise is running late -- again",
        "link": "https://www.cnn.com/travel/article/three-year-cruise-latest-update/index.html",
        "description": "Life at Sea's three-year cruise is still struggling to get afloat, with a new departure date rumored to be November 30. Passengers have been told not to book travel until they receive further updates."
    },
    {
        "title": "October 26, 2023 Israel-Hamas war news",
        "link": "https://www.cnn.com/middleeast/live-news/israel-hamas-war-gaza-news-10-26-23/index.html",
        "description": "Israel's military said it carried out a \"targeted raid\" overnight in northern Gaza using tanks. The move came hours after Benjamin Netanyahu said Israel was preparing for a ground operation following the deadly October 7 Hamas attacks. Follow here for live news updates."
    },
    {
        "title": "October 25, 2023 - Lewiston, Maine mass shootings",
        "link": "https://www.cnn.com/us/live-news/lewiston-maine-shootings-active-shooter-10-25-23/index.html",
        "description": "A manhunt is underway after a shooting rampage occurred in Lewiston, Maine, on Wednesday night, according to multiple law enforcement sources. Follow here for live news updates."
    },
    {
        "title": "Today's news in 10 minutes",
        "link": "https://www.cnn.com/2023/10/26/cnn10/ten-content-fri/index.html",
        "description": "October 27, 2023"
    },
    {
        "title": "Redistricting fights in these 10 states could determine which party controls the US House",
        "link": "https://www.cnn.com/2023/10/22/politics/redistricting-states-maps-house-control/index.html",
        "description": "Around the country, politicians are waging high-stakes battles over new congressional lines that could influence which party controls the US House of Representatives after the 2024 election."
    },
    {
        "title": "Britney Spears Fast Facts",
        "link": "https://www.cnn.com/2013/06/27/us/britney-spears-fast-facts/index.html",
        "description": "Read CNN's Britney Spears Fast Facts to learn about the pop singer and Grammy award winner."
    },
    {
        "title": "David Petraeus Fast Facts",
        "link": "https://www.cnn.com/2013/03/01/us/david-petraeus-fast-facts/index.html",
        "description": "Read CNN's Fast Facts for a look at the life of David Petraeus, former director of the Central Intelligence Agency (CIA)."
    },
    {
        "title": "Bob Graham Fast Facts",
        "link": "https://www.cnn.com/2013/08/20/us/bob-graham-fast-facts/index.html",
        "description": "Read CNN's Fast Facts about Bob Graham, former United States senator and Democratic governor of Florida."
    },
    {
        "title": "Here's what we know about the suspect in the Maine mass shooting",
        "link": "https://www.cnn.com/2023/10/26/us/maine-shooting-suspect-invs/index.html",
        "description": "The suspect in the Maine mass shooting started making statements about hearing voices and wanting to hurt fellow soldiers while serving at a military base this summer, and spent a few weeks in a hospital, law enforcement officials told CNN."
    },
    {
        "title": "Jonathan Majors' accuser arrested in New York, won't be prosecuted",
        "link": "https://www.cnn.com/2023/10/26/entertainment/jonathan-majors-accuser-incident-new-york-grace-jabbari-arrested/index.html",
        "description": "The woman who accused actor Jonathan Majors of assaulting her during a dispute in March was arrested Wednesday night on suspicion of assault and criminal mischief related to the same incident, according to a source with knowledge of the matter."
    },
    {
        "title": "The New York Times walks back flawed Gaza hospital coverage, but other media outlets remain silent",
        "link": "https://www.cnn.com/2023/10/24/media/gaza-hospital-coverage-walk-back/index.html",
        "description": "Most news organizations seem eager to sweep last week's negligent coverage of the Gaza hospital explosion under the rug, moving on from the low moment covering the Israel-Hamas war without admitting any mistakes."
    },
    {
        "title": "How US gun culture stacks up with the world",
        "link": "https://www.cnn.com/2021/11/26/world/us-gun-culture-world-comparison-intl-cmd/index.html",
        "description": "Ubiquitous gun violence in the US has left few places unscathed over the decades. As the tally of gun-related deaths continue to grow daily, here's a look at how American gun culture compares to the rest of the world."
    },
    {
        "title": "Visualizing how mass shootings in 2023 compare to the last decade",
        "link": "https://www.cnn.com/2023/01/24/us/how-many-mass-shootings-2023-dg-xpn/index.html",
        "description": "There have been more mass shootings than days so far this year. Here's how 2023 compares to the past decade."
    },
    {
        "title": "'Harry Potter' and 'Downton Abbey' star Maggie Smith, 88, is the face of Loewe's new campaign",
        "link": "https://www.cnn.com/style/article/maggie-smith-loewe-fashion-campaign-intl-scli/index.html",
        "description": "Dame Maggie Smith, the British actress acclaimed for her appearances both on stage and in cinema, has taken on a new role —  and this time it's in the world of luxury fashion."
    },
    {
        "title": "This middle-schooler 'knew how to be a best friend to everybody.' Then gunfire erupted while she was out to buy milk",
        "link": "https://www.cnn.com/2023/10/26/us/brexialee-torres-ortiz-us-gun-deaths-gdpr/index.html",
        "description": "It's been almost nine months since Brexi Torres-Ortiz and her mom sang together -- hitting every note, feeling every emotion with every word of a gospel tune that happened to be the 11-year-old's favorite song."
    },
    {
        "title": "UN says fuel shortages will halt Gaza aid operations within a day",
        "link": "https://www.cnn.com/2023/10/25/middleeast/israel-hamas-gaza-war-wednesday-intl-hnk/index.html",
        "description": "The main United Nations agency in Gaza says it will have to halt aid operations within a day if fuel is not delivered, in what the organization says would mark the end of a \"lifeline\" for civilians."
    },
    {
        "title": "October 25, 2023 Israel-Hamas war news",
        "link": "https://www.cnn.com/middleeast/live-news/israel-hamas-war-gaza-palestine-10-25-23/index.html",
        "description": "The main UN agency working in Gaza said it will be forced to halt its operations later Wednesday due to a lack of fuel, exacerbating a grave humanitarian crisis. Follow here for live news updates."
    }
]
```
# Questions:

1. Fields
2. Entities relational or simple structure
3. Rest APi endpoints 
4. Estimations
5. ETC....
   https://en.wikipedia.org/wiki/RSS
