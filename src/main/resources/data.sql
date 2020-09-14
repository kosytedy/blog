insert into USER (
    id, 
    firstname, 
    lastname, 
    username, 
    email, 
    password, 
    created_at, 
    updated_at
) VALUES (
    1, 
    'Thaddeus', 
    'Okafor', 
    'teddy', 
    'kosytedy@yahoo.com', 
    '$2a$10$P8reLgoy9fAUH2T9.xq6CeYXzsT1l1I/l1UP1t0TEqLiWGvS1wr8K', 
    '2020-08-05 19:20:00', 
    '2020-08-05 19:20:00'
);

insert into POST (
    id, 
    user_id, 
    title, 
    content,
    created_at, 
    updated_at
) VALUES (
    1, 
    1, 
    'This is a post title', 
    'This is the body of a post. Lorem Ipsum fcyfyy hvuyfyuvh n jhcfuyfuy hvuyduyf g86futy.',
    '2020-08-05 19:20:00', 
    '2020-08-05 19:20:00'
);

insert into COMMENT (
    id, 
    user_id, 
    post_id, 
    content,
    created_at, 
    updated_at
) VALUES (
    1, 
    1, 
    1, 
    'This is a comment.',
    '2020-08-05 19:20:00', 
    '2020-08-05 19:20:00'
);