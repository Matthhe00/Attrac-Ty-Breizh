## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `class` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to Run

Dans le dossier App dans le terminal use : javac --module-path lib --add-modules javafx.controls -d bin src/*.java src/controller/*.java src/model/*.java src/view/*.java

Dans le dossier App dans le terminal use : java --module-path lib --add-modules javafx.controls -cp bin App
