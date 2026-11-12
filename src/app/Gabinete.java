package app;

import static app.Constantes.*;

public class Gabinete {
 private Gabinete() {
   /* This utility class should not be instantiated */
 }


	/**
	 * Cria um gabinete padrão com laterais, base(s), prateleiras e portas.
	 * 
	 * @param larguraTotal largura externa do gabinete
	 * @param altura altura do gabinete
	 * @param profundidadeArmario profundidade das peças (lateral, base, prateleira)
	 * @param profundidadeRodape recuo da base inferior (0 se não tiver rodapé)
	 * @param material código do material
	 * @param espessuraMDF espessura do MDF
	 * @param qtdPrateleira quantidade de prateleiras
	 * @param qtdPorta quantidade de portas (0, 1 ou 2)
	 * @param dobradicaReta true=reta, false=curva
	 * @param comRodizio true=base maior (larguraTotal), lateral menor (altura - 2*MDF)
	 * @param fitamentoPorta true=fita nos 4 lados da porta, false=sem fita
	 */
	public static void normal(double larguraTotal, double altura, double profundidadeArmario, double profundidadeRodape, 
			String material, double espessuraMDF, double qtdPrateleira, double qtdPorta, boolean dobradicaReta, boolean comRodizio, boolean fitamentoPorta) {
		
		double larguraInterna = larguraTotal - (espessuraMDF * 2);
		double qtdPeca = 1;
		
		if (qtdPorta < 0 || qtdPorta > 2) {
			throw new IllegalArgumentException("Quantidade de portas inválida");
		}

		// Ajuste para rodízio: lateral menor, base maior
		double alturaLateral = comRodizio ? altura - (espessuraMDF * 2) : altura;
		double larguraBase = comRodizio ? larguraTotal : larguraInterna;

		// LATERAL - profundidade total (armário + rodapé)
		double profundidadeTotal = profundidadeArmario + profundidadeRodape;
		Peca lateral = new Peca((int) (qtdPeca + 1), alturaLateral, profundidadeTotal, "Lateral", 0, 0, 0, 0, material);
		lateral.imprimir(MODELO_SAIDA);

		// BASE
		if (profundidadeRodape == 0) {
			// Sem rodapé: base única
			Peca base = new Peca((int) (qtdPeca + 1), larguraBase, profundidadeArmario, "Base", 0, 0, 0, 0, material);
			base.imprimir(MODELO_SAIDA);
		} else {
			// Com rodapé: base superior (profundidade total) e base inferior (recuada)
			Peca baseSup = new Peca((int) (qtdPeca), larguraBase, profundidadeTotal, "BaseSup", 0, 0, 0, 0, material);
			baseSup.imprimir(MODELO_SAIDA);
			Peca baseInf = new Peca((int) (qtdPeca), larguraBase, profundidadeArmario, "BaseInf", 0, 0, 0, 0, material);
			baseInf.imprimir(MODELO_SAIDA);
		}

		// PRATELEIRA (sempre usa larguraInterna, não muda com rodízio)
		if (qtdPrateleira > 0) {
			// Se um dia for colocar fundo no armário, vai ter que colocar a folga do fundo.
			Peca prateleira = new Peca((int) (qtdPrateleira), larguraInterna, profundidadeTotal - FOLGA_PRATELEIRA_PROFUNDIDADE_1, "Pratele", 0, 0, 0, 0, material);
			prateleira.imprimir(MODELO_SAIDA);
		}

		// PORTA (sempre usa altura original, não muda com rodízio)
		if (qtdPorta != 0) {
			double diminuirDobradica = dobradicaReta ? DESCONTO_DOBRADICA_RETA_1 : DESCONTO_DOBRADICA_CURVA_7;
			double diminuirPorta = diminuirDobradica + VAO_ENTRE_PORTAS_3;
			int fita = fitamentoPorta ? 1 : 0;
			Peca porta = new Peca((int) (qtdPorta), altura - DESCONTO_ALTURA_PORTA_6, (larguraTotal / qtdPorta) - diminuirPorta, "Porta", fita, fita, fita, fita, material);
			porta.imprimir(MODELO_SAIDA);
		}
	}

	public static void base(double larguraTotal, double altura, double profundidade, String material, double espessuraMDF) {
		double qtdPeca = 1;

		// LATERAL DA BASE
		Peca lateralBase = new Peca((int) (qtdPeca + 2), altura, profundidade - (espessuraMDF * 2), "BaseLa", 0, 0, 0, 0, material);
		lateralBase.imprimir(MODELO_SAIDA);

		// FRENTE DA BASE
		Peca frenteBase = new Peca((int) (qtdPeca + 1), altura, larguraTotal, "BaseFr", 0, 0, 0, 0, material);
		frenteBase.imprimir(MODELO_SAIDA);

	}

	public static void acabamento(double larguraTotal, double altura, double profundidade, String material, double espessuraMDF) {
		double qtdPeca = 1;

		// LATERAL DO ACABAMENTO
		Peca lateralBase = new Peca((int) (qtdPeca), altura, profundidade, "AcabLa", 0, 0, 0, 0, material);
		lateralBase.imprimir(MODELO_SAIDA);

		// FRENTE DO ACABAMENTO
		Peca frenteBase = new Peca((int) (qtdPeca), altura, larguraTotal, "AcabFr", 0, 0, 0, 0, material);
		frenteBase.imprimir(MODELO_SAIDA);

	}
}
