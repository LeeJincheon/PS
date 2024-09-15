-- 코드를 입력하세요
select b.category, sum(bs.sales) as total_sales
from book as b
    inner join book_sales as bs
    on b.book_id = bs.book_id
where year(bs.sales_date) = 2022 and month(bs.sales_date) = 01
group by b.category
order by b.category