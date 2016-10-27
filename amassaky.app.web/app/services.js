﻿angular.module('myApp.services', [])

.service('minhaService', ['$http', function ($http) {

    var self = this;

    self.get = function(params){
    	return $http({
    		method : 'get',
    		url : '/view2',
    		params : params
    	})
    }

    self.insert = function(params){
    	return $http({
    		method : 'post',
    		url : '/api/get',
    		data : params
    	})
    }

    self.update = function(params){
    	return $http({
    		method : 'put',
    		url : '/api/get',
    		data : params
    	})
    }

    self.delete = function(params){
    	return $http({
    		method : 'delete',
    		url : '/api/get',
    		params : params
    	})
    }
}]);