Delivery table:
+-------------+-------------+------------+-----------------------------+
| delivery_id | customer_id | order_date | customer_pref_delivery_date |
+-------------+-------------+------------+-----------------------------+
| 1           | 1           | 2019-08-01 | 2019-08-02                  |
| 2           | 5           | 2019-08-02 | 2019-08-02                  |
| 3           | 1           | 2019-08-11 | 2019-08-11                  |
| 4           | 3           | 2019-08-24 | 2019-08-26                  |
| 5           | 4           | 2019-08-21 | 2019-08-22                  |
| 6           | 2           | 2019-08-11 | 2019-08-13                  |
+-------------+-------------+------------+-----------------------------+


select count(order_date) as sameFirst from delivery group by order_date have


create table delivery(id int AUTO_INCREMENT,
customer_id int,
order_date date,
customer_pref_delivery_date date,
primary key (id));

insert into delivery values( 1, 1, '2019-08-02', '2019-08-02');
insert into delivery values( 2, 1, '2019-08-01', '2019-08-02');
insert into delivery values( 3, 2, '2019-08-03', '2019-08-03');
insert into delivery values( 4, 2, '2019-08-04', '2019-08-05');
insert into delivery values( 5, 3,'2019-08-03', '2019-08-03');
insert into delivery values( 6, 3, '2019-08-02', '2019-08-02');

      
select same_day_count *100/total as  immediate_percentage from 

(select count(id) as same_day_count from delivery c1 where  c1.order_date = c1.customer_pref_delivery_date) as t1,

(select count(id) as total from delivery c2) as t2;

select count(*) *100/b.total as immediate_percentage from delivery a,
(select count(*) as total from delivery) b
where a.order_date = a.customer_pref_delivery_date;



create table delivery(id int AUTO_INCREMENT,
customer_id int,
order_date date,
customer_pref_delivery_date date,
primary key (id));

insert into delivery values( 1, 1, '2019-08-02', '2019-08-02');
insert into delivery values( 2, 1, '2019-08-01', '2019-08-02');
insert into delivery values( 3, 2, '2019-08-03', '2019-08-03');
insert into delivery values( 4, 2, '2019-08-04', '2019-08-05');
insert into delivery values( 5, 3,'2019-08-03', '2019-08-03');
insert into delivery values( 6, 3, '2019-08-02', '2019-08-02');


select round(100*sum(case when order_date=customer_pref_delivery_date then 1 else 0 end)/count(distinct customer_id), 2) immediate_percentage
from delivery
where (customer_id, order_date) in
(select customer_id, min(order_date)
from delivery
group by customer_id);
