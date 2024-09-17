-- 코드를 입력하세요
# select name, datetime
# from animal_ins
# where animal_id not in(
#     select animal_id
#     from animal_outs
# )
# order by datetime
# limit 3;

select ins.name, ins.datetime
from animal_ins as ins
    left join animal_outs as outs
    on ins.animal_id = outs.animal_id
where outs.datetime is null
order by datetime
limit 3;