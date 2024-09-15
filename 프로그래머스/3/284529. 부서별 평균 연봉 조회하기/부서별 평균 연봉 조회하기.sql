-- 코드를 작성해주세요
select d.dept_id, d.dept_name_en, round(avg(e.sal), 0) as avg_sal
from HR_DEPARTMENT as d
    inner join HR_EMPLOYEES as e
    on e.dept_id = d.dept_id
group by d.dept_id
order by avg_sal desc;