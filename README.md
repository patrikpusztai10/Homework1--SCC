# Homework1--SCC

Usage:<br>
app -e/-d <input file> -o <output file> -k <integer> <br>
ex. app -o output2.txt -d input2.txt -k 5<br>
Explanation:<br>
My solution includes an implementation of the Caesar's cipher in Java. The code can be found in the Main.java file in the src directory. Src also contains the files for the test cases.<br>
Flow:<br>
First I check if the program arguments are correctly entered. If there are more or less arguments entered then expected then 
a message will be displayed.<br>
The rest of the algorithm is pretty intuitive.<br>
I go through the file using a while loop which stops when there aren't any lines left to iterate through.
I save the line and I iterate through each character found in the line. 
Depending on the choice of the user I either encrypt that line (add k to the initial character to shift it forward with k positions) or decrypt it (substitue k from the initial character to shift it backward with k positions). I also use %256 to make sure that the ASCII bounds are respected.
The encrypted or decrypted characters are used to build a new string which is outputted in the file chosen by the user.<br>
<br>
Test cases:<br>
1. input1.txt contains the lyrics of an album called 'Lux' from Rosalía. I used this album as a test case because Rosalía uses 13 different languages in this album
She sings in Japanese, Arabic and Ukrainian as well on 'Lux' however those languages are not included in ASCII but in UTF-8.
With this test case I aimed to test the ability of my code to handle these special characters like é, ç, ñ, ã, etc.
The encrypted lyrics can be found in the output1.txt file.
The key for the Caesar cipher is 5.<br>
2. input2.txt contains the encrypted message from output1.txt. With this test case I aimed to analyze the performance of the decryption part of the programme.
I used the same key. The result of the decryption can be found in output2.txt<br>
3. input3.txt contains lines with only one character per line. I also added lines without any characters to verify if the program stops prematurely or not.
It passed this test case, and outputted all the lines in output3.txt
