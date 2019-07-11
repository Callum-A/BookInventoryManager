# Book Inventory Manager
## Table of Contents
1. [General Info](general-info)
2. [Technologies Used](technologies-used)
3. [Features](features)
4. [Inspiration](inspiration)
5. [Status](status)
## General Info
A simple Java class based program to simulate a book inventory manager. Features two main classes representing a book and an inventory of books. The book class contains attributes used to define a book e.g. Title, Author, ISBN etc. also implements the comparable interface to sort the books by release year. The inventory class contains a list of books and can fill this list by reading a text file with books on their own line with their attributes seperated by commas, also contains other comparators to help sort the list. The other classes are exceptions used to handle irregular circumstances e.g. if a book is not found in the inventory or if the quantity of the book will become negative.
## Technologies Used
* Java
* Comparable Interfaces and Comparators
* Text File Reading
* Lambda Functions
* Basic Exceptions
## Features
Currently implemented features:
* Book inventory to be initialised from a text file
* Book objects each containing relevant attributes
* Sorting the inventory by attributes e.g. release year and pages
* Exception handling using try-catch blocks
## Inspiration
Wanted to model an object through Java e.g. movies, books etc. and further my knowledge with comparators and to show knowledge of reading a text file.
## Status
No longer be worked on, wanted to persue more complex projects.
