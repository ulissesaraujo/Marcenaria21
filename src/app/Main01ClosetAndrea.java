package app;

public class Main01ClosetAndrea {

	public static void main(String[] args) {
		String material = "7009"; // 7009 - MDF Branco; 5974 - Dutatex, linha trama, o Grafite; 8199-Duratex Azul Secreto
		// medidas em Milimetros
		double espessuraMDF = 15;
		double peDireito = 2670;
		double retirarAcabamento = 90; 
		double retirarBase = 80;
		double alturaArmario = peDireito - (retirarAcabamento + retirarBase);  // 2500
		double larguraTotal = 730; // largura total
		double larguraTotalBase = 0; // largura total
		double qtdPrateleira = 1;
		double profundidadeArmario = 500;
		double profundidadeRodape = 12; // recuo da base inferior (0 se não tiver)
		double qtdPorta = 0;
		boolean dobradicaReta = true;
		boolean comRodizio = false;

		// Peca.descricao();
		// GABINETE01
		larguraTotalBase = larguraTotalBase+larguraTotal;
		Gabinete.normal(larguraTotal, alturaArmario, profundidadeArmario, profundidadeRodape, material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, false, false);

		// GAVETEIRO
		double alturaGaveteiro = 800;
		double alturaGaveteiraCorrecao = 0; // se precisar aumentar ou diminir a altura. Vai ser calculado em função da altura/QtdGavetas
		double profundidadeGaveteiro = 500; // tamanho da corrediças
		double qtdGavetas = 4;
		boolean utilizarGabinete = true;
		// se tiver que fazer o espaçamento do gaveteira para porta trocar o 0 para "1" (se porta de correr) "2" para porta com dobradiça
		// não casa se o armário/closet não tiver porta, pode deixar 0
		double diminuirLarguraEspacamentoPorta = espessuraMDF * 0;
		Gaveteiro.normal(larguraTotal - (espessuraMDF * 2) - diminuirLarguraEspacamentoPorta, alturaGaveteiro, alturaGaveteiraCorrecao, qtdGavetas, profundidadeGaveteiro, profundidadeArmario, espessuraMDF, material,
				utilizarGabinete, false);

		// System.out.println();
		// GABINETE02
		larguraTotalBase = larguraTotalBase+larguraTotal;
		Gabinete.normal(larguraTotal, alturaArmario, profundidadeArmario, profundidadeRodape, material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, false, false);

		// GAVETEIRO02
		Gaveteiro.normal(larguraTotal - (espessuraMDF * 2) - diminuirLarguraEspacamentoPorta, alturaGaveteiro, alturaGaveteiraCorrecao, qtdGavetas, profundidadeGaveteiro, profundidadeArmario, espessuraMDF, material,
				utilizarGabinete, false);

		// System.out.println();
		// GABINETE03
		qtdPrateleira=3;
		larguraTotalBase = larguraTotalBase+larguraTotal;
		// FIXME Ulisses(11 de jun. de 2026) - ver se a lateral vai até ao final
		Gabinete.normal(larguraTotal, alturaArmario, profundidadeArmario, profundidadeRodape, material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, false, false);

		// GAVETEIRO03
		//		alturaGaveteiro = 600;
		//		alturaGaveteiraCorrecao = 30; // se precisar aumentar ou diminir a altura. Vai ser calculado em função da altura/QtdGavetas
		//		profundidadeGaveteiro = 500; // tamanho da corrediças
		//		qtdGavetas = 4;
		//		Gaveteiro.normal(larguraTotal - (espessuraMDF * 2) - diminuirLarguraEspacamentoPorta, alturaGaveteiro, alturaGaveteiraCorrecao, qtdGavetas, profundidadeGaveteiro, espessuraMDF, material, utilizarGabinete);

		Gabinete.base(larguraTotalBase, retirarBase, profundidadeArmario-50, material, espessuraMDF);
		Gabinete.acabamento(larguraTotalBase-espessuraMDF, retirarAcabamento, profundidadeArmario + profundidadeRodape, material, espessuraMDF);
	}
}
