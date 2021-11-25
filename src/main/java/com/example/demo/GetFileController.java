package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.jfunc.json.impl.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
class GetFileController {
    @GetMapping("/get_file")
    @ResponseBody
    public String getParam(@RequestParam String string, @RequestParam String filetype) {
        String scannerApiUrl = "http://localhost:8080/scanner?string=";
        RestTemplate restTemplate = new RestTemplate();
        HashMap scannerResponse = restTemplate.getForObject(scannerApiUrl.concat(string), HashMap.class);

        switch (filetype){
            case "json":
                return scannerResponse.toString();
            case "csv":
                String csvResponse = "specialChars, numbers, upperLetters, lowerLetters, otherChars\n";
                csvResponse = csvResponse.concat(String.valueOf(scannerResponse.get("specialChars"))).concat(",");
                csvResponse = csvResponse.concat(String.valueOf(scannerResponse.get("numbers"))).concat(",");
                csvResponse = csvResponse.concat(String.valueOf(scannerResponse.get("upperLetters"))).concat(",");
                csvResponse = csvResponse.concat(String.valueOf(scannerResponse.get("lowerLetters"))).concat(",");
                csvResponse = csvResponse.concat(String.valueOf(scannerResponse.get("otherChars")));
                return csvResponse;
            case "xml":
                String xmlResponse = "<?xml version=\"0.8\" encoding=\"UTF-8\" standalone=\"no\"?>";
                xmlResponse = xmlResponse.concat("<specialChars>").concat(String.valueOf(scannerResponse.get("specialChars"))).concat("</specialChars>");
                xmlResponse = xmlResponse.concat("<numbers>").concat(String.valueOf(scannerResponse.get("numbers"))).concat("</numbers>");
                xmlResponse = xmlResponse.concat("<upperLetters>").concat(String.valueOf(scannerResponse.get("upperLetters"))).concat("</upperLetters>");
                xmlResponse = xmlResponse.concat("<lowerLetters>").concat(String.valueOf(scannerResponse.get("lowerLetters"))).concat("</lowerLetters>");
                xmlResponse = xmlResponse.concat("<otherChars>").concat(String.valueOf(scannerResponse.get("otherChars"))).concat("</otherChars>");
                return xmlResponse;
            case "txt":
                String txtResponse = scannerResponse.toString().replace("{", "").replace("}", "").replace(",","\n");
                return txtResponse;
            default:
                return "Unsupported file type!";
        }
    }
}
