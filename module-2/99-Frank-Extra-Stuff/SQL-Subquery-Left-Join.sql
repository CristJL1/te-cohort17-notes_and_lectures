--
-- Subquery Example -----------------------------------------------------------------------------------------------
--
-- a subquery is using a select to retrive from one table to satisfy a where clause to select
--
-- looking up calues in a table to substiture in a WHERE clause predicate
--
-- usually a subquery is used with the WHERE IN clause - a subquery may return a list of values (one column and multiple rows)
--
-- a subquery may be used with a WHERE = != > < if you are absolutely sure the subquery will only return one value
--
-- it is safer to use an IN (rather than an =) with a subquery because it always works
--
-- you can nest up to 32,766 subqueries (more than you will ever need)
--
-- the subquery is run first and then the result is plugged into the where clause
--
-- Show the names of the countries that speak English
-- be sure you are in the world database when you run this query
--
-- the name of the country is in the country table
-- the country codes of countries that speak English is in the countrylanguage table
--
-- 1. get a list of the countycodes that speak English from the countrylanguage table
-- 2. take the list from step 1 and use it to search the country table to get the name of the country

--select name
--from country
--inner join countrylanguage
--on country.code = countrylanguage.countrycode
--where language ='English';

select name
from country
where code in(select countrycode from countrylanguage where language = 'English');







-- this query needs the dvdstore database

--
-- Show any actors we have in the actor table who are not in any films
-- in the film table (ie. no entry in the film_actor table)

--
-- 1. Add some test data to the actor table we know do not
--    have matches in the film_actor table;

Begin transaction; -- start a recoverable unit of work - want to be able to save or undo changes

insert into actor (first_name, last_name) values('Agnes', 'Alexander');
insert into actor (first_name, last_name) values('Amber', 'Anthony');
insert into actor (first_name, last_name) values('Dana', 'Brian');
insert into actor (first_name, last_name) values('Aidan', 'Patrick');
insert into actor (first_name, last_name) values('Jared', 'Daniel');
insert into actor (first_name, last_name) values('Jess', 'Jared');
insert into actor (first_name, last_name) values('Josh', 'Lindsay');
insert into actor (first_name, last_name) values('Nia', 'Vanese');
insert into actor (first_name, last_name) values('Ruben', 'Java');
insert into actor (first_name, last_name) values('John', 'Frank');
insert into actor (first_name, last_name) values('Joiny', 'McJoinJoin');


--
--  2a. Problem solved with sub-query
--
-- who is in the actor table that is not in the film_actor table?
--
-- actors in the file_)actor table are identified by actor_id
-- actors in the actor table are identified by actor_id
--
-- which actor_ids are in the actor table but not in the film_actor table?
--
-- we don't know the actual actor_ids for any of the actors
-- we have to look in the actor table to find the actor_ids for the actors 
--      and then see if they are not in the film_actor table
--
-- this is a job for a subquery. to get the list of actor_ids from actor table
-- and find which actor_ids are not in the film_actor  table

select actor_id
from actor
where actor_id not in (select actor_id
from film_actor);



--
-- 2b. Problem solved with left-join actor table to file_actor table
--
select actor.actor_id, first_name, last_name
from actor
left join film_actor
on actor.actor_id = film_actor.actor_id
where film_actor.actor_id is null;



--
-- 3. Reset table to original state before test data inserted
--
rollback; -- undo any changes made since the start of the unit of work - undo the inserts done before my test