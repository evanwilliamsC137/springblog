DROP DATABASE springblog_db;
CREATE DATABASE springblog_db;

TRUNCATE springblog_db.ads;
TRUNCATE springblog_db.posts;
TRUNCATE springblog_db.users;


USE springblog_db;

INSERT INTO springblog_db.users (username, email, password)
values ('admin','admin@email.com','$2a$10$MXtLn9vHHldC/PR0QS5wwuJNs3sWlCxe5k4pEw5/ulHwgTMSYWBHm');

INSERT INTO springblog_db.ads (description, title, user_id)
VALUES ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '3 Easy Ways To Make LOREM IPSUM Faster',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Get Rid of LOREM IPSUM For Good',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '10 Best Practices For LOREM IPSUM',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Use LOREM IPSUM To Make Someone Fall In Love With You',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'It''s All About LOREM IPSUM',1);

INSERT INTO springblog_db.posts (body, title,user_id)
VALUES ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '3 Easy Ways To Make LOREM IPSUM Faster',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Get Rid of LOREM IPSUM For Good',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '10 Best Practices For LOREM IPSUM',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Use LOREM IPSUM To Make Someone Fall In Love With You',1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'It''s All About LOREM IPSUM',1);

INSERT INTO springblog_db.categories (name)
values ('lorem'),('ipsum'),('dolor'),('sit'),('amet');

INSERT INTO springblog_db.ads_categories (ad_id, category_id)
values
       (1,1),
       (2,2),
       (4,3),
       (3,4);



