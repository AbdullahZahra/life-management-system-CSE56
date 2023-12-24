# Life Management System

## Introduction

In a very busy day, it is very hard to keep track of all the important things in your life. That's why we created the life management system.

It is simply a system to keep track of all of your daily activity in an organized way. Its simplicity comes from keeping all of your life aspects in one place but separated.

This gives both the user and the developer an advantage because it is modular as every feature is separated and this gives the user the simplicity of use and the developer the ability to add new module when needed.

We started by 4 modules:
- Personal Data
- Reading List
- Exercise Schedular
- Activity Manager

## Tools

| Framework | JavaFX |
|-----------|--------|
| Database | MySQL |
| IDE | IntelliJ |
| SVC | Git |
## Database

We used MySQL database using XAMPP so that we used :

```MySQL
host = "jdbc:mysql://localhost/life_management"
username = "root"
password = ""
```

### Tables

#### books

| id | int(primary key)|
|---|------------------|
| name | varchar(255)|

#### personal_information

| id | int(primary key) |
|---|-------------------|
| first_name | varchar(255) |
|last_name | varchar(255) |
| email | varchar(255) |
| birthdate | varchar(255) |
| blood_type | varchar(255) |

## UI

### Main UI

Here you can choose which application to start.

![[mainUI.png]]
### Personal Information

Here you can:
1. Read data from database.
2. Update data in database.

![[personalInformation.png]]

### Reading List

Here you can:
1. Add a list of books.
2. Show the added books to the list.
3. Delete the books added in the list.

![[readingList.png]]

### Exercise Schedule & Activity Manager

Due to the lack of sufficient time for learning and implementing the knowledge of JavaFX and JDBC we only had time to implement the GUI interface for the main menu, the personal information, and the reading list programs and the rest was implemented using the CLI.

#### Exercise Schedule

Calculates the next exercise date of the given exercise.

![[exerciseSchedule.png]]

#### Activity Manager

A simple reminder of different types of deadlines.

![[activityManager.png]]
## UML Diagram

![[UML_Diagram -1.pdf]]

## Project Proposal

![[LifeMangment.pdf]]
