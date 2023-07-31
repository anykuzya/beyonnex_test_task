# Anagram Checker

The Anagram Checker is a Kotlin program that checks if two texts are anagrams of each other. It allows you to compare texts either by providing them manually or reading them from files.

### Build
To build this project, run `gradle build` (or `./gradlew build`, if no gradle is installed) in the root directory
### Usage
To use the Anagram Checker program, you can run it with the appropriate command-line arguments. The program supports two modes: `file` mode and `manual` mode.
#### Command-line Arguments
```
                          ../anagram-checker $ cd build/classes/kotlin/main
../anagram-checker/build/classes/kotlin/main $ kotlin MainKt <mode> [file1] [file2]
```
- `<mode>`: The mode in which you want to compare texts.
- `[file1]` and `[file2]` (optional): If you choose `file` mode, provide the paths of two files with texts to be compared.
#### Examples
Compare texts in manual mode (user will be prompted to input one-line texts):

```../kotlin/main $ kotlin MainKt manual```

Compare texts from files:

```../kotlin/main $ kotlin MainKt file path/to/file1.txt path/to/file2.txt```

Files for playing with could be found in `../anagram-checker/src/test/resources/`

### Output
The program will output whether the provided texts are anagrams of each other or not, or inform user about exceptions if any occurred.

### Executable
`gradle build` generates also `anagram-checker.jar` but it doesn't contain kotlin compiled sources.
So, for getting working executable in libs, run `gradle shadowJar` (or `./gradlew shadowJar`, if no gradle is installed).
Then you can run this executable `anagram-checker-all.jar` with java:

`../anagram-checker $ java -jar build/libs/anagram-checker-all.jar <mode> [file1] [file2]`
