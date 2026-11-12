package app;

import static app.Constantes.*;

public class Gaveteiro {

	public static void normal(double larguraTotal, double altura, double alturaGaveteiraCorrecao, double qtdGavetas, 
			double profundidade, double profundidadeArmario, double espessuraMDF, String material, boolean utilizarGabinete, boolean calcularFundo) {
		
		// Validação: corrediça não pode ser maior que a profundidade do armário
		if (profundidade > profundidadeArmario) {
			throw new IllegalArgumentException("Profundidade do gaveteiro (" + profundidade + ") não pode ser maior que a profundidade do armário (" + profundidadeArmario + ")");
		}
		
		double alturaGaveta = ((altura - (espessuraMDF * 2) - VAO_ULTIMA_GAVETA_10 - ESPESSURA_FUNDO_GAVETA_6) / qtdGavetas) - VAO_ENTRE_GAVETAS_38_5 - alturaGaveteiraCorrecao;
		double tamanhoSarrafo = larguraTotal - (espessuraMDF * 2); // largura interna do gaveteiro

		if (utilizarGabinete) {
			Peca pecaSarrafo = new Peca(4, tamanhoSarrafo, LARGURA_SARRAFO_100, "GSarraf", 0, 0, 0, 0, material);
			Peca lateralGaveta = new Peca(2, altura, profundidade, "GLatera", 0, 0, 0, 0, material);
			Peca gavetaLateral = new Peca((int) (qtdGavetas * 2), profundidade, alturaGaveta, "GLatGav", 0, 0, 0, 0, material);
			Peca gavetaFrente = new Peca((int) (qtdGavetas * 2), tamanhoSarrafo - (2 * ESPACAMENTO_CORREDICA_12_5) - (espessuraMDF * 2), alturaGaveta, "GFreGav", 0, 0, 0, 0, material);

			pecaSarrafo.imprimir(MODELO_SAIDA);
			lateralGaveta.imprimir(MODELO_SAIDA);
			gavetaLateral.imprimir(MODELO_SAIDA);
			gavetaFrente.imprimir(MODELO_SAIDA);

		} else {
			tamanhoSarrafo = tamanhoSarrafo + (espessuraMDF * 2);
			Peca gavetaLateral = new Peca((int) (qtdGavetas * 2), profundidade, alturaGaveta, "GLatGav", 0, 0, 0, 0, material);
			Peca gavetaFrente = new Peca((int) (qtdGavetas * 2), tamanhoSarrafo - (2 * ESPACAMENTO_CORREDICA_12_5) - (espessuraMDF * 2), alturaGaveta, "GFreGav", 0, 0, 0, 0, material);

			gavetaLateral.imprimir(MODELO_SAIDA);
			gavetaFrente.imprimir(MODELO_SAIDA);
		}

		// FUNDO DA GAVETA (mdf branco 6 mm)
		if (calcularFundo) {
			double larguraFundo = tamanhoSarrafo - (2 * ESPACAMENTO_CORREDICA_12_5) - (espessuraMDF * 2);
			double profundidadeFundo = profundidade - ESPESSURA_FUNDO_GAVETA_6;
			Peca fundoGaveta = new Peca((int) qtdGavetas, larguraFundo, profundidadeFundo, "GFundo", 0, 0, 0, 0, "BR6mm");
			fundoGaveta.imprimir(MODELO_SAIDA);
		}
	}
}
