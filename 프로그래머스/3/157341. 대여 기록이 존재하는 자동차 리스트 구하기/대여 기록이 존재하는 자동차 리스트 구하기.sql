-- 코드를 입력하세요
-- 세단, 10월 대여 시작
-- 자동차 id 중복 없음, 내림차순 정렬
select distinct c.car_id
from CAR_RENTAL_COMPANY_CAR as c
    inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.car_id = h.car_id
where c.car_type = '세단' and month(h.start_date) = 10
order by c.car_id desc;