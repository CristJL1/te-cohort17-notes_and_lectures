--
-- Frank's JOIN lecture code
--
-- this SQL uses the world database - be sure you run it in the world database
--
-- show the country name, city name, and district for all the cities
--
-- we need data from country table (country name) and city table (city name and district)
--
-- if column names are not unique between the tables, put the tablename. in front of the column name
--
-- the join condition is what matches between the tables
--
-- there are two formats for coding a join:
--
--      1 classic syntax - code all tables for the join on the FROM and the join condition on the WHERE
                                -- only an INNER JOIN may be done
                                -- works if you forget the join condition - NOT CORRECTLY, but it runs
                                -- if you forget the join condition the result is a cartesian product
                                --      (each row from one table is produced for every row in the other)
                                --      (the number of rows in the results = (#-of-rows-in-one-table * #-of-rows-in-the-other))
                                --      trying to join a 1000 row table with another 1000 row table without a join condition will result in 1000000 rows
                                --      a cartesian product is NOT a join
                                
--      2 modern syntax - code the type of join between the tables instead of a comma and the join condition is coded on an ON statement not WHERE
                                -- any type of join may be done
                                -- error is you forget the join condition
------------------------------------------------------------------------------------------------------
-- CLASSIC SYNTAX JOIN
------------------------------------------------------------------------------------------------------
 select country.name, city.name, district -- columns you want in the result
 from city, country -- table(s) with columns you want
 where code = countrycode -- which rows to include in the result
 and code = 'USA';
                          -- we want rows that match between country and city table
                          -- code in country matches to the countrycode in city
                          
-------------------------------------------------------------------------------------------------------
-- MODERN SYNTAX JOIN
-------------------------------------------------------------------------------------------------------
select country.name, city.name, district -- columns you want to see in the result
from city                                -- one of the tables to join
        join                             -- type to join
        country                          -- other table in the join
on code = countrycode                    -- join condition is coded on an ON (instead of a WHERE)
where code = 'USA';