# Batalja Speciale Bot Optimizer

## Overview
This optimizer is designed to teach (optimize) the performance of (simple) ANN in my Batalja Speciale bot using a 
Genetic Algorithm (GA). The GA operates over a population of bots, evolving and improving them over generations.

## To-Do List
- [ ] Develop a module to parse the performance of your bot after each game.
- [ ] Define a meaningful fitness function that quantifies the success and effectiveness of a bot.
- [ ] Implement a function to select parents from the current population based on their fitness.
- [ ] Create a mechanism to generate offspring bots to fill the population for the next generation.
- [ ] Incorporate a mutation step to introduce small random changes to the genetic makeup of bots.

## Project File Structure (Example)
```text
.
├── Game.jar
├── optimizer.iml
├── out
│   └── production
│       └── optimizer
│           ├── GameManager.class
│           ├── GameResult.class
│           ├── GeneticAlgorithm.class
│           ├── Main.class
│           ├── Player.class
│           └── Stats.class
├── Player1
│   ├── ActivationFunction.class
│   ├── Igralec.log
│   ├── Layer.class
│   ├── MatrixUtils.class
│   ├── NeuralNetwork.class
│   ├── Planet.class
│   ├── PlanetManager.class
│   ├── Player.class
│   └── SigmoidActivation.class
├── Player2
│   ├── ActivationFunction.class
│   ├── Igralec.log
│   ├── Layer.class
│   ├── MatrixUtils.class
│   ├── NeuralNetwork.class
│   ├── Planet.class
│   ├── PlanetManager.class
│   ├── Player.class
│   └── SigmoidActivation.class
├── Player3
│   ├── ActivationFunction.class
│   ├── Igralec.log
│   ├── Layer.class
│   ├── MatrixUtils.class
│   ├── NeuralNetwork.class
│   ├── Planet.class
│   ├── PlanetManager.class
│   ├── Player.class
│   └── SigmoidActivation.class
├── Player4
│   ├── ActivationFunction.class
│   ├── Igralec.log
│   ├── Layer.class
│   ├── MatrixUtils.class
│   ├── NeuralNetwork.class
│   ├── Planet.class
│   ├── PlanetManager.class
│   ├── Player.class
│   └── SigmoidActivation.class
├── README.md
├── scripts
│   └── copy.sh
└── src
    ├── GameManager.java
    ├── GameResult.java
    ├── GeneticAlgorithm.java
    ├── Main.java
    ├── Player.java
    └── Stats.java

```


## Execution Cycle
1. Parse the performance of the bot after each game.
2. Calculate fitness for each bot in the population.
3. Select parents based on their fitness.
4. Generate offspring bots through recombination.
5. Perform mutation on the offspring bots.
6. Form the next generation population.
7. Repeat the above steps for N generations.

## Competition Background
This optimizer is specifically designed for my bot that competes in Batalja Speciale competition held at the 
University of Primorska. 


## Acknowledgments
Special thanks to Dr. Aleksandar Tošić and Domen Vake for organizing the competition.

