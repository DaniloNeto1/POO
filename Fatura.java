public class Fatura{
    private String numPeca;
    private String descPeca;
    private double precoItem;
    private int quant;


public Fatura(String numPeca, String descPeca, double precoItem, int quant){
    this.numPeca = numPeca;
    this.descPeca = descPeca;
    this.quant = quant;
    this.precoItem = precoItem;
    
}

public String getNumPeca(){
    return numPeca;
}

public String getDescPeca(){
    return descPeca;
}

public int getQuant(){
    return quant;
}

public double getPrecoItem(){
    return precoItem;
}

public void setNumPeca(String numPeca){
    this.numPeca = numPeca;
}

public void setDescPeca(String descPeca){
    this.descPeca = descPeca;
}

public void setQuant(int quant){
    this.quant = quant;
}

public void setPrecoItem(float precoItem){
    this.precoItem = precoItem;
}

public double obterFatura(){
    return quant * precoItem;
}
}

public class UsaFatura{
    public static void main(String[] args){
        Fatura fatura = new Fatura("Alicate", "2222", 30, 65);
        
        System.out.println("Numero da peca:" + fatura.getNumPeca());
        System.out.println("Descricao:" + fatura.getDescPeca());
        System.out.println("Quantidade de itens:" + fatura.getQuant());
        System.out.println("Preco do item:" + fatura.getPrecoItem());
        System.out.println("Valor da fatura:" + fatura.obterFatura());
    }
}