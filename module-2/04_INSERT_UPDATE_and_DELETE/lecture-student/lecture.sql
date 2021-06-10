---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--
-- you MUST provide values for all non-null columns, columns that the datebase doesn't generate
--
-- the database generates values for columns:
--        serial data types casuse the data base managetr to generate the next integer in a sequence to ensure uniqueness
--              used for primary keys a lot
--
--        if a column is assigned  a default value it will be used by the database manager
--              if a value is not provided on an INSERT
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA
begin transaction; -- start a unit of work for the insert so we can decide to commit or rollback

insert into countrylanguage (countrycode, language, isofficial, percentage)
values('USA', 'Klingon', false, 1);

-- verify that the insert worked
select * from countrylanguage where language ='Klingon';

rollback; -- undo the insert until we are sure it worked

-- 2. Add Klingon as a spoken language in Great Britain
-- we need the country code for Great Britain - it's United Kingdom in the country table

begin transaction; -- start a unit of work for the insert so we can decide to commit or rollback

insert into countrylanguage (countrycode, language, isofficial, percentage)
values('GBR', 'Klingon', true, 34);

-- verify that the insert worked
select * from countrylanguage where language ='Klingon';

rollback;

-- use subquery to getcountrycode

begin transaction; -- start a unit of work for the insert so we can decide to commit or rollback

insert into countrylanguage (countrycode, language, isofficial, percentage)
values((select code from country where name = 'United Kingdom'), 'Klingon', true, 34);

-- verify that the insert worked
select * from countrylanguage where language ='Klingon';

rollback;


-- UPDATE

-- 1. Update the capital of the USA to Houston
-- the capital is an int in country representing the id in the city table for the city
-- we need to find the city id in the city table for Houston and use it to update the country table
begin transaction;

-- display current value
select capital as Before_Update
from country 
where code = 'USA';

update country
set capital = (select id from city where name ='Houston')
where code = 'USA';

-- verify that update worked
select capital as After_Update
from country 
where code = 'USA';

rollback;

-- 2. Update the capital of the USA to Cleveland and the head of state

begin transaction;

-- display current value
select capital, headofstate
from country 
where code = 'USA';

update country
set capital = (select id from city where name ='Cleveland'),
headofstate = 'Frank Fella'
where code = 'USA';

-- verify that update worked
select capital, headofstate
from country 
where code = 'USA';

rollback;


-- DELETE

-- 1. Delete English as a spoken language in the USA

begin transaction;

-- check values before update
select *
from countrylanguage
where countrycode = 'USA';

delete from countrylanguage
where countrycode = 'USA'
and language = 'English';

-- verify that delete worked
select *
from countrylanguage
where countrycode = 'USA';

-- undo anychange until we verify it did what we wanted it to
rollback;

-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
