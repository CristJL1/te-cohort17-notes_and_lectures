-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- Frank suggests making the entire exercise one transaction
-- because several exercises depend on previous exercises running
-- if you try to make smaller transactions, Frank says you will drive yourself nuts
-- put a begin transaction at the start and a rollback at the end until you are sure everything works
-- ignore #12 until tomorrow...if you can't look at the end of today's lecture code
-- consider running verify selects before and/or after your inserts, update, deletes
-- your changes will NOT be in the table if you do a rollback

-- be sure you know what the data types and contents of the columns are
-- consider that some columns are generated by the database on insert (you don't need or want to specify them, but you may need to know what they are)
-- use subqueries

-- 

begin transaction;

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

--select first_name, last_name
--from actor
--where first_name = 'Hampton'
--or first_name = 'Lisa';

insert into actor (first_name, last_name)
values ('Hampton', 'Avenue');

insert into actor (first_name, last_name)
values ('Lisa', 'Byway');

--select first_name, last_name
--from actor
--where first_name = 'Hampton'
--or first_name = 'Lisa';

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

select * from film where title ='Euclidean PI';

insert into film (title, release_year, language_id, original_language_id, length)
values ('Euclidean PI', 2008, (select language_id from language where name = 'English'), (select language_id from language where name = 'English'), 198);

select * from film where title ='Euclidean PI';


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

-- 4. Add Mathmagical to the category table.

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

-- 7. Add a copy of "Euclidean PI" to all the stores.

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.


rollback;