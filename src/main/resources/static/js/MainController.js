  
webApp.controller('MainController', function($scope, $location,$rootScope) {
    
    if(null != localStorage.getItem("userId") && null != localStorage.getItem("userEmail")) {
        $rootScope.isLoggedIn = true;
    }
    
    $scope.logout = function() {
        $rootScope.removeLocalStorageVariables(true);
    }
    
    $scope.login =function() {
        $location.path('/login').replace();
    }
    
    $scope.about =function() {
        $location.path('/about').replace(); 
    }

   $scope.home = function() {
       $location.path('/profile').replace();
   }
});