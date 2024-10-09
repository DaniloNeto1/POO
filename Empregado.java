public class Empregado{
    private String nome;
    private String sobrenome;
    private double mensal;
    


public Empregado(String nome, String sobrenome, double mensal){
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.mensal = mensal;
}

public String getNome(){
    return nome;
}

public String getSobrenome(){
    return sobrenome;
}

public double getMensal(){
    return mensal;
}

public void setNome(String nome){
    this.nome = nome;
}

public void setSobrenome(String sobrenome){
    this.sobrenome = sobrenome;
}

public void setMensal(double mensal){
    this.mensal = mensal;
}

public double obterAnual(){
    return mensal * 12;
}

public double aumento(){
    return mensal * 0.10 + mensal;
}

}


public class UsaEmpregado{
    public static void main(String[] args){
        Empregado empregado = new Empregado("JOAO", "SILVA", 1500);
        
        System.out.println("Nome: " + empregado.getNome());
        System.out.println("sobrenome: " + empregado.getSobrenome());
        System.out.println("Salario: " + empregado.getMensal());
        System.out.println("Salario Anual: " + empregado.obterAnual());
        System.out.println("Aumento: " + empregado.aumento());
    }
}