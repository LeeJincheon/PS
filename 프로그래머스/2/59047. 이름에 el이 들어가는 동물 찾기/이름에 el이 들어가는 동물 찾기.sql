-- 코드를 입력하세요
select animal_id, name
from ANIMAL_INS
where name like '%EL%' and animal_type = 'Dog'
order by name;