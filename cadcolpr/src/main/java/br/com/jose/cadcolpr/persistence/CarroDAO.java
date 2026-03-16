package br.com.jose.cadcolpr.persistence;

import java.util.List;

import br.com.jose.cadcolpr.domain.Carro;

public class CarroDAO extends GenericDAO<Carro> {

	public CarroDAO() {
		super(Carro.class);
	}

	public void apagarByCpf(String cpf) {

		String sql = " o.id.cpf = " + cpf;
		List<Carro> carros = listar(sql);
		for (Carro carro : carros) {
			apagar(carro.getId());
		}

	}

}
