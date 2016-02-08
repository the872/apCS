public class JerooRunner
{
    public static void main(String[] args)
    {
        //Things we will do:
        
        //1) Create Jeroo's in many different ways, then
        //  - print out their info
        //  - discuss difference between static and not-static
        //  - discuss difference between public and private
        Jeroo aid = new Jeroo();
        Jeroo darjur = new Jeroo(3, 4);
        Jeroo mainManDill = new Jeroo(5, 3, 90);
        //Jeroo joe = new Jeroo(180); -no one arg. constructed
        
        
        aid.printInfo();
        darjur.printInfo();
        //Jeroo.printInfo(); - bad
        
        int answer = aid.getxPosition();
        aid.rotateBy(90);        
        System.out.println(answer);
        
        //2) Tell the Jeroo's to hop and rotate around
        
        
        
        //3) Ask the Jeroo's for their info
    }
}