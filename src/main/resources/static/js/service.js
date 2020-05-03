webApp.service('service', function($http,$q,$log,$rootScope){
    
    this.getleaderBoard = function() {
       
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:"/api/leaderBoard"
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
    this.getFinalScores = function() {
       
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:"/api/finals"
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
    this.getSemifinalScores = function() {
       
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:"/api/semifinals"
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
	};

	this.getPreviousMatches = function() {
        
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:"/api/previousMatches"
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
	};

	this.getUpcomingMatches = function() {
        
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:"/api/upcommingMatches"
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
});
