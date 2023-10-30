# rss-tracker-service
RSS/Atom feeds update tracker Rest API service project for Spring Boot

## Project Environment

- Java 21
- H2 database
- Spring Boot 3.1.5
- The Room Java Library 2.1.0

## Project Structure
- feature_name 
  - configuration
  - controller
  - dto
  - entity
  - job
  - mapper
  - repository
  - service

## Testing Rest API

1. Get list of stored resources faceted by given categories and date range (with query params) 
```
GET http://localhost:8080/tracker/api/v1/feeds/search?category=CORS&dateFrom=2010-04-27T04:30:45.123Z&dateTo=2023-10-30T22:30:45.123Z

RESPONSE BODY:
[
    {
        "title": "[VSM-VUX] Advanced Car Search Encuesta cerrada",
        "link": "https://hypothes.is/a/C2ocXndYEe6urZPTuzKYRA",
        "description": "<blockquote>¿Qué productos de crédito has usado?</blockquote>Falta el texto de aclaración que señale \"Selecciona todas las que apliquen\"",
        "getPublicationDate": "2023-10-30T23:10:52+04:00",
        "author": "camiamado",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:C2ocXndYEe6urZPTuzKYRA"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/40sYDndXEe6N0E8uiNJqmA",
        "description": "<blockquote>¡Personaliza tu suscripción!</blockquote>Cada mes puedes cambiar tu elección",
        "getPublicationDate": "2023-10-30T23:09:45+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:40sYDndXEe6N0E8uiNJqmA"
    },
    {
        "title": "https://docdrop.org/ocr/download/College-Education-article-ls3wm_ocr_force.pdf",
        "link": "https://hypothes.is/a/yPbzundXEe65v5MiiEFdGA",
        "description": "<blockquote>jobs. The trend is gathering steam at many high-profile businesses, notably tech firms . All this comes as college enrollment , with an assist from a tight job market and worries about student debt.</blockquote>I'm torn with the  two paragraphs I had highlighted. I understand some companies want to hire people without degrees, they may have the skills and knowledge to do the job but their pay will be less than someone who has a degree. Having a degree would help you get the job you're looking for. They would see your silks & pay level would be different, Lastly. I feel like these job applications should stop asking people what was their highest level of education that is discriminating a person intelligence. ",
        "getPublicationDate": "2023-10-30T23:09:01+04:00",
        "author": "Keniyah",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:yPbzundXEe65v5MiiEFdGA"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/qtrq2HdUEe6-cLcRvGtqlw",
        "description": "<blockquote>s</blockquote>**Nómada Aventurero\n**Drop edición limitada/Cata a ciegas / Drop temporada/ La selección del maestro cervecero\n$650 MXN \n6 cervezas edición limitada\n\n\n\n**La vieja confiable\n**Las de siempre $360 MXN\n6 cervezas de nuestros sabores base\n\n**Quiero probar suerte\n**Micha y micha\n6 cervezas de línea + 6 edición limitada\n\n\n\n\n",
        "getPublicationDate": "2023-10-30T22:46:42+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:qtrq2HdUEe6-cLcRvGtqlw"
    },
    {
        "title": "[VSM-VUX] Advanced Car Search Encuesta cerrada",
        "link": "https://hypothes.is/a/gq_Q6HdXEe6ipfvi1EcuuA",
        "description": "<blockquote>respondiendo</blockquote>al responder",
        "getPublicationDate": "2023-10-30T23:07:03+04:00",
        "author": "camiamado",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:gq_Q6HdXEe6ipfvi1EcuuA"
    },
    {
        "title": "Waters_etal2016.pdf",
        "link": "https://hypothes.is/a/dt34OndXEe6U3wNKFCzcrA",
        "description": "Hallucinating/dreaming states complete top-down process\n- sensory inputs are totally shut down\n- the brain is generating these representations\n- kinda crazy how you don't know what's gonna happen next, when it's your own brain generating",
        "getPublicationDate": "2023-10-30T23:06:43+04:00",
        "author": "Sydneylovro",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:dt34OndXEe6U3wNKFCzcrA"
    },
    {
        "title": "[VSM-VUX] Advanced Car Search Encuesta cerrada",
        "link": "https://hypothes.is/a/dkgZ-ndXEe626UczmQiXsg",
        "description": "<blockquote>a</blockquote>relacionada **con el**",
        "getPublicationDate": "2023-10-30T23:06:42+04:00",
        "author": "camiamado",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:dkgZ-ndXEe626UczmQiXsg"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/EnaM1ndXEe6Qc-cgME3WjA",
        "description": "<blockquote>la suscripción</blockquote>el paquete",
        "getPublicationDate": "2023-10-30T23:03:54+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:EnaM1ndXEe6Qc-cgME3WjA"
    },
    {
        "title": "Why Are People Still Using Asbestos?",
        "link": "https://hypothes.is/a/BSuu2ndXEe6StO-0lJXgqQ",
        "description": "I agree with your statement emphasizing the idea of utilizing something new opposed to a harmful substance. I think companies abuse the ideology that if a worker dies there's many more lined up to take the position the previous worker once had.",
        "getPublicationDate": "2023-10-30T23:03:32+04:00",
        "author": "colefarmer",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:BSuu2ndXEe6StO-0lJXgqQ"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/OFLuwHdUEe6iihMlByNkMg",
        "description": "<blockquote>Personalízala</blockquote>Arma tu cata",
        "getPublicationDate": "2023-10-30T22:43:30+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:OFLuwHdUEe6iihMlByNkMg"
    },
    {
        "title": "Fall Halemba: Justizmissbrauch und politische Verfolgung? - Ansage",
        "link": "https://hypothes.is/a/vTPaJndWEe62baesia9ynA",
        "description": "<blockquote>\n\n„Alle AfDler gehören in die Gaskammer.“ – Bianca Deubel (LINKE) am 25.12.2018\n\nEin Verfahren wegen Volksverhetzung wurde im November 2021 ohne Auflagen eingestellt, weil Bianca Deubel nicht vorbestraft war und man ihren Satz einfach so verstehen wollte, „dass ein Besuch einer KZ-Gedenkstätte aus pädagogischen Gründen nahegelegt wird.“\n\n„Ich freue mich schon, wenn ich auf ihrem Grab tanzen kann.“ – Bianca Deubel (LINKE) an Erika Steinbach am 25.12.2018\n\nFür diesen zur selben Zeit geschriebenen Satz brauchte man dann nicht einmal mehr nach pädagogischen Gründen zu suchen – der fiel einfach unter den Tisch.\n\nAuf so viel Verständnis sollte Daniel Halemba allerdings nicht hoffen – als AfDler hat er schließlich sein Menschsein verwirkt.\n\n„Die AfD besteht aus Menschen, die ihr Menschsein verwirkt haben.“ – Pianist Igor Levit am 01.11.2015\n\nSchließlich wird das von derselben Justiz, die Daniel Halemba verfolgt, bis heute nicht als Volksverhetzung gesehen.\n\n</blockquote>\n\naah, der \"gute\" hass, de juute hass, der hass von oben\n\nerinnert an die hetze gegen impfgegner (\"das sind volksschädlinge! wir brauchen impfzwang!\")  \noder an die hetze von israel gegen palästina (\"das sind tiere! wir brauchen bomben!\")  \noder an die hetze gegen visegrad-staaten (\"das sind nazis! die brauchen migranten!\")  \noder an die hetze gegen kiffer (\"das sind verrückte! die brauchen knast!\")\n\nsolche zitate sollte \"irgendwer\" sammeln, ähnlich wie https://www.afd.de/einzelfallticker/  \nandererseits: zeitverschwendung, wir haben besseres zu tun als zitate sammeln...\n\nhttps://www.pi-news.net/2021/02/bianca-deubel-alle-afdler-gehoeren-in-die-gaskammer/  \n\"Bomber Harris, do it again\" -- Antifa  \n\"Ich will Deutsche sterben sehen\" -- Sarah Rambatz  \n\"We love Volkstod\"  \n\"AFD ist ein Krebsgeschwür\" -- Elmar Brok, CDU  \n\"AFDler sind Gesindel\" -- Friedrich Merz, CDU  \n\"AFDler sind Pack\", \"AFD ist offen rassistische, völkische Gesellschaft\", \"AFDler sind rechtsradikale Menschenfeinde\", \"echte Nazis\" -- Sigmar Gabriel, SPD  \n\"AFDler sind Vulgär-Rassisten\", \"AFDler sind eine Bande von Zynikern und geistigen Brandstiftern\" -- Thomas Oppermann, SPD  \n\"AFDler sind giftiger Abschaum\" -- Marco Wanderwitz, CDU  \n\"AFDler sind die Mischpocke\" -- Cem Özdemir, Grüne, Moslem  \n\"AFDler gehört zurück in ihre Rattenlöcher\" -- Raed Saleh, SPD, Moslem  \n\"AFDler sind rechte Rattenfänger\" -- Markus Ulbig, CDU\n\"AFDler sind Untermenschen\", \"AFDler sind Ratten\" -- Matthias Zimmer, CDU  \n\"AFDler sollen am Galgen hängen\", \"CDUler sollen ins Gulag\" -- Jonas Stickelbroeck, Grüne Jugend  \n\"das eine Prozent der Reichen sollten wir erschießen\" -- Sandra Lust, Die Linke  \n\"ACAB\", \"All cops are bastards\" -- Antifa  \n\"Eat the rich\" -- Antifa  \n\"Black Lives Matter\"  \n\"Afrika den Afrikanern\"  \n\"Ungläubige Deutsche sind eine Köterrasse\"  \n(Vergewaltigung gegen Nicht-Moslems ist okay)  \n\"das Sterben vom deutschen Volk ist Volkssterben von seiner schönsten Seite\"  \n\nhttps://philosophia-perennis.com/2023/09/18/auf-dem-linken-auge-blind/  \n\"Vielleicht sollte man Sachsen einfach kontrolliert abbrennen lassen.\" -- Robert Schlick, die Grünen  \n\"Deutschland hat eine eklige weiße Mehrheitsgesellschaft.\" \"Wir sollten alle Weißen aus Afrika rausfegen.\" -- Sarah-Lee Heinrich, Grüne Jugend  \n\"Bald ist Schluss mit dem lustigen Leben als Weißbrot.\" \"Alle hoffen auf Besserung, auf ein Ende von Rassismus und Abschottungspolitik. Ich fürchte, dass das nicht kommt, solange Deutschland existiert. Das ist alles so verfestigt und in den regelhaften Strukturen fest verankert, das ist mit Reformen nicht zu lösen.\" -- Axel Steier, Flüchtlingshelfer\n\nhttps://www.unzensuriert.at/55273-allahu-akbar-die-stadt-gehoert-uns-radikale-islamisten-und-linksextreme-netzwerke-gegen-afd/  \n\"Die Stadt gehört uns\" -- Moslem zu AFDler  \n\"Bullen sind faschistoide Schweine\" -- Antifa  \n\"Kapitalismus muss zerstört werden\" -- Antifa\n\n\"Bildet Banden!\" -- Antifa\n\nhttps://ansage.org/die-pantisano-gesinnungsmafia-bruederliches-hetzen-gegen-heteros-und-afd/  \n\"Du Hetero-Sau!\" -- Alfonso Pantisano, Berlins Queer-Beauftragter  \n\"Mit AFDlern sollte man nicht reden.\" \"Wenn die AFD Mal irgendwas sinnvolles vorschlägt, sollten wir es ablehnen.\"  \"Keine Zustimmung für gar nichts was von der AfD kommt.\" \"Mit den Stimmen der AfD darfst Du niemals Politik betreiben, sonst machst Du Dich mitschuldig an ihrer rassistischen Politik.\" -- Luigi Pantisano, Die Linke, Antifa  \n\"Ich liebe und fördere den Volkstod.\" -- Christin Löchner, Die Linke, 20.01.2012  \n\"Enteignen ist hart, aber fair!\" -- Lucy Redler, Die Linke, 11.03.2018  \n\"Dazu ist … eine zentrale Unterbringung für Neonazis notwendig.\" -- Tobias Himpenmacher, Die Linke, 08.10.2018  \n\"Hinter jedem AfDler im Anzug kann ein Nazi mit Waffe stehen, der schießt.\" -- Katja Kipping, Die Linke, 25.08.2019  \n\"Man sollte die Diskussion beginnen über ein Verbot der AfD, juristisch und politisch.\" -- Martina Renner, Die Linke, 08.12.2022  \n\"Die AfD ist die Partei der Verrohung.\" -- Martin Schirdewan, Die Linke, 27.06.2023\n\naka: klassenjustiz, machtdemonstration, provokation, opfer auf rachefeldzug, chauvinismus, orthodoxie, pseudoobjektivismus, sklavenmoral  \nhttps://knowyourmeme.com/memes/our-blessed-homeland-their-barbarous-wastes\n",
        "getPublicationDate": "2023-10-30T23:01:31+04:00",
        "author": "milahu",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:vTPaJndWEe62baesia9ynA"
    },
    {
        "title": "Why Are People Still Using Asbestos?",
        "link": "https://hypothes.is/a/znzAuHdWEe6ScovREu2Ytg",
        "description": "<blockquote>But despite over 50 years of evidence that asbestos can kill, the material is still used around the world, even in the U.S., reports Nic Fleming for Mosaic.</blockquote>I am aware that asbestos is fatal and it is like microscopic needles that puncture and infect our lungs when we breathe in. What blows my mind is that knowing this information, it is still used across not only the world but the United States. In the United States, some of the most active workers unions unite to save workers from this and it is still around. I hope within my lifetime asbestos will not only be discontinued in the United States, but across the world because it is so harmful to the human body.",
        "getPublicationDate": "2023-10-30T23:02:00+04:00",
        "author": "colefarmer",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:znzAuHdWEe6ScovREu2Ytg"
    },
    {
        "title": "\"E-tivities from the Front Line”: A Community of Inquiry Case Study Analysis of Educators’ Blog Posts on the Topic of Designing and Delivering Online Learning",
        "link": "https://hypothes.is/a/zFE06ndWEe6t5fvKPy-zTw",
        "description": "Boa tarde colega! Concordo e revejo-me totalmente no seu comentário. Acho que todos ingressamos neste curso precisamente por sentir esta \"pressão\" e também a necessidade de adaptação às novas práticas pedagógicos em ambiente virtual. De facto, crescem a cada dia as ferramentas digitais que podemos usar para melhorar o processo ensino-aprendizagem e as que já tivemos contacto aqui no curso são muito interessantes e irei com certeza aplicá-las!\n\nElvira Vieira (aluno nº 2201790)",
        "getPublicationDate": "2023-10-30T23:01:57+04:00",
        "author": "ElviraVieira",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:zFE06ndWEe6t5fvKPy-zTw"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/wky0LndWEe6f2PPHXzxRJw",
        "description": "<blockquote>suscripción</blockquote>paquete recurrente. \n\nElige cuánto recibir al mes",
        "getPublicationDate": "2023-10-30T23:01:40+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:wky0LndWEe6f2PPHXzxRJw"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/CGq8fndUEe6eXU_LeIgLqQ",
        "description": "<blockquote>Selecciona la suscripción que más se adapte a tus gustos y preferencias</blockquote>¿Cuánto vas a beber? 6, 12, 18... Más vale prevenir/ Nómada prevenido vale por dos / ¿Cuántos puedes cargar? Recuerda que los límites están en tu mente.",
        "getPublicationDate": "2023-10-30T22:42:09+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:CGq8fndUEe6eXU_LeIgLqQ"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/yTjvlHdTEe6qK6cZaComWA",
        "description": "<blockquote>Lo hacemos sencillo para todos los amantes de la cerveza artesanal</blockquote>Elige, personaliza, recibe.\n*Chelas chidas sin complicaciones. * / Tus chelas sin complicaciones",
        "getPublicationDate": "2023-10-30T22:40:23+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:yTjvlHdTEe6qK6cZaComWA"
    },
    {
        "title": "Waters_etal2016.pdf",
        "link": "https://hypothes.is/a/maGNHHdAEe6JaAuFg-QgRQ",
        "description": "<blockquote>regions connected to the temporal and occipital cor-tices, acting to increase cortical signaling responsiblefor perceptual release</blockquote>What does perceptual \"release\" even mean?\nOr the \"release\" of sensory activity?\n\n- when you're sleeping you're experiencing things in the absence of any sensory input\n- and in this absence, another channel activates and essentially starts making things up",
        "getPublicationDate": "2023-10-30T20:23:03+04:00",
        "author": "Sydneylovro",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:maGNHHdAEe6JaAuFg-QgRQ"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/UjnDYndVEe66frsZlVnWYQ",
        "description": "<blockquote>Paquete Drop</blockquote>Nómada Aventurero",
        "getPublicationDate": "2023-10-30T22:51:22+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:UjnDYndVEe66frsZlVnWYQ"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/Pj3VsHdVEe6oREezVKufJQ",
        "description": "<blockquote>Tus gustos y preferencias o deja que nuestro maestro cervecero proponga nuevos sabores para ti</blockquote>tengo dudas de esto... ",
        "getPublicationDate": "2023-10-30T22:50:49+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:Pj3VsHdVEe6oREezVKufJQ"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/MxVn_HdVEe6-eoedh93ZIA",
        "description": "<blockquote>Ya sea la vieja confiable de lo que ya has probado, probar nuestras ediciones limitadas o ¿por qué no ambas?</blockquote>Si ya conoces tus gustos, o si quieres probar cosas nueva, esta suscripción es para los verdaderos amantes de la cerveza artesanal.",
        "getPublicationDate": "2023-10-30T22:50:30+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:MxVn_HdVEe6-eoedh93ZIA"
    }
]
```

2. Get list of stored resources faceted by given categories and date range (with the search body)
``` 
POST http://localhost:8080/tracker/api/v1/feeds/search

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
