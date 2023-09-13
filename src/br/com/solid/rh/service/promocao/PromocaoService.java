package br.com.solid.rh.service.promocao;

import br.com.solid.rh.ValidacaoException;
import br.com.solid.rh.model.Cargo;
import br.com.solid.rh.model.DadosPessoais;
import br.com.solid.rh.model.Funcionario;

public class PromocaoService {
	public void promover(Funcionario funcionario, boolean metaBatida) {
		DadosPessoais dadosPessoais = funcionario.getDadosPessoais();
		Cargo cargoAtual = dadosPessoais.getCargo();
		if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes n�o podem ser promovido!");
		}
		
		if (metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo );
		} else {
			throw new ValidacaoException("Funcion�rio n�o bateu a meta!");
		}
	}
}
