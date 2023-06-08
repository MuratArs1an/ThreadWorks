package ThreatWork;

import java.util.List;

public class NumberSeperater extends Thread{

    private List<Integer> numbers;
    private List<Integer> evenNumbers;
    private List<Integer> oddNumbers;

    public NumberSeperater(List<Integer> numbers, List<Integer> evenNumbers, List<Integer> oddNumbers) {
        this.numbers = numbers;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        for(int num:numbers){
            if(num%2==0){
                synchronized (evenNumbers){
                    evenNumbers.add(num);
                }
            }else{
                synchronized (oddNumbers){
                    oddNumbers.add(num);
                }
            }
        }
    }
}
