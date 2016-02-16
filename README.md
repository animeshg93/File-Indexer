# File-Indexer

This java program takes in any number of plaintext file as a input and outputs the top 10 words found in that input file.

To run the program on any number of files and have it print the output in a file, type in the following on the Unix command line terminal:

`$ javac Indexer.java`
`$ java Indexer <path/to/input/files>  > <path/to/output/file>`

The input files should be separated by a space when typing in the command. e.g, if you want to pass in the input file foo.txt, bar.txt and hello.txt, and you want to pipe the output to output.txt, you would type as such:

`$ javac Indexer.java`
`$ java Indexer foo.txt bar.txt hello.txt  > output.txt`