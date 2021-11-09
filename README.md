

ENDPOINT:<br>
/get_file (GET) <br><br>
PARAMS:<br>
string (String)<br>
filetype (String) [json, csv, xml]<br><br> 
NOTE: <br>
Endpoint accepts string and filetype params, then returns meta data about given string in that filetype format.<br><br>
EXAMPLES:<br>

JSON:

INPUT:<br>

    "string" : Ala123!
    "filetype" : json

OUTPUT:<br>

    {
        "upperLetters" : 1
        "lowerLetters" : 2
        "numbers": 3
        "specialChars" : 1
        "otherChars" : 0
    }
<br><br>
CSV:

INPUT:<br>

    "string" : Ala123!
    "filetype" : csv

OUTPUT:<br>

    specialChars, numbers, upperLetters, lowerLetters, otherChars
    0,3,1,2,0
<br><br>
XML:

INPUT:<br>

    "string" : Ala123!
    "filetype" : xml

OUTPUT:<br>

        <?xml version="0.8" encoding="UTF-8" standalone="no"?>
            <specialChars>0</specialChars>
            <numbers>3</numbers>
            <upperLetters>1</upperLetters>
            <lowerLetters>2</lowerLetters>
            <otherChars>0</otherChars>
