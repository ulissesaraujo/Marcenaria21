package app;

public record Peca(
    int qtd,
    double altura,
    double profundidade,
    String nome,
    int f1,
    int f2,
    int f3,
    int f4,
    String material
) {

    /**
     * Formato completo: qtd, altura, prof, nome, f1, f2, f3, f4, material
     */
    public String toStringCompleto() {
        String tab = "\t";
        return qtd + tab
            + Double.toString(altura).replace(".", ",") + tab
            + Double.toString(profundidade).replace(".", ",") + tab
            + nome + tab
            + f1 + tab
            + f2 + tab
            + f3 + tab
            + f4 + tab
            + material;
    }

    /**
     * Formato com nome e fitamento: qtd, altura, prof, nome, f1, f2, f3, f4
     */
    @Override
    public String toString() {
        String tab = "\t";
        return qtd + tab
            + Double.toString(altura).replace(".", ",") + tab
            + Double.toString(profundidade).replace(".", ",") + tab
            + nome + tab
            + f1 + tab
            + f2 + tab
            + f3 + tab
            + f4;
    }

    /**
     * Formato com nome: qtd, altura, prof, nome
     */
    public String toStringComNome() {
        String tab = "\t";
        return qtd + tab
            + Double.toString(altura).replace(".", ",") + tab
            + Double.toString(profundidade).replace(".", ",") + tab
            + nome;
    }

    /**
     * Formato básico: qtd, altura, prof
     */
    public String toStringBasico() {
        String tab = "\t";
        return qtd + tab
            + Double.toString(altura).replace(".", ",") + tab
            + Double.toString(profundidade).replace(".", ",");
    }
    
    /**
     * Imprime a peça no formato especificado
     * @param modelo 1=básico, 2=comNome, 3=comFitamento(padrão), 4=completo
     */
    public void imprimir(int modelo) {
        switch (modelo) {
            case 1 -> System.out.println(this.toStringBasico());
            case 2 -> System.out.println(this.toStringComNome());
            case 3 -> System.out.println(this.toString());
            case 4 -> System.out.println(this.toStringCompleto());
            default -> System.out.println(this.toString());
        }
    }
    
    public static String descricao() {
        String tab = "\t";
        System.out.println( "qtd" + tab
                + "altura" + tab
                + "profundidade");
        return null;
    }
}
