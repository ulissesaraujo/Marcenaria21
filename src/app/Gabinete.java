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
	 * @param comFitamento true=aplica fita conforme regras, false=sem fita
	 * @param fitaParede true=f2 com fita (armário isolado), false=f2 sem fita (encosta na parede)
	 */
	public static void normal(double larguraTotal, double altura, double profundidadeArmario, double profundidadeRodape, 
			String material, double espessuraMDF, double qtdPrateleira, double qtdPorta, boolean dobradicaReta, boolean comRodizio, boolean comFitamento, boolean fitaParede) {
		
		validarQuantidaPorta(qtdPorta);
		double larguraInterna = larguraTotal - (espessuraMDF * 2);
		double qtdPeca = 1;

		// Ajuste para rodízio: lateral menor, base maior
		double alturaLateral = comRodizio ? altura - (espessuraMDF * 2) : altura;
		double larguraBase = comRodizio ? larguraTotal : larguraInterna;
		double profundidadeTotal = profundidadeArmario + profundidadeRodape;

		// LATERAL
		// Sem rodízio: 1,0,1,1 | Com rodízio: 1,0,0,0
		int f1 = comFitamento ? 1 : 0;
		int f2 = comFitamento && fitaParede ? 1 : 0;
		int f3 = comFitamento && !comRodizio ? 1 : 0;
		int f4 = comFitamento && !comRodizio ? 1 : 0;
		Peca lateral = new Peca((int) (qtdPeca + 1), alturaLateral, profundidadeTotal, "Lateral", f1, f2, f3, f4, material);
		lateral.imprimir(MODELO_SAIDA);

		// BASE
		// Sem rodízio: 1,0,0,0 | Com rodízio: 1,0,1,1
		f1 = comFitamento ? 1 : 0;
		f2 = comFitamento && fitaParede ? 1 : 0;
		f3 = comFitamento && comRodizio ? 1 : 0;
		f4 = comFitamento && comRodizio ? 1 : 0;
		if (profundidadeRodape == 0) {
			// Sem rodapé: base única
			Peca base = new Peca((int) (qtdPeca + 1), larguraBase, profundidadeArmario, "Base", f1, f2, f3, f4, material);
			base.imprimir(MODELO_SAIDA);
		} else {
			// Com rodapé: base superior (profundidade total) e base inferior (recuada)
			Peca baseSup = new Peca((int) (qtdPeca), larguraBase, profundidadeTotal, "BaseSup", f1, f2, f3, f4, material);
			baseSup.imprimir(MODELO_SAIDA);
			Peca baseInf = new Peca((int) (qtdPeca), larguraBase, profundidadeArmario, "BaseInf", f1, f2, f3, f4, material);
			baseInf.imprimir(MODELO_SAIDA);
		}

		// PRATELEIRA (sempre usa larguraInterna, não muda com rodízio)
		// Sempre: 1,0,0,0
		if (qtdPrateleira > 0) {
			f1 = comFitamento ? 1 : 0;
			f2 = comFitamento && fitaParede ? 1 : 0;
			f3 = 0;
			f4 = 0;
			Peca prateleira = new Peca((int) (qtdPrateleira), larguraInterna, profundidadeTotal, "Pratele", f1, f2, f3, f4, material);
			prateleira.imprimir(MODELO_SAIDA);
		}

		// PORTA (sempre usa altura original, não muda com rodízio)
		// Sempre: 1,1,1,1
		if (qtdPorta != 0) {
			double diminuirDobradica = dobradicaReta ? DESCONTO_DOBRADICA_RETA_1 : DESCONTO_DOBRADICA_CURVA_7;
			double diminuirPorta = diminuirDobradica + VAO_ENTRE_PORTAS_3;
			int fita = comFitamento ? 1 : 0;
			Peca porta = new Peca((int) (qtdPorta), altura - DESCONTO_ALTURA_PORTA_6, (larguraTotal / qtdPorta) - diminuirPorta, "Porta", fita, fita, fita, fita, material);
			porta.imprimir(MODELO_SAIDA);
		}
	}


	private static void validarQuantidaPorta(double qtdPorta) {
		if (qtdPorta < 0 || qtdPorta > 2) {
			throw new IllegalArgumentException("Quantidade de portas inválida");
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
