--
-- This SQL depends on the dvdstore database
--
-- The case statement is used to "decode" value in a database
-- case allows you to specify conditional value for the column

-- 2 formats of case
--      case column
--              when 'value' then 'result' -- only one WHEN can be true, elvaluates in order so as soon as WHEN is true it ends the case; order matters
--              when 'value' then 'result'
--              when 'value' then 'result'
--              when 'value' then 'result' -- any condition allowed on a WHERE 
--              else 'result'
--      end
--


--      case
--              when condition then 'result'
--      end

select title
      ,rating
      , case rating
            when 'G'  then 'General Audiences'
            when 'PG' then 'Parental Guidance'
            when 'R'  then 'Restricted'
            when 'NC-17'  then 'No one under 17 admitted' 
            when 'PG-13'  then 'Parents Strongly Cautioned'
            else 'Un-rated'
        end
        as film_Rating -- is there is an as for the case it is placed after the end for the case
  from film
  ;
  
  select title
        ,length
        ,case
           when length between 0 and 60  then 'short - less that an hour'
           when length is null           then 'unknown'
           when length between 61 and 90 then 'medium'
           when length > 150             then 'bring a pillow'
           else                                'tolerable'
         end
         as length_comment
     from film
  ;