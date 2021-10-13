set foreign_key_checks=0;

truncate table product;
truncate table feedback;


insert into product(`id`, `name`, `price`, `details`, `currency`)
values(110, 'luxury chair', 4500, 'details will be added later', 'FRC'),
(111, 'luxury sofa', 4500, 'details will be added later', 'USD'),
(112, 'luxury bench', 4500, 'details will be added later', 'NGN'),
(113, 'luxury table', 4500, 'details will be added later', 'NGN');


set foreign_key_checks=1;