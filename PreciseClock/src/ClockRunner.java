public class ClockRunner
{
    public static void main(String[] args) {
        PreciseClock a = new PreciseClock(10, 20, 30);
        System.out.println(a); //Should print: 10:20.30
        
        PreciseClock b = new PreciseClock(10, 20);
        System.out.println(b); //Should print: 10:20.00
    
        b.setSeconds(5);
        System.out.println(b); //Should print: 10:20.05
        
        
        //Questions to answer if you get done early:
        
        //Consider this code:
        //  Clock e = new PreciseClock(20, 30, 40);
        //abc
        //Which of the following lines of code are allowed?  Why?
        // 1) e.setMinutes(10);
        // 2) e.setSeconds(20);
        // 3) System.out.println(e.equals(a));
        //
        //4) Does this line work?  Why?
        //  ((PreciseClock)e).setSeconds(30);
        //
        //
        //Which of the lines below work?  Why?
        //  Clock c = new Clock(20);
        //
        //  5) c.setSeconds(30);
        //  6) ((PreciseClock)c.setSeconds(3);
        //  7) PreciseClock x = new Clock();
    }
}