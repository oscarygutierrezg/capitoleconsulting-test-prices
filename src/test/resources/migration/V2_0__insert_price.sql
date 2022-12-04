INSERT  INTO price(
  PRICE_LIST,
   BRAND_ID  ,
   PRODUCT_ID ,
   PRIORITY ,
   START_DATE ,
   END_DATE ,
   CURR ,
   PRICE
) VALUES (
1,
1,
35455,
0,
PARSEDATETIME('2020-06-14-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'),
'EUR',
35.50
);

INSERT INTO price(
  PRICE_LIST,
  BRAND_ID  ,
   PRODUCT_ID ,
   PRIORITY ,
   START_DATE ,
   END_DATE ,
   CURR ,
   PRICE
) VALUES (
2,
1,
35455,
1,
PARSEDATETIME('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'),
PARSEDATETIME('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'),
'EUR',
25.45
);

INSERT INTO price(
  PRICE_LIST,
  BRAND_ID  ,
   PRODUCT_ID ,
   PRIORITY ,
   START_DATE ,
   END_DATE ,
   CURR ,
   PRICE
) VALUES (
3,
1,
35455,
1,
PARSEDATETIME('2020-06-15-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
PARSEDATETIME('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'),
'EUR',
30.50
);

INSERT  INTO price (
  PRICE_LIST,
  BRAND_ID  ,
   PRODUCT_ID ,
   PRIORITY ,
   START_DATE ,
   END_DATE ,
   CURR ,
   PRICE
) VALUES (
4,
1,
35455,
1,
PARSEDATETIME('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'),
PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'),
'EUR',
38.95
);