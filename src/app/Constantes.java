package app;

/**
 * Constantes utilizadas nos cálculos de marcenaria.
 * O valor está no nome da constante para fácil visualização.
 * Se precisar alterar, mude o valor E o nome.
 */
public class Constantes {
    
    // === SAÍDA ===
    /** 
     * Modelo de saída para impressão das peças.
     * 1 = Básico (qtd, comp, larg)
     * 2 = Com nome (qtd, comp, larg, nome)
     * 3 = Padrão (qtd, comp, larg, nome, f1-f4)
     * 4 = Completo (qtd, comp, larg, nome, f1-f4, material)
     * 5 = DPaula (qtd, comp(cm), larg(cm), nome)
     */
    public static int MODELO_SAIDA = 4;
    
    // === GAVETAS ===
    /** Vão entre cada gaveta (mm) */
    public static final double VAO_ENTRE_GAVETAS_38_5 = 38.5;
    
    /** Vão após a última gaveta (mm) */
    public static final double VAO_ULTIMA_GAVETA_10 = 10;
    
    /** Espessura do fundo da gaveta - compensado (mm) */
    public static final double ESPESSURA_FUNDO_GAVETA_6 = 6;
    
    /** Espaçamento para corrediça telescópica H45 (mm) - cada lado */
    public static final double ESPACAMENTO_CORREDICA_12_5 = 12.5;
    
    /** Largura padrão do sarrafo do gaveteiro (mm) */
    public static final double LARGURA_SARRAFO_100 = 100;
    
    // === PORTAS ===
    /** Vão/folga entre portas ou porta e lateral (mm) */
    public static final double VAO_ENTRE_PORTAS_3 = 3;
    
    /** Desconto na largura para dobradiça reta (mm) */
    public static final double DESCONTO_DOBRADICA_RETA_1 = 1;
    
    /** Desconto na largura para dobradiça curva (mm) */
    public static final double DESCONTO_DOBRADICA_CURVA_7 = 7;
    
    /** Desconto na altura da porta (mm) - folga superior/inferior */
    public static final double DESCONTO_ALTURA_PORTA_6 = 6;
    
    // === PRATELEIRAS ===
    /** Folga da prateleira em relação à profundidade do gabinete (mm) */
    public static final double FOLGA_PRATELEIRA_PROFUNDIDADE_1 = 1;
    
    // === CHAPAS MDF ===
    /** Largura padrão da chapa de MDF (mm) */
    public static final double LARGURA_CHAPA_MDF_2750 = 2750;
    
    /** Altura padrão da chapa de MDF (mm) */
    public static final double ALTURA_CHAPA_MDF_1850 = 1850;
    
    /** Área de uma chapa de MDF em mm² */
    public static final double AREA_CHAPA_MDF = LARGURA_CHAPA_MDF_2750 * ALTURA_CHAPA_MDF_1850;
}
