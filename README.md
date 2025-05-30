# MemoryGame 🎮🧠

**MemoryGame** is a memory game developed in **Java** with a graphical interface using **Swing**. This project is part of the Object Oriented Programming II course and is divided into incremental versions until the final version `v1.0`.

---

## ✨ Features

- User-friendly graphical interface with cards to combine
- Attempt counter
- Feedback messages to the player
- Score of the 10 best players persisted in a `.json` file
- Scoring system sorted by the lowest number of attempts
- Automated tests with JUnit to validate the persistence logic

---

## 🧪 Tests

Unit tests are located in the `src/test` folder. The `ScoreManagerTest` class ensures that the score saving and loading logic works correctly with JSON files.

> ⚠️ To avoid conflicts with the real game data, the tests use a temporary file `test_scores.json`, which is deleted at the end of each run.

---

## 🛠 Technologies used

- Java 20
- Swing (Java GUI)
- Gson (for JSON manipulation)
- JUnit 4 (automated tests)

---

## 📌 Educational Objective
This project was developed for academic purposes to apply the concepts of:

- Object Oriented Programming

- Good coding practices

- Automated testing

- Data persistence

---

## 👨‍💻 Authors
- [Tiago Mesquita](https://www.linkedin.com/in/tiago-santos-mesquita)
- Gustavo de Jesus
- Luiz Matheus Leão
- Lucas Carvalho

---

## 🚀 How to run

1. Clone the repository:
```bash
git clone https://github.com/your-user/MemoryGame.git
cd MemoryGame/v1.0
