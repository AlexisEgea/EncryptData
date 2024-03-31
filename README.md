# EncryptData

## Description

1. Encode a password from an Excel sheet by randomly generating a key.  
   The encoded value will replace the old hard-coded password in the Excel file.

2. Decode a password from an Excel sheet using a key.

## Requirements

* Java installed on your machine.

## Execution

### On Ubuntu:

To execute a .sh Script:  
   1. Open a terminal.  
   2. Run the command `chmod +x script_name.sh` to make the script executable.  
   3. Execute the script by running `./script_name.sh`.  

#### encodeData.sh  

* Creates the directory Bin/.
* Installs open-jdk 19.
* Executes EncodeData.java to encode the row with the Password from the Excel file "Profile.xlsx". This operation modifies "Profile.xlsx".
* Returns a file "Key.txt" containing the key used for encoding the data, which will be needed for decoding.

#### decodeData.sh  

* Creates the directory Bin/.
* Installs open-jdk 19.
* Executes DecodeData.java to decode the row with the Password from the Excel file "Profile.xlsx". This operation does not modify "Profile.xlsx".
* Returns a file "getYourPwd.txt" with the decoded password.

### On Windows:

*Under construction for running .sh scripts.*
DecodeData and EncodeData can be executed on IDEs by passing parameters like `path="your_path/EncryptData/Profile.xlsx"` and `data="Password"`.

## Areas for Improvement

* The aim of this project is to exclusively protect a cell with the identification point being the cell in the previous column with the name "Password".   
It would be more interesting and comprehensive to avoid identification by "Password" but rather by a variable containing a dynamic value set by the user or another means of identification.

## Contact Information

 For inquiries or feedback, please contact Alexis EGEA at [alexisegea@outlook.com](mailto:alexisegea@outlook.com).

## Copyright

© 2024 Alexis EGEA. All Rights Reserved.
