Begin transaction;

drop table if exists employee cascade;
drop table if exists department cascade;
drop table if exists project cascade;
drop table if exists employee_department cascade;
drop table if exists employee_project cascade;

create table employee
(employee_id serial not null,
job_title varchar (30) not null,
last_name varchar (25) not null,
first_name varchar (25) not null,
gender char (1) not null,
date_of_birth date not null,
date_of_hire date not null,
department varchar (30) not null,
constraint pk_employee_employee_id 
primary key (employee_id));

create table project
(project_id serial not null,
project_name varchar (50) not null,
start_date date not null,
number_of_employees int not null,
constraint pk_project_project_id 
primary key (project_id));

create table department
(department_id serial not null,
department_name varchar (50) not null,
number_of_employees int not null,
constraint pk_department_department_id 
primary key (department_id));

create table employee_department
(employee_id integer not null,
department_id integer not null,
constraint pk_employee_department_employee_id_department_id 
primary key (employee_id, department_id));

create table employee_project
(employee_id integer not null,
project_id integer not null,
constraint pk_employee_project_employee_id_project_id 
primary key (employee_id, project_id));

alter table employee_department
add foreign key (employee_id) 
references employee (employee_id);

alter table employee_department
add foreign key (department_id) 
references department (department_id);

alter table employee_project
add foreign key (employee_id) 
references employee (employee_id);

alter table employee_project
add foreign key (project_id) 
references project (project_id);

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Vandelay', 'Art', 'M', '09/23/1959', '05/30/1990', 'Sales', 'Importer/Exporter');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Costanza', 'George', 'M', '12/23/1953', '05/15/1999', 'Design', 'Architect');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Benes', 'Elaine', 'F', '08/11/1968', '03/26/2003', 'Design', 'Lead Designer');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Seinfeld', 'Jerry', 'M', '02/20/1970', '05/15/2009', 'Sales', 'Latex Salesman');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Kramer', 'Cosmo', 'M', '10/23/1990', '07/19/2015', 'HR', 'Benefits Specialist');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Costanza', 'Estelle', 'F', '11/08/1987', '06/04/2010', 'HR', 'Manager');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Costanza', 'Frank', 'M', '04/18/1975', '04/30/1995', 'Design', 'Manager');

insert into employee (last_name, first_name, gender, date_of_birth, date_of_hire, department, job_title)
values ('Ross', 'Susan', 'F', '08/07/1991', '10/31/2013', 'Sales', 'Manager');


insert into department (department_name, number_of_employees)
values ('Sales', (select count (department) from employee where department = 'Sales'));

insert into department (department_name, number_of_employees)
values ('HR', (select count (department) from employee where department = 'HR'));

insert into department (department_name, number_of_employees)
values ('Design', (select count (department) from employee where department = 'Design'));

insert into project (project_name, start_date, number_of_employees)
values ('Architecture Project', '10/01/2020', (select count (department) from employee where department = 'Design'));

insert into project (project_name, start_date, number_of_employees)
values ('Latex Sales Project', '04/01/2021', (select count (department) from employee where department = 'Sales'));

insert into project (project_name, start_date, number_of_employees)
values ('Human Fund Project', '07/01/2020', (select count (department) from employee where department = 'HR'));

insert into project (project_name, start_date, number_of_employees)
values ('Manager Project', '01/01/2021', (select count (job_title) from employee where job_title = 'Manager'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'George'), (select project_id from project where project_name = 'Architecture Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Frank'), (select project_id from project where project_name = 'Architecture Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Elaine'), (select project_id from project where project_name = 'Architecture Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Jerry'), (select project_id from project where project_name = 'Latex Sales Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Susan'), (select project_id from project where project_name = 'Latex Sales Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Art'), (select project_id from project where project_name = 'Latex Sales Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Cosmo'), (select project_id from project where project_name = 'Human Fund Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Estelle'), (select project_id from project where project_name = 'Human Fund Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Susan'), (select project_id from project where project_name = 'Manager Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Frank'), (select project_id from project where project_name = 'Manager Project'));

insert into employee_project (employee_id, project_id)
values ((select employee_id from employee where first_name = 'Estelle'), (select project_id from project where project_name = 'Manager Project'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'George'), (select department_id from department where department_name = 'Design'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Frank'), (select department_id from department where department_name = 'Design'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Elaine'), (select department_id from department where department_name = 'Design'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Jerry'), (select department_id from department where department_name = 'Sales'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Susan'), (select department_id from department where department_name = 'Sales'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Art'), (select department_id from department where department_name = 'Sales'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Cosmo'), (select department_id from department where department_name = 'HR'));

insert into employee_department (employee_id, department_id)
values ((select employee_id from employee where first_name = 'Estelle'), (select department_id from department where department_name = 'HR'));




commit;