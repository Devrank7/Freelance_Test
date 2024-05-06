package com.example.client_1.service.recom;

import com.example.client_1.model.BHotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecomendServer {

    public List<BHotel> getSorted(List<BHotel> listDescriptionProduct, String descriptionUser, boolean isEvictDuplicate,boolean isReversed) {
        List<String> promptUser = allotWords(descriptionUser);
        Map<Integer, BHotel> bHotelMap = new HashMap<>();
        List<String> duplicate = new ArrayList<>();

        for (BHotel bHotel : listDescriptionProduct) {
            List<String> list = allotWords(bHotel.getMainDescription());
            int grade = 0;
            for (String userWord : promptUser) {
                for (String bhWord : list) {
                    if (userWord.equals(bhWord)) {
                        if (isEvictDuplicate) {
                            if (!duplicate.contains(bhWord)) {
                                duplicate.add(bhWord);
                                grade++;
                            } else {
                                System.out.println("Word is containing");
                            }
                        } else {
                            grade++;
                        }
                    }
                }
            }
            while (bHotelMap.containsKey(grade)) {
                grade++;
            }
            bHotelMap.put(grade, bHotel);
        }
        List<BHotel> sortedList = new ArrayList<>();
        for (Integer i : bHotelMap.keySet()) {
            sortedList.add(bHotelMap.get(i));
        }
        return isReversed ? sortedList : sortedList.reversed();
    }


    private List<String> allotWords(String str) {
        String norStr = str += " ";
        char[] ch = norStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < norStr.length(); i++) {
            if (ch[i] == ' ') {
                if (!stringBuilder.isEmpty() && stringBuilder.length() >= 2) {
                    strings.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(ch[i]);
            }

        }
        return strings;
    }
}
