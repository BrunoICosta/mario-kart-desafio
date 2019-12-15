angular.module("mariokart").controller("PersonagemController",
	PersonagemController);

PersonagemController.$inject = ['$scope', 'PersonagemService'];

function PersonagemController($scope, PersonagemService) {
	var vm = this;
	vm.service = PersonagemService;
	vm.personagens = [];

	vm.init = function () {
		vm.carregarPersonagens();
		vm.login = true;
		vm.home = false;
		vm.user = {};
		vm.jogadores = {};
	};

	vm.carregarPersonagens = function () {
		vm.service.getPersonagens().success(function (data) {
			vm.personagens = data;
		}).error(function (data, status) {
			vm.message = "Aconteceu um problema: " + data;
		});
	};

	vm.carregarJogadores = function () {
		vm.service.getJogador().success(function (data) {
			vm.jogadores = data;
		}).error(function (data) {
			vm.message = "Aconteceu um problema: " + data;
		});
	};
	vm.cadastrar = function () {
		vm.cadastrar = true;
		vm.login = false;
		vm.home = false;
	}
	vm.login = function () {
		vm.login = true;
		vm.cadastrar = false;
		vm.home = false;
	}
	vm.home = function () {

		vm.login = false;
		vm.cadastrar = false;
		vm.home = true;
	}
	vm.user = {
		nickname: null,
		senha: null,
		personagem: {}
	}
	vm.jogadores.nickname = {
		nickname: null,
		personagem: {}
	}
	vm.log = {
		historico: null,
	}
	vm.inserirCadastro = function () {
		vm.user.senha = btoa(vm.user.senha);
		vm.service.inserirCadastro(vm.user).then(function (response) {
			vm.login = true;
			vm.cadastrar = false;
			vm.message = "jogador inserido";
			vm.user.senha = null;

		}, function (error) {

			vm.message = "Erro ao inserir " + error;
		});
	}


	vm.autenticar = function () {
		vm.user,
			vm.user.senha = btoa(vm.user.senha);
		vm.service.autenticarJogador(vm.user).then(function (response) {
			sessionStorage.setItem("nickname", vm.user.nickname);
			var nickname = sessionStorage.getItem("nickname");
			vm.message = "Bem vindo a corrida mario kart " + nickname;
			vm.home = true;
			vm.login = false;
			vm.cadastrar = false;
			vm.carregarJogadores();


		}, function (error) {
			alert(vm.user.nickname + '/' + vm.user.senha);
			vm.message = "Ops! Seu nickname ou senha estão incorretos!" + error;
		});
	}

	vm.sair = function () {
		vm.home = false;
		vm.login = true;
		vm.cadastrar = false;
		sessionStorage.removeItem("nickname");
	}
}