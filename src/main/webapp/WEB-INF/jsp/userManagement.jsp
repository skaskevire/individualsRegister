<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="firstName">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.firstName" id="firstName" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.firstName.$error.required">This is a required field</span>
                                      <span ng-show="myForm.firstName.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.firstName.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="middleName">Middle Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.middleName" id="middleName" class="form-control input-sm" placeholder="Enter your middleName [This field is validation free]"/>
                              </div>
                          </div>
                      </div>  
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="lastName">Last Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.lastName" id="lastName" class="form-control input-sm" placeholder="Enter your lastName [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
                      
                      
                     <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="birthDate">Birth Date (MM/YY/DDDD)</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.birthDate" ng-pattern="/(0[1-9]|1[012])[- \/.](0[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d/" id="birthDate" class="form-control input-sm" placeholder="Enter your date of birth [This field is validation free]" required></input>
                              		<div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.birthDate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.birthDate.$error.pattern">You have inserted a wrong date</span>
                                      <span ng-show="myForm.birthDate.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>First Name</th>
                              <th>Middle Name</th>
                              <th>Last Name</th>
                              <th>Birth Date</th>
                              <th>FSIN ID</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.firstName"></span></td>
                              <td><span ng-bind="u.middleName"></span></td>
                              <td><span ng-bind="u.lastName"></span></td>
                               <td><span ng-bind="u.birthDate"></span></td>
                                <td><span ng-if="u.fnsId == 0 && ( u.fnsidRequestId != 0 && u.fnsidRequestId != null )">REQUESTED</span><span ng-if="u.fnsId == 0 && (u.fnsidRequestId == 0 || u.fnsidRequestId == null)">NONE</span><span ng-if="u.fnsId != 0" ng-bind="u.fnsId"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button> <button ng-if="u.fnsidRequestId == 0 || u.fnsidRequestId == null" type="button" ng-click="ctrl.initiateFSN(u.id)" class="btn btn-danger custom-width">Initiate FSN</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/js/app.js' />"></script>
      <script src="<c:url value='/js/service/user_service.js' />"></script>
      <script src="<c:url value='/js/controller/user_controller.js' />"></script>
  </body>
</html>
