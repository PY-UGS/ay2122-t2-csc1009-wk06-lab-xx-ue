package com.company;
import java.util.* ;

public class Week6Hash {
    public static void main(String[] arg){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        map.put(1,3);
        map.put(2,5);
        map.put(3,7);
        map.put(4,9);
        map.put(5,11);
        System.out.println("Pt1: Hash format Before "+ map);
        Scanner input = new Scanner(System.in);
        System.out.println("Part 1 input: ");
        int Part1= input.nextInt();
        addAndSort(map,Part1);
        System.out.println("Pt1: Hash format After "+ map);
        System.out.println("Part 2 inputs: indexOne and indexTwo");
        int i1= input.nextInt();
        int i2=input.nextInt();
        System.out.println("Pt2:  Hash format Before :"+map);
        swapValues(map,i1,i2);
        System.out.println("Pt2: Hash format After :"+ map);

        HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>();
        Random randnumber = new Random();
        for (int i=0;i<500;i++){

            int number = (randnumber.nextInt(8999))+1000;
            map2.put(i,number);
        }
        System.out.println("Pt3: Hash generated :"+map2);

        int check =(int) (Math.random()*9999+1000);
        System.out.println("Pt3 Find "+ check);
        System.out.println("result "+ findValue(map2,check));
    }

    public static void addAndSort(HashMap <Integer,Integer> map, int value){
        if((int)map.get(map.size()-1)<value){
            map.put(map.size(),value);
        }
        else {
            int ind = 0;
            while ((int) map.get(ind) < value) {
                ind++;
            }
            int key=(int)map.size();
            for(int x=ind+1;x<map.size();x++){
                map.put(key,map.get(key-1));
                key-=1;
            }
            map.put(ind,value);
        }
    }
    public static void swapValues(HashMap<Integer,Integer> map, int index1, int index2){
        int temp=0;
        temp=(int)map.get(index1);
        map.put(index1,(int)map.get(index2));
        map.put(index2,temp);

    }
    public static int findValue(HashMap <Integer,Integer> map,int value){
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if (e.getValue()==value){
              return e.getKey();

            }

        }
        return -1;
    }

}
