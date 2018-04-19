myApp.controller('studentController', function (studentService,$scope,$http,$location,$route) {
	
	$scope.students = [];
	
	var backEndUrl = "http://localhost:8080/student";
	
    $scope.IsHidden = true;
    $scope.first = false;

    $scope.toggle = function() {
      $scope.first = !$scope.first;
    }
    
    $scope.ShowHide = function () {
        $scope.IsHidden = $scope.IsHidden ? false : true;
         $scope.first = false;
    }

    function loadData() {
        $http.get(backEndUrl)
            .then(function (response) {
                $scope.students = response.data;
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
				$scope.IsHidden=true;
				loadData();
				$scope.uservo = [];
					return response.data;
				}
		).catch(function(error) {
            $scope.error = error;
        });
	}

	 $scope.update=function(uservo){
          	$http.put(backEndUrl +'/update/'+uservo.id,uservo)
          	.then(
      				function(response){
      				$route.reload();
      					return response.data;
      				}
      		).catch(function(error) {
                  $scope.error = error;
              });
          }
    
  $scope.remove=function(index){
  	   var student = $scope.students[index];
      	$http.delete(backEndUrl +'/remove/'+student.id)
      	.then(
  				function(response){
  				$route.reload();
  					return response.data;
  				}
  		).catch(function(error) {
              $scope.error = error;
          });
      }
  
  $scope.updateStudent = function(index){
   $scope.first = true;
    $scope.truefalse = true;
	  $scope.uservo = $scope.students[index];
//	  emloyeeService.set(uservo);
	  $scope.IsHidden=false;

  }
});