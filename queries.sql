begin
   execute immediate 'drop table item';
exception
   when others then null;
end;
/

create table item(id number(19) primary key,name varchar2(255),category varchar2(255),quantity number(19),price binary_double);

-- Generate ID using sequence and trigger
drop sequence item_seq;
create sequence item_seq start with 1 increment by 1;

create or replace trigger item_seq_tr
 before insert on item for each row
 when (new.id is null)
begin
 select item_seq.nextval into :new.id from dual;
end;
/

insert into item(name, category, quantity, price) values('chair', 'furniture', 10, 1000);
insert into item(name, category, quantity, price) values('bat', 'sports', 5, 5000);
insert into item(name, category, quantity, price) values('mouse', 'electronics', 5, 4000);
insert into item(name, category, quantity, price) values('shoes', 'fashion', 15, 600);