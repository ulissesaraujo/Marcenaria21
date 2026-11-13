package app;

/**
 * Projeto: Armário Limão
 */
public class Main03ArmarioLimao {

	public static void main(String[] args) {
		
		// ══════════════════════════════════════════════════════════════════
		// CONFIGURAÇÃO GERAL DO PROJETO  12/11/2026
		// ══════════════════════════════════════════════════════════════════
		
		String material = "7009";
		double espessuraMDF = 15;
		double peDireito = 1830;
		double alturaPadrao = peDireito;
		double profundidadeArmario = 450;
		double profundidadeRodape = 0;
		double larguraPadrao = 910;
		boolean dobradicaReta = true;
		boolean comRodizio = true;
		
		double largura = larguraPadrao;
		double altura = alturaPadrao;
		double profundidade = profundidadeArmario;
		double qtdPrateleira = 2;
		double qtdPorta = 2;  // 0=sem porta, 1=porta única, 2=porta dupla
		boolean comFitamento = true;   // true=aplica fita conforme regras, false=sem fita
		boolean fitaParede = false;    // true=f2 com fita (armário isolado), false=f2 sem fita (encosta na parede)
		
		Gabinete.normal(largura, altura, profundidade, profundidadeRodape, 
				material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, comFitamento, fitaParede);
		
	}
}
