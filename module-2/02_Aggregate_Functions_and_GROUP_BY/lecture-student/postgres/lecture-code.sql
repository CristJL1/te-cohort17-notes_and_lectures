--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- the order of rows in a result is unpredictable unless you code an ORDER BY
-- you can run the same SELECT without an ORDER BY 1000 times and get resulsts in the same order each time
-- but there is no guarantee the order will be the same the 10001st time
--
-- IF YOU CARE ABOUT THE ORDER OF THE ROWS IN A RESULT CODE AN ORDER BY
--
-- ORDER BY is always coded last in standard SQL
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- Show Populations of all countries in acscending order

select name, population -- columns to include in the result
from country -- table with the columns to include in the results
order by population asc; -- see the cilmns in the result in ascending population order

select name, population -- columns to include in the result
from country -- table with the columns to include in the results
order by population; -- see the columns in the result in ascending population order - ASC is assumed


-- Show Populations of all countries in descending order

select name, population -- columns to include in the result
from country -- table with the columns to include in the results
order by population desc; -- see the columns in the result in descending population order


-- Show  the names of countries and continents in ascending order

select name, continent -- alphabeticaly by continent and name
from country
order by continent, name;

select name, continent -- alphabetical by country
from country
order by name, continent;

select name, continent -- alphabeticaly by continent and reverse alphabetical by name
from country
order by continent, name desc;

select name, continent -- reverse alphabeticaly by continent and reverse alphabeticaly by name
from country
order by continent desc, name desc;


-- show populations of all countries in ascending order only if population is greater than 1 million
-- include the name of the country
select name, population
from country
where population > 1000000
order by population;

-- show populations of all countries in ascending order only if population is between 1 million and 100 million
-- include the name of the country
select name, population
from country
where population >= 1000000
and population <= 10000000
order by population;

select name, population
from country
where population between 1000000 and 10000000 -- between will let you check a range
order by population;


---- only show for countries whose name starts between "E" and "T"
--select name, population
--from country
--where population between 1000000 and 10000000 -- between will let you check a range
--and name like 'E%'
--order by population;

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT - even after ORDER BY
--
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.

select name, lifeexpectancy
from country
where lifeexpectancy is not null
order by lifeexpectancy desc
limit 10;


--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city

select name || ', ' || district as city_comma_state -- concatenate the city name and a comma-space and district for my column
from city
where district = 'California'
or district = 'Oregon'
or district = 'Washington'
order by district, name;

select name || ', ' || district as city_comma_state -- concatenate the city name and a comma-space and district for my column
from city
where district in ('California', 'Oregon', 'Washington') -- in is an alternative to a series of =/or conditions
order by district, name;



--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--                              rather than one row in the result for each row that satisfies the WHERE clause
--
-- aggregate functions are used to produce a single value from a group of rows in a result
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
-- if the requirement says "number of", that uses COUNT(*)
-- if the requirement says "number of without nulls" in a column, that uses COUNT(column-name)
-- if requirement says "largest/biggest", that uses a MAX() or ORDER BY desc and LIMIT 1
-- if requirement says "smallest/least", that uses a MIN() or ORDER BY asc and LIMIT 1
-- if requirement says "average", that uses AVG()
-- if requirement says "total or sum", that uses SUM()
-- if the requirement says "for each" or "by each", that uses GROUP BY
--
-- AVG(), SUM() may only bes used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world

select lifeexpectancy -- show me the life expectancy
from country;         -- of each country - one row in the result for every country in the table (239)

select avg(lifeexpectancy) -- show me the life expectancy
from country;         -- of all countries - one row in the result regardless of the number of countries

-- ONLY columns used in the GROUP BY are allowed to be included on the SELECT
select continent, avg(lifeexpectancy) -- a column used in the GROUP BY may be coded on the select
from country
group by continent;        --perform the aggrgate function for each unique continent - one row in result for each continent

select continent, avg(lifeexpectancy) -- a column used in the GROUP BY may be coded on the select
from country
group by continent
order by continent;



-- Show the total and average population in Ohio - include name of the state

select district, sum(population) as total_population_of_ohio, avg(population) as average_population_of_ohio
from city
where district = 'Ohio'
group by district;


-- Show the surface area of the smallest country in the world

select name, surfacearea
from country
order by surfacearea
limit 1;

select name, min(surfacearea)
from country
group by name
order by min(surfacearea) asc
limit 1;


-- Show The 10 largest countries (by surface area) in the world

select name, surfacearea
from country
order by surfacearea desc
limit 10;

select name, surfacearea
from country
order by 2 desc -- order by column 2 in the SELECT - used for derived columsn without names
limit 10;

select name, max(surfacearea)
from country
group by name, surfacearea
order by surfacearea desc
limit 10;


-- Show the number of countries who declared independence in 1991

select count(*) -- count(*) is the number of rows in the result
from country
where indepyear = 1991; -- limit result to rows with indepyear of 1991


--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least



-- Show the average life expectancy of each continent ordered from highest to lowest



-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name



-- What is the average population of cities in each state in the USA ordered by state name


--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;