> [!note]  
> All Files Are build and Run By using My local Environment Change According to Your Environment
# Hospital Management System
Hospital Management System having The Functionalities Like Patient login/signup, Admin login, Doctor Registration, Book Appointments and Store data in MySQL Database.
## Prerequisite

To Run or Build Project In Your Local System you need some Pre requisite platforms which download links also given Below
### Technologies and Platforms
| S.no          | Technology   |    Platform                  |          Download Link                    |
| :---:         |     :---:    |          :---:               |             :---:                         |
| 1             | Java         | Eclipse For Java Developer   |[Link](https://www.eclipse.org/downloads/) |
| 2             | SQL          | MySQL 8.0                    | [Link](https://www.mysql.com/downloads/)  |

### Java Packages Used
**1. java.sql.Connection:-**  is used for Establishing Connection,Executing SQL Statements or commands against the database and Transaction Management</br>
**2. java.sql.DriverManager:-** is used for class that manages a list of database drivers. It is part of the Java Database Connectivity (JDBC) API, which provides a standard interface for connecting to and interacting with databases.</br>
**3. java.sql.PreparedStatement:-** This class represents a precompiled SQL statement. It extends the java.sql.Statement interface and is used to execute parameterized SQL queries against a database. PreparedStatement objects are preferred over Statement objects when you need to execute the same SQL statement multiple times with different parameters, as they provide better performance and security through parameterized queries.</br>
**4. java.sql.ResultSet:-** This interface represents the result set of a database query. It provides methods for traversing the rows of the result set, accessing column values, and performing various operations on the data retrieved from the database. ResultSet objects are typically obtained by executing SQL queries using Statement or PreparedStatement objects.</br>
**5. java.util.Scanner:-** This class is used for parsing primitive types and strings from input streams (including text files, network connections, and other input sources) using regular expressions.


## Database
To Build with project we need to create Several tables in the MySQL Database to Store the Data and need to reuse According to the needs for the user/developer.
### Here are the tables and Schema of the Tables

<table>
<tr><th>For Admin Table </th><th>For Patients Table</th></tr>
<tr><td>

  
| Field    | Type         | Null | Key | Default | Extra |
|:--------:|:------------:|:----:|:---:|:-------:|:-----:|
| id       | int          | YES  |     | NULL    |       |                                 
| password | varchar(255) | YES  |     | NULL    |       |
</td><td>
  




| Field       | Type         | Null | Key | Default | Extra |
|:-----------:|:------------:|:----:|:---:|:-------:|:------:|
| id          | int          | YES  |     | NULL    |       |
| name        | varchar(255) | YES  |     | NULL    |       |
| phonenumber | bigint       | YES  |     | NULL    |       |
| password    | varchar(255) | YES  |     | NULL    |       |


</td>
</table>

<table>
<tr><th>For Appointments Table </th><th>For Doctor Table</th></tr>
<tr><td>

| Field       | Type         | Null | Key | Default | Extra |
|:-----------:|:------------:|:----:|:---:|:-------:|:-----:|
| id          | int          | YES  |     | NULL    |       |
| name        | varchar(255) | YES  |     | NULL    |       |
| phonenumber | bigint       | YES  |     | NULL    |       |
| Mail        | varchar(255) | YES  |     | NULL    |       |
| ap_date     | date         | YES  |     | NULL    |       |
| catgroy     | varchar(255) | YES  |     | NULL    |       |

</td><td>


| Field       | Type         | Null | Key | Default | Extra |
|:-----------:|:------------:|:----:|:---:|:-------:|:-----:|
| id          | int          | YES  |     | NULL    |       |
| doctor_name | varchar(255) | YES  |     | NULL    |       |
| phonenumber | bigint       | YES  |     | NULL    |       |
| mail        | varchar(255) | YES  |     | NULL    |       |
| spc         | varchar(255) | YES  |     | NULL    |       |
| password    | varchar(255) | YES  |     | NULL    |       |

</td></tr> </table>

