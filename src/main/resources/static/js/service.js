webApp.service('service', function($http,$q,$log,$rootScope){
    
    this.getleaderBoard = function(version) {
       
        var uri= '';
        if(version == 1) {
            uri = '/v1/api/leaderBoard';
        } else if(version == 2) {
            uri = '/v2/api/leaderBoard';
        } else if(version == 3) {
            uri = '/v3/api/leaderBoard';
        }

        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:uri
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
    this.getFinalScores = function(version) {
       
        var uri= '';
        if(version == 1) {
            uri = '/v1/api/finals';
        } else if(version == 2) {
            uri = '/v2/api/finals';
        } else if(version == 3) {
            uri = '/v3/api/finals';
        }
       
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url: uri
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
    this.getSemifinalScores = function(version) {
       
        var uri= '';
        if(version == 1) {
            uri = '/v1/api/semifinals';
        } else if(version == 2) {
            uri = '/v2/api/semifinals';
        } else if(version == 3) {
            uri = '/v3/api/semifinals';
        }
       
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url: uri
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
	};

	this.getPreviousMatches = function(version) {
       
        var uri= '';
        if(version == 1) {
            uri = '/v1/api/previousMatches';
        } else if(version == 2) {
            uri = '/v2/api/previousMatches';
        } else if(version == 3) {
            uri = '/v3/api/previousMatches';
        }
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url: uri
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
	};

	this.getUpcomingMatches = function(version) {
       
        var uri= '';
        if(version == 1) {
            uri = '/v1/api/upcommingMatches';
        } else if(version == 2) {
            uri = '/v2/api/upcommingMatches';
        } else if(version == 3) {
            uri = '/v3/api/upcommingMatches';
        }
        
        var deferred = $q.defer();
        $http({
            method:"GET", 
            url:uri
        }).
        then(function(data,status,header,config){
            deferred.resolve(data);
        },function(error){
        	 deferred.reject(error);
        });
        
        return deferred.promise
    };
    
});
