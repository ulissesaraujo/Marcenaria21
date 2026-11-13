package app;

/**
 * TEMPLATE PARA NOVOS PROJETOS
 * 
 * Como usar:
 * 1. Copie este arquivo
 * 2. Renomeie para MainXX_NomeProjeto.java (ex: Main03_CozinhaMaria.java)
 * 3. Ajuste as configurações abaixo
 * 4. Descomente os módulos que precisar
 * 5. Execute e copie o resultado para o app de plano de corte
 */
public class Main00Template {

	public static void main(String[] args) {
		
		// ══════════════════════════════════════════════════════════════════
		// CONFIGURAÇÃO GERAL DO PROJETO
		// ══════════════════════════════════════════════════════════════════
		
		// Material: 7009=Branco, 5974=Grafite Duratex, 8199=Azul Secreto
		String material = "7009";
		
		// Espessura do MDF (mm) - comum: 15, 18
		double espessuraMDF = 15;
		
		// Medidas do espaço (mm)
		double peDireito = 2660;        // altura total disponível
		double acabamentoSuperior = 80; // altura do acabamento que fecha o vão entre armário e teto (0 se não tiver)
		double alturaBase = 80;         // altura da base/pés que levanta o armário do chão (0 se não tiver)
		
		// Altura padrão do armário (calculado) = 2500mm
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
		boolean comRodizio = false;
		
		
		// ══════════════════════════════════════════════════════════════════
		// GABINETE - VALORES PADRÃO
		// ══════════════════════════════════════════════════════════════════
		
		double largura = larguraPadrao;
		double altura = alturaPadrao;
		double profundidade = profundidadeArmario;
		double qtdPrateleira = 0;
		double qtdPorta = 2;  // 0=sem porta, 1=porta única, 2=porta dupla
		boolean comFitamento = true;  // true=aplica fita conforme regras, false=sem fita
		boolean fitaParede = false;   // true=f2 com fita (armário isolado), false=f2 sem fita (encosta na parede)
		
		
		// ══════════════════════════════════════════════════════════════════
		// GABINETE 01
		// ══════════════════════════════════════════════════════════════════
		
		// altere aqui o que for diferente do padrão
		
		Gabinete.normal(largura, altura, profundidade, profundidadeRodape, 
				material, espessuraMDF, qtdPrateleira, qtdPorta, dobradicaReta, comRodizio, comFitamento, fitaParede);
		
		// ══════════════════════════════════════════════════════════════════
		// GAVETEIRO - VALORES PADRÃO
		// ══════════════════════════════════════════════════════════════════
		
		double alturaGaveteiro = 800;
		double qtdGavetas = 4;
		double profundidadeGaveteiro = profundidadeArmario-50;  // tamanho da corrediça (não pode ser maior que profundidadeArmario), ideal ser 50mm menor que a profundidade
		double correcaoAltura = 0;           // ajuste fino na altura das gavetas
		boolean utilizarGabinete = true;     // true=dentro de gabinete, false=solto
		boolean calcularFundo = false;       // true=calcula fundo (mdf branco 6 mm), false=não calcula
		double espacoPorta = espessuraMDF * qtdPorta;  // 0=sem porta(closet), 1=correr, 2=dobradiça
		boolean temGaveteiro = false;         // true=calcula gaveteiro, false=não calcula
		
		
		// ══════════════════════════════════════════════════════════════════
		// GAVETEIRO 01
		// ══════════════════════════════════════════════════════════════════
		
		// altere aqui o que for diferente do padrão
		
		if (temGaveteiro) {
			Gaveteiro.normal(largura - (espessuraMDF * 2) - espacoPorta, 
					alturaGaveteiro, correcaoAltura, qtdGavetas, 
					profundidadeGaveteiro, profundidadeArmario, espessuraMDF, material, utilizarGabinete, calcularFundo);
		}
		
	}
}
