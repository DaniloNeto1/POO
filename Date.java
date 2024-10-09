public class Date{
    private int dia;
    private int mes;
    private int ano;
    
    public Date(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = (mes >= 1 && mes <= 12) ? mes : 1;
        this.ano = ano;
        
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
        
    public void setAno(int ano){
        this.ano = ano;
    }
    
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public void mostraData(){
        System.out.println(getDia() + "/" + getMes() + "/" + getAno());
    }
}

public class UsaDate{
    public static void main(String[] args){
        Date date = new Date(2, 9, 2003);
        
        System.out.println("Data:" + date.getDia());
        System.out.println("Data:" + date.getMes());
        System.out.println("Data:" + date.getAno());
        date.mostraData();
        
    }
}