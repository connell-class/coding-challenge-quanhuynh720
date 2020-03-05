create table Item(
	itemId serial primary key,
	itemName varchar(50) not null,
	itemType varchar(50) not null
);
create table GroceryList(
	listId serial primary key,
	listName varchar(50) not null,
);

----------------------------------------------------

insert into Item (itemType) 
values ('food'),('electronics'),('clothing'),('hygiene');

----------------------------------------------------

ALTER TABLE Item
ADD CONSTRAINT itemFK
FOREIGN KEY (itemName) REFERENCES GroceryList (listName) ON DELETE CASCADE; 

select * from Item;
select * from GroceryList;