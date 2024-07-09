package com.techztile.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DNEEntity {
    private String email;
    private String pref_cd;
    // Other fields...

    public DNEEntity(String email, String pref_cd) {
        this.email = email;
        this.pref_cd = pref_cd;
        // Initialize other fields...
    }

    public String getEmail() {
        return email;
    }

    public String getPref_cd() {
        return pref_cd;
    }

    @Override
    public String toString() {
        return "DNEEntity{" +
                "email='" + email + '\'' +
                ", pref_cd='" + pref_cd + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample list of DNEEntity objects
        List<DNEEntity> entityList = new ArrayList<>();
        entityList.add(new DNEEntity("email1", "GUFA"));
        entityList.add(new DNEEntity("email1", "SOFOC"));
        entityList.add(new DNEEntity("email1", "SOFC"));
        entityList.add(new DNEEntity("email1", "CE"));
        entityList.add(new DNEEntity("email2", "GUFA"));
        // Add more entities...

        // Create a map to track pref_cd for each email
        Map<String, Boolean> prefMap = new HashMap<>();
        entityList.forEach(entity -> prefMap.put(entity.getEmail() +  "_" + entity.getPref_cd(), true));

        // Populate missing pref_cd for each email
        List<DNEEntity> resultList = new ArrayList<>();
        for (DNEEntity entity : entityList) {
            String email = entity.getEmail();
            if (!prefMap.containsKey(email + "_SOFOC")) {
                resultList.add(new DNEEntity(email, "SOFOC"));
            }
            if (!prefMap.containsKey(email + "_SOFC")) {
                resultList.add(new DNEEntity(email, "SOFC"));
            }
            if (!prefMap.containsKey(email + "_CE")) {
                resultList.add(new DNEEntity(email, "CE"));
            }
            if (!prefMap.containsKey(email + "_PPAP")) {
                resultList.add(new DNEEntity(email, "PPAP"));
            }
        }

        // Combine the original list with the populated missing objects list
        List<DNEEntity> combinedList = new ArrayList<>(entityList);
        combinedList.addAll(resultList);

        // Print the combined list
        combinedList.forEach(System.out::println);
    }
}
