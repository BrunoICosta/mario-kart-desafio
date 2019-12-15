angular.module("mariokart").factory("PersonagemService", function ($http) {
	var baseUrl = 'http://localhost:8080/mario-kart-desafio-final/personagem';

	var baseUrlCadastrar = 'http://localhost:8080/mario-kart-desafio-final/jogador';

	var baseUrlAutenticar = 'http://localhost:8080/mario-kart-desafio-final/jogador/autenticar';

	var baseUrlJogadores = 'http://localhost:8080/mario-kart-desafio-final/jogador';

	var _getPersonagens = function () {
		return $http.get(baseUrl);
	};

	var _getJogador = function () {
		return $http.get(baseUrlJogadores);
	};

	var _postJogador = function (user) {
		return $http.post(baseUrlCadastrar, user);
	};

	var _postJogadorAutenticar = function (user) {
		return $http.post(baseUrlAutenticar, user);
	};


	return {
		getPersonagens: _getPersonagens,
		inserirCadastro: _postJogador,
		autenticarJogador: _postJogadorAutenticar,
		getJogador: _getJogador,
		getBatalha: _getBatalha
	};
});