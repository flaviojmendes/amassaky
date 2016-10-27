'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

var validarUsuario = fucntion(){

}

$scope.cadastrarCliente = function(){
	console.log($scope.user);
}


//	$scope.redirect = function(){
//		minhaService.get({}).then(function(data){
//			$scope.view2Content = data;
//		});
//	}
}]);