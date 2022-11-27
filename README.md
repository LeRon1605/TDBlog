# TDBlog
A blog website made by java servlet that consists fundamental functionality of a blog website.

## Project Structure
```
    ├── src                                        # Source code
    |   └── main
    |       ├── java
    |       |   ├── controllers                    # Servlets
    |       |   |   └── BaseServlet.java           # BaseServlet to inject AuthContext
    |       |   ├── models
    |       |   |   ├── DAO                        # Data access object
    |       |   |   |   ├── BaseDAO.java           # Some magic for query
    |       |   |   |   └── DatabaseConfig.java    # Database connection configuration
    |       |   |   ├── Bean                       # Data transfer object
    |       |   |   └── BO                         # Business logic
    |       |   ├── filters                        # Servlet filters
    |       |   └── core
    |       |       ├── Auth                       # Authentication implementation
    |       |       ├── Hash          
    |       |       ├── Mapper                     # Mapping object implementation
    |       |       └── Validation                 # Validation implementation
    |       └── webapp
    |           ├── public                         # Static files
    |           └── views                          # View
```
## Useage
Clone this repository by running following command
```
https://github.com/LeRon1605/TDBlog.git
```
Run ```db.sql``` to create database scheme

Config database connection at ```DatabaseConfig.java```
