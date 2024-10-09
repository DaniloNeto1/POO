import java.util.Random;
public class Die{
    private int sideUp;
    
    public Die(){
        sideUp = 1;
        
    }

public int getSideUp(){
    return sideUp;
}

public void roll(){
    Random r = new Random();
    sideUp = r.nextInt(6) + 1;
}


}

public class DieDemo{
    public static void main(String[] args){
        
        Die d1 = new Die();
        Die d2 = new Die();
        
        d1.roll();
        d2.roll();
        
        int soma = d1.getSideUp() + d2.getSideUp();
        
        System.out.println("Soma = " +soma);
        
    }



}