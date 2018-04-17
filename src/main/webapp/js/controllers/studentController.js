myApp.controller('studentController', function (studentService,$scope,$http,$location,$route) {
	
	$scope.employees = [];
	
	var backEndUrl = "http://localhost:8080/student";
	
    $scope.IsHidden = true;
    
    $scope.ShowHide = function () {
        $scope.IsHidden = $scope.IsHidden ? false : true;
    }
    
    function loadData() {
        $http.get(backEndUrl)
            .then(function (response) {
                $scope.employees = response.data;
            })
            .catch(function(error) {
                $scope.error = error;
            });
    }
    loadData();
    
    $scope.save = function(uservo) {

    	$http.post(backEndUrl+"/save",uservo)
    	.then(
				function(response){
				$route.reload();
					return response.data;
				}

		).catch(function(error) {
            $scope.error = error.data.message;
        });
		
	}
    
  $scope.remove=function(index){
  	   var employee = $scope.employees[index];
      	$http.delete(backEndUrl +'/remove/'+employee.id)
      	.then(
  				function(response){
  				$route.reload();
  					return response.data;
  				}
  		).catch(function(error) {
              $scope.error = error;
          });
      }
  
  $scope.updateEmployee = function(index){
	  $scope.uservo = $scope.employees[index];
//	  emloyeeService.set(uservo);
	  $scope.IsHidden=false;
  }
  
 /*$scope.login=function(userData){
	  $location.path("/employee");
  }*/
  
});