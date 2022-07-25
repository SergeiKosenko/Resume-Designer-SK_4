angular.module('resume', []).controller('resumeListController', function ($scope, $http) {
    $scope.loadResumes = function () {
        $http.get('http://localhost:8888/resume-core/api/v1/resumes')
            .then(function (response) {
                $scope.resumes = response.data;
            });
    };

    $scope.viewResume = function (id) {
        $http.get('http://localhost:8888/resume-core/api/v1/resumes/' + id)
            .then(function (response) {
				$scope.resume = response.data;
            });
    }

    $scope.loadResumes();
});