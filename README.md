---
title: Relationships between Tables
type: Lab
duration: "1:25"
creator:
    name: Yuliya Kaleda
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Relationships between Tables

## Introduction

> ***Note:*** _This should be done independently._

In this lab, you will create an app with a database with two tables - Employee and Job.  

Employee table should have the following data:  

<p align="center">
  <img src="./screenshots/employee.png">  
</p>

Job table should look like this:  

<p align="center">
  <img src="./screenshots/job.png">   
</p>

The main purpose of the app is to provide information, which is present in two tables:  

1.  show the full name of employees working at Macys
2.  show the companies located in Boston  
3.  show the full name of the employee with the highest salary  

Your app doesn't need to look like the screenshot, but it needs to have the same functionality.


## Exercise

#### Requirements

The Main Activity should:  

- Populate the database when launched
- Contain 3 buttons that display their results in a RecyclerView:

    * **employees working at macys** - the button that will return the full names of employees working at Macys
    * **companies in Boston** - the button that will return companies located in Boston
    * **employee with the highest salary** - the button that will return the employee name with the highest salary


**Bonus:** Use SQLiteQueryBuilder to form your joins


#### Deliverable

A working app that meets the requirements above.

<img src="./screenshots/screen1.png" width="300"/>
<img src="./screenshots/screen2.png" width="300"/>
<img src="./screenshots/screen3.png" width="300"/>
