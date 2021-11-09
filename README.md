

ENDPOINT:<br>
/get_file (GET) <br><br>
PARAMS:<br>
string (String)<br>
filetype (String)<br><br>
NOTE: <br>
Endpoint accepts string and filetype params, then returns file with given type containing meta data about given string in JSON format.<br><br>
EXAMPLE:<br>
INPUT:<br>

    "string" : Ala123!
    "filetype" : csv

OUTPUT:<br>

    file.csv
Which contain:

    {
        "upperLetters" : 1
        "lowerLetters" : 2
        "numbers": 3
        "specialChars" : 1
        "otherChars" : 0
    }
