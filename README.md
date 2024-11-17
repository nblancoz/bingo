# Bingo Game

This project is a simple Bingo game implemented in Java. It allows users to play Bingo by generating random numbers and
matching them against a Bingo card. Was made for the first quarterly activity of 'Programación' of 'Grado Superior DAW,
Universidad Europea'.

## Features

- User can enter their name and bet amount.
- User can predict the number of attempts needed to win Bingo.
- Generates a unique Bingo card with 10 numbers.
- Generates unique random numbers until all numbers on the card are matched.
- Displays the number of attempts taken to achieve Bingo and Line.
- Allows the user to play multiple rounds.

## Methods

### `playGame()`

This method handles the main game logic. It prompts the user for a bet amount and a prediction for the number of
attempts needed to win Bingo. Then it generates a Bingo card and starts calling random numbers until all numbers on the
card are matched. It also checks for a line achievement (matching 5 numbers) and displays the results.

### `playAgain()`

This method asks the user if they want to play another round. It returns `true` if the user wants to play again and
`false` otherwise.

### `generateBingoCard()`

This method generates a Bingo card with 10 unique random numbers between 1 and 99. It uses a `Set` to ensure that all
numbers on the card are unique.

### `generateUniqueNumber(Set<Integer> numbersCalled)`

This method generates a unique random number between 1 and 99 that has not been called before. It uses a `Set` to keep
track of the numbers that have already been called.

## Collections

### `Set`

A `Set` is a collection that contains no duplicate elements. It is used in this project to store the numbers on the
Bingo card and the numbers that have been called during the game.

### `HashSet`

A `HashSet` is a specific implementation of the `Set` interface. It uses a hash table to store the elements, which
allows for constant-time performance for basic operations like add, remove, and contains. In this project, `HashSet` is
used to store the numbers on the Bingo card and the numbers that have been called during the game.

## License

This project is under licence of Nicolás Blanco Zappalá. 2024

## Contact

<section display="flex" justify-content="center" align="center">
<a href = "mailto:nblancozappala@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" alt="Email me" target="_blank"></a>
<a href="https://www.linkedin.com/in/nblancoz" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Connect with me" target="_blank"></a>
<a href="https://github.com/nblancoz" target="_blank"><img src="https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png" alt="Check my GitHub" target="_blank" style="width: 30px; height: 28px;"></a>
</section>