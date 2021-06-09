-- Keys, Joins and Unions
--
-- Primary Key - a column or set of columns that uniquely identify a row in a table (Parent table)
-- Foreigh Key - a column or set of columns that match the primary key of another table (Dependent table)
--
-- foreign keys and primary keys are typically used in join conditions between the tables
-- a join matches rows between tables, so primary key, foreign key are obviously good to use in a join condition
--
-- Natural Key - Value(s) that exist for a table that can be used as primary keys
-- Surrogate Key - Artificially generated keys to use as a primary key
--
--  Joins are used when columns from multiple tables are required in a query
--
-- INNER JOIN - Matching rows between tables 
--
-- LEFT JOIN - difference between tables, waht's in one table, but not the other
-- 
-- OUTER JOIN - All rows from both tables - the full set      
------------------------------------------------------------------------------------------------
-- Inner Join syntax - 2 forms
-- 
--  SELECT columns
--    FROM table1, table2  
--  WHERE table1.column = table2.column  
--
-- If you omit join conditions the result is Cartersian Product
--    each from one table with each row in the other - IT'S NOT A JOIN
--
-- minimum # conditions on WHERE = # tables - 1
--
--  SELECT columns
--    FROM table1
--         INNER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- -- OUTER JOIN syntax 
--
--  SELECT columns
--    FROM table1
--         FULL OUTER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- UNION - Merging rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
--
-- UNION All - Concatenating rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION ALL
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
-- ********* INNER JOIN ***********

-- Show the last_name of all the actors in the movie FINDING ANACONDA
--
-- need data from the actor table (last_name) and the film table (title)
-- since I need data from more than one table - it's a join
-- I need to match data from the actor table to the film table - a match means INNER JOIN
-- what matches between the actor table and the film table
-- since nothing matches between the tables, can I use another table to connect them? yes - film_actor table
-- we need to connect three tables (film, actor, film_actor) to get the information we need - 2 joins

select last_name -- column(s) we want to see in the result
from film        -- connect the film table
inner join film_actor -- to the film_actor table
on film_actor.film_id = film.film_id -- based on the film.id in both (join condition - what matches)
inner join actor -- then connect the result
on film_actor.actor_id = actor.actor_id -- to the actor table
where title = 'FINDING ANACONDA'; -- only for the film titled FINDING ANACONDA

-- a nickname (correlation name or alias) may be assigned to the tables to make coding easier
-- code nickname after the table name where you code it
-- use the nickname/alias in place of the table name in the query

select last_name -- column(s) we want to see in the result
from film f       -- connect the film table (nicknamed 'f')
join film_actor fa -- to the film_actor table (nicknamed 'fa')
on fa.film_id = f.film_id -- based on the film.id in both (join condition - what matches)
join actor a -- then connect the result to the actor table (nicknamed 'a')
on fa.actor_id = a.actor_id -- to the actor table
where title = 'FINDING ANACONDA'; -- only for the film titled FINDING ANACONDA




-- Let's find out who made payment 16666:

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.

-- What did they rent? Film id can be gotten through inventory.

-- What if we wanted to know who acted in that film?

-- What if we wanted a list of all the films and their categories ordered by film title
-- title from film table
-- category from  category table
-- there are multiple tables so that's a join
-- what matches between film and category? nothing
-- is there another table we can use to connect them? yes, film_category

select title, name -- I want the title of the film and the name of the category it is in
from film          -- connect the film table
inner join film_category -- to the film_category table
on film.film_id = film_category.film_id -- based on their film_ids
inner join category -- then connect the result to the category table
on film_category.category_id = category.category_id -- based on their category_ids
order by title; -- sequence the resuls by film title


-- Show all the 'Comedy' films ordered by film title

-- Finally, let's count the number of films under each category

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.

-- Only 232 rows
-- But we’re missing entries:

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
