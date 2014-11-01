var app = angular.module("myNoteApp", []);

app.controller("createGossipController", function($scope) {
    $scope.message = "";
    $scope.left  = function() {return 100 - $scope.message.length;};
    $scope.clear = function() {$scope.message = "";};
    $scope.save  = function() {alert("Note Saved");};
});

app.controller('ListGossipController', ['$scope', function($scope) {  
      $scope.gossip = {
        content: 'costa coffe at sony world is damn expensive',
        latitude: '34.435423231',
        longitude: '67.825423231'
      };
    }])

	app.directive('gossips', function() {
      return {
        template: 'Content: {{gossip.content}} Address: {{gossip.longitude}}'
      };
    });

