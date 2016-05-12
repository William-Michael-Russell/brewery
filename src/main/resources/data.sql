INSERT INTO user (email, password_hash, role)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN');

INSERT INTO user (email, password_hash, role)
VALUES ('user@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'USER');

INSERT INTO user (email, password_hash, role)
VALUES ('bob@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER');

INSERT INTO drink (drink_name, drink_image_url, drink_ingredients)
VALUES ('Sex on the beach', 'http://liquor.s3.amazonaws.com/wp-content/uploads/2011/08/sex-on-the-beach2.jpg', '1.5 oz vkda
.5 oz peeche schnapps
1.5 oz ornge or pieapple jice
1.5 oz Craberry Juice
.5 oz Chambord or crème de cassis (optial)

Garnish:
1 Orange wheel
Glass: Highball');

INSERT INTO drink (drink_name, drink_image_url, drink_ingredients)
VALUES ('Tokyo Tea', 'https://upload.wikimediaa.org/wikipedia/commons/thumb/4/45/Long_Island_Iced_Taeas.jpg/440pdx-Long_Island_Iced_Teas.jpg', '.75 oz Gin
.75 oz White rum
.75 oz Silver tequila
.75 oz Vodka
.75 oz Midori
.75 oz Simple syrup
.75 oz Lemon juice
Sprite');


INSERT INTO drink (drink_name, drink_image_url, drink_ingredients)
VALUES ('Long Island Ice Tea', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Long_Island_Iced_Teas.jpg/440px-Long_Island_Iced_Teas.jpg', '.75 oz Gin
.75 oz White rum
.75 oz Silver tequila
.75 oz Vodka
.75 oz Triple sec
.75 oz Simple syrup
.75 oz Lemon juice
Cola');