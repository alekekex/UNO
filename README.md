# UNO

A console-based UNO game written in Java. This project was created to practice object-oriented programming and design, with the addition of **inheritance** and **polymorphism** through different card types and game interactions.

## Features

* Support for 2–15 players
* Standard 108-card UNO deck
* Colored card display using ANSI escape codes
* Normal, Skip, Reverse, Draw Two, Change Color, and Draw Four cards
* Input validation
* Automatic UNO call
* Winner detection

## Technologies

* Java
* IntelliJ IDEA
* Git

## How to Run

### Option 1: IntelliJ IDEA

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Run `Main.java`.

### Option 2: Command Line

1. Clone the repository:

```bash
git clone https://github.com/alekekex/UNO.git
```

2. Change to the project directory:

```bash
cd UNO
```

3. Compile the program:

```bash
javac Main.java
```

4. Run the program:

```bash
java Main
```

Make sure Java is installed before running the program.

## Project Structure

```text
UNO/
├── Main.java
├── UNO.java
├── Deck.java
├── Player.java
├── Card.java
├── NormalCard.java
├── ActionCard.java
├── WildCard.java
├── Input.java
├── .gitignore
└── README.md
```

## License

This project was created for educational purposes, personal practice, and for fun.
