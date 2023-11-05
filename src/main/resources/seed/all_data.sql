-- Seed feed configuration table
INSERT INTO feed_configuration (id, domain, ingestion_enable)
VALUES (1, 'https://hypothes.is/stream.rss', false);

INSERT INTO feed_configuration (id, domain, ingestion_enable)
VALUES (2, 'https://feeds.bbci.co.uk/news/science_and_environment/rss.xml', false);

INSERT INTO feed_configuration (id, domain, ingestion_enable)
VALUES (3, 'https://www.feedotter.com/blog/category/best-practices/feed/', true);

INSERT INTO feed_configuration (id, domain, ingestion_enable)
VALUES (4, 'https://feeds.bbci.co.uk/news/rss.xml', false);

-- Seed feed entity table
INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (1,
        'Andy Theimer',
        'In today&#8217;s digital landscape, where content is abundant and attention spans are fleeting, promoting your blog posts effectively is more critical than ever. Neglecting email marketing as a means of distributing your blog content can have severe consequences. In this article, we&#8217;ll explore the dangers of overlooking email promotion in 2023, backed by data and [&#8230;]',
        'https://www.feedotter.com/blog/dangers-of-not-emailing-blog-posts-in-2023/?utm_source=rss&utm_medium=rss&utm_campaign=dangers-of-not-emailing-blog-posts-in-2023',
        '2023-08-01 08:08:45.000000 +00:00',
        'https://www.feedotter.com/?p=27751',
        'entry.getSource().getIcon().getUrl()',
        'Dangers of Not Emailing Your Blog Posts in 2023');

INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (2,
        'Andy Theimer',
        'Ever wondered what the Recipient Time Zone option below your Marketo scheduler was for? Anytime you&#8217;re sending marketing emails to your recipients, a big question can be the best time to send this email you&#8217;ve carefully curated. You can always find blog posts and research on the optimal time to send your emails for the [&#8230;]',
        'https://www.feedotter.com/blog/recipient-time-zones-marketo-emails/?utm_source=rss&utm_medium=rss&utm_campaign=recipient-time-zones-marketo-emails',
        '2023-02-23 19:40:56.000000 +00:00',
        'https://www.feedotter.com/?p=27586',
        'entry.getSource().getIcon().getUrl()',
        'Easy steps for using recipient time zones in Marketo emails');

INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (3,
        'Andy Theimer',
        'It&#8217;s 2023, should businesses send regular blog emails to their subscribers?  I wanted to know how marketers truly viewed the topic of emailing blog posts in the modern marketing era so I spent the past month interviewing more than 20 marketing experts to find out how they perceive emailing blog posts in the year 2023. [&#8230;]',
        'https://www.feedotter.com/blog/emailing-blog-posts-in-2023/?utm_source=rss&utm_medium=rss&utm_campaign=emailing-blog-posts-in-2023',
        '2023-02-10 03:00:43.000000 +00:00',
        'https://www.feedotter.com/?p=20719',
        'entry.getSource().getIcon().getUrl()',
        'Emailing Blog Posts in 2023 – What Do Marketers Think?');

INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (4,
        'Andy Theimer',
        'FeedOtter has some exciting new UI changes to the Automated campaigns area. While sending is the same and your existing campaigns will continue to run according to their normal schedules, the Edit Campaign screen has been updated and rearranged for easier access to certain features and to optimize user flow. Let&#8217;s walk through what&#8217;s changing: 1. Templates [&#8230;]',
        'https://www.feedotter.com/blog/new-ui-updates-walkthrough/?utm_source=rss&utm_medium=rss&utm_campaign=new-ui-updates-walkthrough',
        '2022-09-07 13:39:25.000000 +00:00',
        'https://www.feedotter.com/?p=26851',
        'entry.getSource().getIcon().getUrl()',
        'New UI Walkthrough: Updates for a Better, Easy to Use Interface');

INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (5,
        'Andy Theimer',
        'Here at FeedOtter, something that&#8217;s usually on our minds is how to streamline the process of creating routine, content emails and newsletters that you can easily push to your email sending platform. And what better way to automate content emails than adding an RSS feed into Pardot? Let&#8217;s look at the need for an RSS [&#8230;]',
        'https://www.feedotter.com/blog/rss-feed-into-pardot/?utm_source=rss&utm_medium=rss&utm_campaign=rss-feed-into-pardot',
        '2023-02-23 19:40:56.000000 +00:00',
        'https://www.feedotter.com/?p=25502',
        'entry.getSource().getIcon().getUrl()',
        '3 Useful Ways You Can Create Email Content By Integrating an RSS Feed Into Pardot');

INSERT INTO feed_entity (id, author, description, link, publication_date, related_identifiers, thumbnails, title)
VALUES (6,
        'Andy Theimer',
        'Working with email automation and customers sending website content to their subscribers, we see lots of questions about high unsubscribe rates and what our best tips for reducing unsubscribes on routine content emails are. Gaining lead subscribers is one thing, keeping them can be just as difficult for marketers.  Reducing Unsubscribes The first step to [&#8230;]',
        'https://www.feedotter.com/blog/reducing-unsubscribes-on-content-emails/?utm_source=rss&utm_medium=rss&utm_campaign=reducing-unsubscribes-on-content-emails',
        '2022-02-07 17:34:51.000000 +00:00',
        'https://www.feedotter.com/?p=25458',
        'entry.getSource().getIcon().getUrl()',
        '3 Easy Tips for Reducing Unsubscribes on Content Emails');

-- Seed Feed Entity Categories table
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (1, 'best practices');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (1, 'marketing automation');

INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (2, 'best practices');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (2, 'email marketing');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (2, 'Marketo');

INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (3, 'B2B Resources');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (3, 'company blog');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (3, 'content marketing');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (3, 'Featured');

INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (4, 'company blog');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (4, 'best practices');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (4, 'Product Features');

INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'pardot');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'B2B Resources');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'best practices');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'company blog');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'how to');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'Blog');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'digest');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'newletter');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'podcasts');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'RSS');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'RSS feed');

INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'email marketing');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'B2B Resources');
INSERT INTO feed_entity_categories(feed_entity_id, categories)
VALUES (5, 'best practices');

