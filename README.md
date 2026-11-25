# Java Leaderboard Manager

A command-line Java program that maintains a descending-order player leaderboard using two synchronized `ArrayList<Integer>` structures (`playerIds` and `scores`) up to a maximum capacity of 50 players.

## Features

- **Add Player (`1`)**: Adds a new player ID and non-negative score into the sorted leaderboard position.
- **Update Player Score (`2`)**: Updates an existing player's score and repositions their rank automatically.
- **Remove Players Below Threshold (`3`)**: Removes all players whose score is strictly below a specified threshold.
- **Display Player (`4`)**: Searches for a player by ID and prints their current score.
- **Display Leaderboard (`5`)**: Prints a formatted table of ranks, player IDs, and scores.
- **Exit (`6`)**: Closes the scanner and exits the application.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or later

### Compile and Run

```bash
javac Lab06_Q2.java
java Lab06_Q2
