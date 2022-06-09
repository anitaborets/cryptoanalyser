# cryptoanalyser

Implementation of the Caesar cipher in the Russian alphabet.
The project contains 3 options:
1. Encrypt text
2. Decipher the text if the shift is known
3. Decipher the text using the shift selection method if the shift is unknown

Communication with the user occurs through the menu, input from the console
The text to encrypt/decrypt comes from a .txt file
The result is also output to a file in .txt format
Validation: presence of file, file extension, presence of text in file, shift format

The implementation method is through the Character array, which contains the Russian alphabet.
This method was chosen because the implementation through the character index in the Russian alphabet does not always work correctly
because of the letter "e".
The logic is in the CryptographerRU class
Validation - Validator Interface
Communication with the user - class Menu
The decryption option with analysis is implemented in the demo version - the analyze method

Example of entering text for decryption
Фэзыя йз зьи ахлш пвёнлш чугрщцкфнлш дцосн, жг еютзм ъгб.
Result:
съешь же ещё этих мягких французских булок  да выпей чаю 

