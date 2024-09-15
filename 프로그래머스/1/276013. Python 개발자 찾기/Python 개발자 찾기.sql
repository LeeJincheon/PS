-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPER_INFOS
where 'Python' in (skill_1, skill_2, skill_3)
# where skill_1 = 'Python' or skill_2 = 'Python' or skill_3 = 'Python'
order by id;