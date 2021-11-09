package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.jfunc.json.impl.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ScannerController {
    @GetMapping("/get_file")
    @ResponseBody
    public String getParam(@RequestParam String string, String filetype) {

        int upperLetters = 0;
        int lowerLetters = 0;
        int numbers = 0;
        int specialChars = 0;
        int otherChars = 0;

        Pattern upperLettersPattern = Pattern.compile("[A-Z]");
        Matcher matcher = upperLettersPattern.matcher(string);

        while (matcher.find()) {
            upperLetters++;
        }

        Pattern lowerLettersPattern = Pattern.compile("[a-z]");
        matcher = lowerLettersPattern.matcher(string);

        while (matcher.find()) {
            lowerLetters++;
        }

        Pattern numbersPattern = Pattern.compile("[0-9]");
        matcher = numbersPattern.matcher(string);

        while (matcher.find()) {
            numbers++;
        }

        Pattern specialCharsPattern = Pattern.compile("[!@#$%^&*()/+-]");
        matcher = specialCharsPattern.matcher(string);

        while (matcher.find()) {
            specialChars++;
        }

        otherChars = string.length() - upperLetters - lowerLetters - numbers - specialChars;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("upperLetters", upperLetters);
        jsonObject.put("lowerLetters", lowerLetters);
        jsonObject.put("numbers", numbers);
        jsonObject.put("specialChars", specialChars);
        jsonObject.put("otherChars", otherChars);

        return String.valueOf(jsonObject);
    }
}
