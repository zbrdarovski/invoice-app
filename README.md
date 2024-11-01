## Invoice Accounting (Java Project Task About Invoice Accounting)

---

#### Assigned by:

```
Higher Education Institution: Faculty of Electrical Engineering and Computer Science, University of Maribor
Study Programme: Computer Science and Information Technologies (First Cycle Bologna Study Programmes, Academic-Degree Study Programmes)
Course Unit: Principles of Programming Languages
```

---

#### About:

```
This is a Gradle, Java version "11.0.5" project.
The purpose of this project is to store and print information presented on a shop invoice.
```

---

### Project structure:

```
    |_lib
    |_src
        |_main
            |_java
            |   |_dao
            |   |   |_json
            |   |   |_mysql
            |   |
            |   |_db
            |   |_model
            |   |_util
            |
            |_resources

Explanation:
~/lib - jar libraries for working with mysql database
~/src - project source code
~/main - main project directory
~/java - directory where java code is kept
~/dao - interfaces for storing and reading data
~/json - classes for work with json
~/db - files for work with MySQL database
~/model - the classes that represent the invoice management model
~/util - classes with sets of support functions
~/resources - files containing (configuration) data that can be accessed within the application
```

---

### This project contains the following Java class(es):

```
1. MainClass: to print Invoice
2. Item: to store information about shop Item
3. Items: to store one or more Item objects
4. Invoice: to store Items object and other information
5. Company: to store information about Company
6. BarcodeUtil: to operate with barcodes
7. JsonItem: implementation of ItemDao Interface
8. JsonItems: implementation of ItemsDao Interface
9. JsonInvoice: implementation of InvoiceDao Interface
10. JsonCompany: implementation of CompanyDao Interface
11. DatabaseUtil: to connect and test database
```

---

### This project contains the following Java interface(s):

```
1. Searchable: to search for String element in the classes
2. DaoCrud: generic Dao Interface
3. ItemDao: Dao Interface for model Item
4. ItemsDao: Dao Interface for model Items
5. InvoiceDao: Dao Interface for model Invoice
6. CompanyDao: Dao Interface for model Company
```

---

###### Images:

![invoices.png](images/invoicesPP.png?raw=true "Invoices Physical Presentation")

```
1. Invoices Physical Presentation.
```

![invoices.png](images/invoicesVP.png?raw=true "Invoices Physical Presentation")

```
2. Invoices Virtual Presentation.
```
---

###### Useful Links:
* [Markdown Cheat Sheet](https://commonmark.org/help/) (added: 14-03-2020)
* [Java Naming Conventions - GeeksforGeeks](https://www.geeksforgeeks.org/java-naming-conventions/) (added: 16-03-2020)
* [Why not use Double or Float to represent currency?](https://stackoverflow.com/questions/3730019/why-not-use-double-or-float-to-represent-currency) (added: 14-03-2020)
* [How do you like your primary keys? [closed]](https://stackoverflow.com/questions/404040/how-do-you-like-your-primary-keys) (added: 14-03-2020)
* [GS1 BARCODE CHART](https://www.gs1us.org/DesktopModules/Bring2mind/DMX/Download.aspx?Command=Core_Download&EntryId=160&language=en-US&PortalId=0&TabId=134) (added: 14-03-2020)
* [MySQL UUID Smackdown: UUID vs. INT for Primary Key](https://www.mysqltutorial.org/mysql-tips/mysql-uuid/)  (added: 14-03-2020)
* [Difference between HashMap, LinkedHashMap and TreeMap](https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap) (added: 14-03-2020)
* [Company Example](https://www.bizi.si/SPAR-SLOVENIJA-D-O-O/) (added 25-03-2020)
* [How to calculate a check digit manually](https://www.gs1.org/services/how-calculate-check-digit-manually) (added 25-03-2020)
* [Check digit calculator](http://www.axicon.com/checkdigitcalculator.html) (added 25-03-2020)
* [EAN Barcodes by Country](https://wholesgame.com/trade-info/ean-barcodes-country/) (added 25-03-2020)
* [Data Access Object Pattern](https://www.tutorialspoint.com/design_pattern/pdf/data_access_object_pattern.pdf) (added 27-03-2020)
* [Java - Documentation Comments - Tutorialspoint](https://www.tutorialspoint.com/java/java_documentation.htm) (added 06-05-2020)
* [DBCP Connection Pooling Example](https://examples.javacodegeeks.com/core-java/apache/commons/dbcp/dbcp-connection-pooling-example/) (added 26-05-2020)
* [A Simple Guide to Connection Pooling in Java](https://www.baeldung.com/java-connection-pooling) (added 26-05-2020)
**NOTICE:** *The above links were available on the date they were* **added** *and currently might be unavailable!*
> I am sorry for the inconvenience!

---
