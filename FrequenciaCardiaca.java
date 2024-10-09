public class FrequenciaCardiaca{
    private String nome;
    private String sobrenome;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    
    public FrequenciaCardiaca(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento){
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.diaNascimento = diaNascimento;
    this.mesNascimento = mesNascimento;
    this.anoNascimento = anoNascimento;
        
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSobrenome(){
        return sobrenome;
    }
    
    
    public int getDiaNascimento(){
        return diaNascimento;
    }
    
    public int getMesNascimento(){
        return mesNascimento;
    }
    public int getAnoNascimento(){
        return anoNascimento;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    
    public void setDiaNascimento(int diaNascimento){
        this.diaNascimento = diaNascimento;
    }
    
    public void setMesNascimento(int mesNascimento){
        this.mesNascimento = mesNascimento;
    }
    
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }
    
    public int obterIdade(){
        int idadeAtual = 2024 - anoNascimento;
        if(mesNascimento > 3){
            idadeAtual--;
        }else if(mesNascimento == 3 && diaNascimento > 28){
            idadeAtual--;
        }
        
        return idadeAtual;
    }
    
    public int obterFrequenciaMaxima(){
        return 220 - obterIdade();
    }
    
    public int obterFrequenciaIdeal(){
        int frequenciaMaxima = obterFrequenciaMaxima();
        return (int) (frequenciaMaxima * 0.5) + (int) (frequenciaMaxima * 0.35);
    }
    
}

public class UsaFrequenciaCardiaca{
    public static void main(String[] args){
        FrequenciaCardiaca frequencia = new FrequenciaCardiaca("Danilo", "Lindo", 18, 9, 2003);
        
        System.out.println("Nome:" + frequencia.getNome());
        System.out.println("Sobrenome:" + frequencia.getSobrenome());
        System.out.println("Data:" + frequencia.getDiaNascimento());
        System.out.println("Data:" + frequencia.getMesNascimento());
        System.out.println("Data:" + frequencia.getAnoNascimento());
        
        int idade = frequencia.obterIdade();
        int frequenciaMaxima = frequencia.obterFrequenciaMaxima();
        int frequenciaIdeal = frequencia.obterFrequenciaIdeal();
        
        
        System.out.println("Idade:" + idade);
        System.out.println("Frequencia Maxima:" + frequenciaMaxima);
        System.out.println("Frequencia Ideal:" + frequenciaIdeal);
        
        
        
    }
}