# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table artist (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_artist primary key (id))
;

create table play_time (
  id                        bigint not null,
  artist_id                 bigint,
  time                      integer,
  constraint pk_play_time primary key (id))
;

create sequence artist_seq;

create sequence play_time_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists artist;

drop table if exists play_time;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists artist_seq;

drop sequence if exists play_time_seq;

