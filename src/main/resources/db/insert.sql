set foreign_key_checks = 0;

truncate table comment;
truncate table post;
insert into comment(`id`,`body`, `name`)
values(10, 'I am a Technical Product Manager', 'Chinomso'),
      (11, 'I am a Software Developer','Janet'),
      (12, 'I am a Front-end developer and designer', 'Blessing');

insert into post(`id`,`title`, `post_body`, `author`)
values(13, 'Product Management', 'Takes care of the product from the idea to production','Chinomso'),
      (14, 'Software Development', 'Takes care of writing programs on the computer','Janet'),
      (15, 'Front-End Development','Takes care of the digital Designs and web pages','Blessing');


set foreign_key_checks = 1;

