'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope','$location', 'minhaService', function($scope, $location, minhaService) {

	$scope.redirect = function(){
		minhaService.get({}).then(function(data){
			$scope.view2Content = data;
		});
	}
}]);