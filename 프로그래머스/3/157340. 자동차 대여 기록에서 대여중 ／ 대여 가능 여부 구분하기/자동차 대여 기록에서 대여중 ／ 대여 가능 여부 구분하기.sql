-- 코드를 입력하세요
-- 22/10/16, car_id, availability, 내림차순
select car_id,
    if(sum(if('2022-10-16' between start_date and end_date, 1, 0)) = 0, '대여 가능', '대여중') as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;