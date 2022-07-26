angular.module('resume', []).controller('resumeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/resume-core'

    $scope.createNewResume = function () {
        console.log($scope.newUser);
        $http.post('http://localhost:8888/resume-core/api/v1/users', $scope.newUser)
            .then(function response(){
                $scope.newUser = null;
            });
        console.log($scope.newResume);
        $http.post('http://localhost:8888/resume-core/api/v1/resumes', $scope.newResume)
            .then(function response(){
                $scope.newResume = null;
            });
        console.log($scope.newEducation);
        $http.post('http://localhost:8888/resume-core/api/v1/educations', $scope.newEducation)
            .then(function response(){
                $scope.newEducation = null;
            });
        console.log($scope.newWork);
        $http.post('http://localhost:8888/resume-core/api/v1/works', $scope.newWork)
            .then(function response(){
                $scope.newWork = null;
            });
    }


});
