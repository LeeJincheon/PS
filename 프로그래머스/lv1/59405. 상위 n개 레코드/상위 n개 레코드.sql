-- 코드를 입력하세요
SELECT name
FROM(
    SELECT name
    FROM animal_ins
    ORDER BY datetime
)
WHERE rownum = 1