'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  })
  .when('/contratar', {
    templateUrl: 'view2/contratar.html',
    controller: 'ContratarCtrl'
  })
  .when('/avaliar', {
    templateUrl: 'view2/avaliar.html',
    controller: 'AvaliarCtrl'
  })
  .when('/profissional', {
    templateUrl: 'view2/profissional.html',
    controller: 'ProfissionalCtrl'
  })
  .when('/login', {
    templateUrl: 'view2/login.html',
    controller: 'LoginCtrl'
  })
  ;
}])

.controller('View2Ctrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

$scope.meses=[];
$scope.anos=[];

for (var i = 1 ; i <= 31; i++) {
	$scope.meses.push(i);
}

for (var i = 2015 ; i <= 2020; i++) {
	$scope.anos.push(i);
}




$scope.cadastrarCliente = function(){

var vencimento = $scope.selectedMonth +"/"+ $scope.selectedYear; 
$scope.user.vencimento = vencimento;

	minhaService.insert($scope.user).then(function(){

		alert("cadastrado com sucesso");

		$location.path("/contratar");
	},
	function(data){
		alert("erro ao cadastrar "+ data);
	} 
	)
}


//	$scope.redirect = function(){
//		minhaService.get({}).then(function(data){
//			$scope.view2Content = data;
//		});
//	}
}])

.controller('ContratarCtrl', ['$scope','$location', 'minhaService', '$window', function($scope, $location, minhaService, $window) {
	$scope.massagistas = {};


	var massagistas = [
	{
		id:1,
		nome : "Joelma",
		avaliacao : 5,
		especialidade: "Tantrica",
		email: "joelma@gmail.com",
		sexo: "f",
		img : "Capture2.png"
	},{
		id:2,
		nome : "Mario",
		avaliacao : 5,
		especialidade: "Tailandesa",
		email: "mario@gmail.com",
		sexo:"m",
		img : "Capture.png"
	}];
$scope.massagistas = [massagistas[0]];
	$scope.filterMassagista = function(sexo){
		if(sexo == "m"){
			$scope.massagistas = [massagistas[1]];
		}else{
			$scope.massagistas = [massagistas[0]];
		}
	}

	$scope.contratar = function(massagista){
		massagista.idCliente = 1;
console.log(massagista);
var confirmacao = $window.confirm("você tem certeza que deseja contratar esse serviço?")

if(confirmacao){
		minhaService.contratacao(massagista).then(function(){
			alert("contratacao efetuada com sucesso")
		});
	}
}

}])

.controller('ProfissionalCtrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

	$scope.cadastrarProfissional = function(){

		minhaService.insertProfissioanl($scope.user).then(function(){
			alert("cadastrado com sucesso");
		},
			function(data, message){
				alert("erro ao cadastrar "+ data);
			} 
		)
	}
}])
.controller('LoginCtrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

	$scope.login = function(){

		minhaService.login($scope.user).then(function(data){
			if(data.data.result == "massagista") {
				$location.path("/view1");
			} else if(data.data.result == "cliente") {
				$location.path("/contratar");
			}
		},
			function(data){
				alert("Login ou senha incorretos");
			} 
		)
	}
}])
.controller('AvaliarCtrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

	$scope.avaliar = function(massagem){

		minhaService.avaliar(massagem).then(function(data){
		},
			function(data, message){
				alert("erro ao cadastrar "+ data);
			} 
		)
	}
}])
;