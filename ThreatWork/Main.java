package ThreatWork;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int num=1;
        List<Integer> list=new ArrayList<>();

        while(num<10001) {
            list.add(num);
            num++;
        }

        List<Integer> evenList= new ArrayList<>();
        List<Integer> oddList=new ArrayList<>();
        List<NumberSeperater> allList=new ArrayList<>();
        for(int i=0; i<4; i++){
            List<Integer> seperatedList=list.subList(i*2500,(1+i)*2500);
            NumberSeperater numberSeperater=new NumberSeperater(seperatedList,evenList,oddList);
            allList.add(numberSeperater);
            numberSeperater.start();
        }

        for(NumberSeperater thread:allList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(evenList.size());
        System.out.println(oddList.size());
    }
}
