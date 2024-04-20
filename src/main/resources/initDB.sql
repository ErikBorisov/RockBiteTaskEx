# create table hibernate_sequence
# (
#     next_val bigint null
# )
#     engine = MyISAM;
#
# create table material_type
# (
#     id          bigint auto_increment
#         primary key,
#     description varchar(255) null,
#     icon        varchar(255) null,
#     name        varchar(255) null
# );
#
# create table material
# (
#     id               bigint auto_increment
#         primary key,
#     name             varchar(255) null,
#     material_type_id bigint       null,
#     constraint FKbi2x1y0wd21rwst858gdylxr7
#         foreign key (material_type_id) references material_type (id)
# );
#
# create table user
# (
#     id        bigint auto_increment
#         primary key,
#     age       bigint       null,
#     name      varchar(255) null,
#     user_name varchar(255) null
# );
#
# create table warehouse
# (
#     id      bigint auto_increment
#         primary key,
#     user_id bigint null,
#     constraint FK415xnc88aigsjbfansim72b4s
#         foreign key (user_id) references user (id)
# );