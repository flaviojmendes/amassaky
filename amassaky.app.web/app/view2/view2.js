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
		nome : "joelma",
		avaliacao : 5,
		especialidade: "tantrica",
		email: "joelma@gmail.com",
		sexo: "f",
		img : "Capture2.png"
	},{
		id:2,
		nome : "mario",
		avaliacao : 5,
		especialidade: "tailandesa",
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
;