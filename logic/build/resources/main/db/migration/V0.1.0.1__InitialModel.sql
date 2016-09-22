create table BaseWord (id varchar(255) not null, primary key (id));
create table Element (id varchar(255) not null, hints varchar(255), title varchar(255), lastLog_id varchar(255), primary key (id));
create table ElementLog (id varchar(255) not null, quality integer, timestamp timestamp, element_id varchar(255), primary key (id));
create table Expression (id varchar(255) not null, primary key (id));
create table ExpressionItem (id varchar(255) not null, expression_id varchar(255), word_id varchar(255), primary key (id));
create table Vertex (id varchar(255) not null, predecessor_id varchar(255), successor_id varchar(255), primary key (id));
create table Word (id varchar(255) not null, primary key (id));

alter table BaseWord add constraint FK7qpgj4ns4my07ul9ir7egx8jk foreign key (id) references Word;
alter table Element add constraint FK6lx8omfhm1c2e3hy58tph85ut foreign key (lastLog_id) references ElementLog;
alter table ElementLog add constraint FK2ucsnccs13tr1d5q9vum0qmt7 foreign key (element_id) references Element;
alter table Expression add constraint FKsevu0de72qvjsox5sadb1nafa foreign key (id) references Element;
alter table ExpressionItem add constraint FK90vb7hvc9plbm4vvpdo0vh72s foreign key (expression_id) references Expression;
alter table ExpressionItem add constraint FKofkn79d26355as0oacmnr3cxc foreign key (word_id) references Word;
alter table Vertex add constraint FKdpr5i0kxa5olr40mdpur1ffv8 foreign key (predecessor_id) references Element;
alter table Vertex add constraint FKna39ho9cui058usirvljj405m foreign key (successor_id) references Element;
alter table Word add constraint FK6nos8y5dvpy3yff6tq8jjsnbl foreign key (id) references Element;