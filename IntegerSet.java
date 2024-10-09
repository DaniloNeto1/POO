public class IntegerSet{
    private boolean[] a;
    
    public IntegerSet(){
        a = new boolean[101];
        
        for(int i=0; i<101;i++)
        a[i] = false;
    
        
    }
    
    public IntegerSet union(IntegerSet x){
        IntegerSet u = new IntegerSet();
        
        for(int i=0; i<101; i++){
            if(a[i] == true || x.a[i] == true)
                u.a[i] = true;
        }
        return u;
    }
    
    public IntegerSet intersection(IntegerSet z){
        IntegerSet l = new IntegerSet();
        
        for(int i=0; i<101; i++){
            if(a[i] == false || z.a[i] == false)
                l.a[i] = false;
        }
        return l;
    }


    public String toSetString(){
        String aux = "";
        
        for(int i=0; i<101; i++){
            if(a[i] == true){
                aux = aux + i + " ";
            }
        }
        
        if(aux.equals("") == true)
            return "--";
        else
            return aux;
    }
    
    public void insertElement(int k){
        a[k] = true;
        
    }
    
    public void deleteElement(int m){
        a[m] = false;
    }

}


public class UsaIntegerSet{
    
    public static void main(String[] args){
        
        IntegerSet c1 = new IntegerSet();
        c1.insertElement(22);
        c1.insertElement(23);
        
        IntegerSet c2 =  new IntegerSet();
        
        c2.insertElement(30);
        
        System.out.println(c1.toSetString());
        System.out.println(c2.toSetString());
        
        IntegerSet c3 = c1.union(c2);
        System.out.println(c3.toSetString());
        
        
        IntegerSet c4 = c1.intersection(c2);
        
        System.out.println(c4.toSetString());
    }
}