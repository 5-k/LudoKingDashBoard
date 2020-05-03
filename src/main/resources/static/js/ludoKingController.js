webApp.controller('ludoKingController', function($scope,service,$http ,$location,$rootScope) {
  
	$scope.tableData= [];
	$scope.previousMatches = [];
	$scope.UpcommingMatches = [];
	$scope.leaders=[];
	$scope.semifinal1 = {};
	$scope.semifinal2 = {};
	$scope.finals = {};
	
	
	service.getSemifinalScores().then(function(data) {
		console.log(data)
		$scope.semifinal1 = data.data[0];
		$scope.semifinal2 = data.data[1];
	});

	service.getFinalScores().then(function(data) {
		console.log(data)
		$scope.finals = data.data;
	});

        service.getleaderBoard().then(function(data) {
			 console.log(data);
			 $scope.tableData = data.data;
			 leaderData= [];
			 var first = {
				 'photo': data.data[0].photo,
				 'name': data.data[0].name
			 };

			 var second = {
				'photo': data.data[1].photo,
				'name': data.data[1].name
			};

			var third = {
				'photo': data.data[2].photo,
				'name': data.data[2].name
			};
			leaderData[0] = first;
			leaderData[1] = second;
			leaderData[2]=third;
			
			 $scope.leaders = leaderData;
		 },function(error) {
			console.log(error)
		 })
	

	
        
        service.getPreviousMatches().then(function(data) {
			console.log(data);
			$scope.previousMatches = data.data;
		 },function(error) {
			
			console.log(error)
		 })
        
        service.getUpcomingMatches().then(function(data) {
			console.log(data);
			 $scope.UpcommingMatches = data.data;
		 },function(error) {
			
			console.log(error)
		 })


});