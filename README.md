# SG_Treasure_Hunt

Simple game simulation based on predefined movements, treasure collection and directions.

## Features :

* Read an input file with game information
* Simulate multiple adventurers movements in a 2D game
* Write an output file with game information after being played

## Game Objects :

| / | Object | Description |
| ------ | ------ | ------ |
| A | Adventurer | Multiple adventurers can play |
| M | Mountain | Immutable object |
| C | Map | Map of the game |
| T | Treasure | Can be collected multiple times |


## Game Example :

<em>Please, edit the game.txt file in the resources folder to simulate a game</em>

File Input :
```sh
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 0 - 3 - 2
T - 1 - 3 - 3
A - Lara - 1 - 1 - S - AADADAGGA
A - Andy - 0 - 2 - S - AGAAAA
```
```sh
.       M         .
.       A(Lara)   M
A(Andy) .         .
T(2)    T(3)      .
```

File Output :
```sh
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 1 - 3 - 1
A - Lara - 0 - 3 - S - 2
A - Andy - 2 - 3 - E - 2
```
```sh
.         M         .
.         .         M
.         .         .
A(Lara)   T(1)    A(Andy)
```


## Built with :

* [Java](https://www.oracle.com/java/technologies/downloads/) - Java 18
* [IntelliJ](https://www.jetbrains.com/fr-fr/idea/download/) - Capable and Ergonomic IDE

## Librairies :

* [Apache Commons IO](https://commons.apache.org/proper/commons-io/)


## Author :

* Andy HUANG Alias @User24041997
