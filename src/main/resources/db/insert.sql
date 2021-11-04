set foreign_key_checks = 0;

truncate table comment;
insert into comment(`id`,`body`, `name`)
values(10, 'I am a Technical Product Manager', 'Chinomso'),
      (11, 'I am a Software Developer','Janet'),
      (12, 'I am a Front-end developer and designer', 'Blessing');

set foreign_key_checks = 1;

