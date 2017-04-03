package main;

public class PrimeNumberTask implements Task{

	@Override
	 public Object compute(Object args) {
        java.util.Vector arg = (java.util.Vector) args;
        java.util.Vector results=new  java.util.Vector();
        
        int poczPrzedzialu = ((Integer) arg.get(0)).intValue();
        int konPrzedzialu = ((Integer) arg.get(1)).intValue();
        int i;
        
        System.out.println(poczPrzedzialu+" "+konPrzedzialu);
        for (i = poczPrzedzialu; i <= konPrzedzialu; i++) {
            if ((i % 2 != 0 && i % 3 != 0 && i % 5 != 0) || i==2 ||i==3 || i==5) {
                results.add(i);
            }
        }
        return results;
    }
	

}
