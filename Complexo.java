public class Complexo{
    private double numero1;
    private double numero2;
    
    public Complexo(double a){
        numero1 = a; numero2 = 0;
        
    }
    public Complexo(double a, double i){
        numero1 = a; numero2 = i;
        
    }
   
   public void inicializaNumero(double a, double i){
        numero1 = a; numero2 = i;
   }
   
   public void imprimeNumero(){
       System.out.println(numero1+ "+" + numero2+ "i");
   }
   
   public void soma(Complexo j){
       numero1 = numero1 + j.numero1;
       numero2 = numero2 + j.numero2;
       
   }
   
   public void subtrai(Complexo x, Complexo aux){
       aux.numero1 = numero1 - x.numero1;
       aux.numero2 = numero2 - x.numero2;
   }
   
   public void multiplica(Complexo y, Complexo aux){
       aux.numero1 = (numero1 * y.numero1) - (numero2 * y.numero2);
       aux.numero2 = (numero1 * y.numero2) + (numero2 * y.numero1);
   }
   
    public void divide(Complexo z, Complexo aux){
        aux.numero1 = ((numero1 * z.numero1) + (numero2 * z.numero2)) / ((z.numero1 * z.numero1) + (z.numero2 * z.numero2));
        aux.numero2 = ((numero2 * z.numero1) + (numero2 * z.numero2)) / ((z.numero1 * z.numero1) + (z.numero2 * z.numero2));
        
   }
   
   public boolean eIgual(Complexo i){
        return this.numero1 == i.numero1 && this.numero2 == i.numero2;
   }
   
}


public class UsaComplexo{
    public static void main(String[] args){
        Complexo c1 = new Complexo(2, 4);
        Complexo c2 = new Complexo(2, 4);
        Complexo resultado = new Complexo(0, 0);
        
        c1.soma(c2);
        c1.imprimeNumero();
        
        c1.subtrai(c2, resultado);
        c1.multiplica(c2, resultado);
        c1.divide(c2, resultado);
        
    }
}