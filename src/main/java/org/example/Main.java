package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Input : AABBBDDDD
        //Output : A2B3D4

        /**
         * 1st way
         */
        String input = "AABBBDDDD";
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<input.length(); i++){
            Character ch = input.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else{
                map.put(ch, 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character key : map.keySet()){
            result.append(key).append(String.valueOf(map.get(key)));
        }
        System.out.println(result);

        /**
         * 2nd way
         */

        map = new HashMap<>();
        Map<Character, Integer> finalMap = map;
        IntStream.range(0, input.length()).mapToObj(input::charAt).forEach(ch -> {
            if (finalMap.containsKey(ch))
                finalMap.put(ch, finalMap.get(ch) + 1);
            else {
                finalMap.put(ch, 1);
            }
        });
        result = new StringBuilder();
        for (Character key : map.keySet()){
            result.append(key).append(String.valueOf(map.get(key)));
        }
        System.out.println(result);

    }
}