package com.test.codility;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.stream.Collectors;

public class Codility1 {


    public static Map<Long, Long> count(Map<String, UserStats>... visits) {

        if(Objects.isNull(visits) || visits.length==0){
            return new HashMap<>();
        }

        Map<Long,Long> userVisits=new HashMap<>();
        for(Map<String, UserStats> visit:visits){
                if(Objects.nonNull(visit)){
                    visit.entrySet().removeIf(entry-> removeInValidKeys(entry.getKey()));
                    visit.entrySet().removeIf(entry->Objects.isNull(entry.getValue()));
                    visit.entrySet().removeIf(entry->removeEmptyVisitCounts(entry.getValue()));
                    Optional<String> userKey=visit.keySet().stream().findFirst();
                    if(userKey.isPresent()){
                        Long key=Long.parseLong(userKey.get());
                        Long value=visit.get(String.valueOf(key.longValue())).visitCounts.get();
                        if(userVisits.containsKey(key.longValue())){

                            userVisits.put(key,value.longValue()+1);
                        }
                        else {
                            userVisits.put(key,value);
                        }
                    }
                    else{
                        continue;
                    }

                }
                else {
                    continue;
                }
            }

        return userVisits;

        }


    private static boolean removeInValidKeys(String key){

        try{
            Long value=Long.parseLong(key);
            return !Objects.nonNull(value);
        }catch (NumberFormatException ex){
            return true;
        }
    }

    private static boolean removeEmptyVisitCounts(UserStats value){

        return !value.getVisitCounts().isPresent();
    }

    public static void main(String[] args) {

        List<Map<String,UserStats>> userStats= new ArrayList<>();
        UserStats userStats1= new UserStats();
        userStats1.setVisitCounts(Optional.of(3L));
        Map<String,UserStats> map1=new HashMap<>();
        map1.put("1",userStats1);

        UserStats userStats2= new UserStats();
        userStats2.setVisitCounts(Optional.of(2L));
        Map<String,UserStats> map2=new HashMap<>();
        map2.put("2",userStats2);

        Map<String,UserStats> map3=new HashMap<>();
        map3.put("3",null);

        UserStats userStats4= new UserStats();
        userStats4.setVisitCounts(Optional.empty());
        Map<String,UserStats> map4=new HashMap<>();
        map4.put("4",userStats4);

        UserStats userStats5= new UserStats();
        userStats5.setVisitCounts(Optional.of(1L));
        Map<String,UserStats> map5=new HashMap<>();
        map5.put("NonLong",userStats5);

        userStats=Arrays.asList(map1,map2,map3,map4,map5,null);



        Map<Long,Long> values=count(userStats.toArray(new HashMap[userStats.size()]));

        values.entrySet().forEach(e-> System.out.println(" UserId: " + e.getKey() + " Visit Counts : " + e.getValue()));
    }
}
