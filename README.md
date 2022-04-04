# SG_Treasure_Hunt

Simple game simulation based on predefined movements, treasure collection and directions.

## Features :

* Read an input file
* Simulate adventurers movements
* Write an output file

## Game Objects :

| / | Object | Description |
| ------ | ------ | ------ |
| A | Adventurer | Multiple adventurers can play |
| M | Mountain | Immutable object |
| C | Map | Map of the game |
| T | Treasure | Can be collected multiple times |


## Game Example :

File Input :
```sh
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 0 - 3 - 2
T - 1 - 3 - 3
A - Andy - 1 - 1 - S - AADADAGGA
```
```sh
.       M         .
.       A(Andy)   M
.       .         .
T(2)    T(3)      .
```

File Output :
```sh
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 1 - 3 - 2
A - Andy - 0 - 3 - S – 3
```
```sh
.         M         .
.         .         M
.         .         .
A(Andy)   T(2)      .
```


## Built with :

* [Java](https://www.oracle.com/java/technologies/downloads/) - Java 18
* [IntelliJ](https://www.jetbrains.com/fr-fr/idea/download/) - Capable and Ergonomic IDE


## Author :

* Andy HUANG Alias @User24041997
