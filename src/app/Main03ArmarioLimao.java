package app;

/**
 * Projeto: Armário Limão
 */
public class Main03ArmarioLimao {

	public static void main(String[] args) {
		
		// ══════════════════════════════════════════════════════════════════
		// CONFIGURAÇÃO GERAL DO PROJETO  12/11/2026
		// ══════════════════════════════════════════════════════════════════
		
		// Material: 7009=Branco, 5974=Grafite Duratex, 8199=Azul Secreto
		String material = "7009";
		
		// Espessura do MDF (mm) - comum: 15, 18
		double espessuraMDF = 15;
		
		// Medidas do espaço (mm)
		double peDireito = 1830;        // altura total disponível
		double acabamentoSuperior = 0; // altura do acabamento que fecha o vão entre armário e teto (0 se não tiver)
		double alturaBase = 0;         // altura da base/pés que levanta o armário do chão (0 se não tiver)
		
		// Altura padrão do armário (calculado) = 1830mm
		double alturaPadrao = peDireito - acabamentoSuperior - alturaBase;
		
		// Profundidade do armário (mm) - comum: 200, 300, 350, 450 - depende do espaço e uso
		double profundidadeArmario = 450;
		
		// Profundidade do rodapé (mm) - recuo da base inferior em relação à frente do armário (0 se não tiver, 12 é comum)
		double profundidadeRodape = 0;
		
		// Largura padrão dos módulos (mm) - cada módulo pode ter sua própria largura se precisar
		double larguraPadrao = 910;
		
		// Tipo de dobradiça: true=reta (desconto 1mm), false=curva (desconto 7mm)
		boolean dobradicaReta = true;
		
		// Rodízio: true=base maior para rodízios (lateral menor), false=padrão suspenso (para lateral não forçar a base onde é parafusado e cair para frente)
		boolean comRodizio = true;
		
		
		// ══════════════════════════════════════════════════════════════════
		// GABINETE - VALORES PADRÃO
		// ══════════════════════════════════════════════════════════════════
		
		double largura = larguraPadrao;
		double altura = alturaPadrao;
		double profundidade = profundidadeArmario;
		double qtdPrateleira = 2;
		double qtdPorta = 2;  // 0=sem porta, 1=porta única, 2=porta dupla
		boolean fitamentoPorta = true;  // true=fita nos 4 lados da porta, false=sem fita
		
		
		// ══════════════════════════════════════════════════════════════════
		// GABINETE 01
		// ══════════════════════════════════════════════════════════════════
		
		// altere aqui o que for diferente do padrão
		
		Gabinete.normal(largura, altura, profundidade, profundidadeRodape, 
				material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, fitamentoPorta);
		
	}
}
