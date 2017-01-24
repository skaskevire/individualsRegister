<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title><spring:message code="view.title" /></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="individualRegisterServiceApplication" class="ng-cloak">
	<div class="generic-container" ng-controller="UserController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead"><spring:message
						code="view.user.registration.form" /></span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.user.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="firstName"><spring:message
									code="view.user.registration.input.firstName" /></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.firstName" id="firstName"
									class="username form-control input-sm"
									placeholder='<spring:message code="view.user.registration.backgroundValidationMessage.firstName" />'
									required ng-minlength="3" ng-maxlength="20" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="middleName"><spring:message
									code="view.user.registration.input.middleName" /></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.middleName"
									id="middleName" class="c_middlename form-control input-sm"
									placeholder='<spring:message code="view.user.registration.backgroundValidationMessage.middleName" />'
									required ng-minlength="3" ng-maxlength="20" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="lastName"><spring:message
									code="view.user.registration.input.lastName" /></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.lastName" id="lastName"
									class="c_lastname form-control input-sm"
									placeholder='<spring:message code="view.user.registration.backgroundValidationMessage.lastName" />'
									required ng-minlength="3" ng-maxlength="20" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="birthDate"><spring:message
									code="view.user.registration.input.birthDate" /></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.birthDate" id="birthDate"
									class="c_birthdate form-control input-sm" ng-pattern="/(0[1-9]|1[012])[- \/.](0[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d/"
									placeholder='<spring:message code="view.user.registration.backgroundValidationMessage.birthDate" />'
									required></input>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.user.id ? '<spring:message code="view.user.registration.input.submit.add" />' : '<spring:message code="view.user.registration.input.submit.update" />'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">
								<spring:message code="view.user.registration.input.submit.reset" />
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">'<spring:message
						code="view.user.registration.table.header" /></span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message
									code="view.user.registration.table.header.firstName" /></th>
							<th><spring:message
									code="view.user.registration.table.header.middleName" /></th>
							<th><spring:message
									code="view.user.registration.table.header.lastName" /></th>
							<th><spring:message
									code="view.user.registration.table.header.birthDate" /></th>
							<th><spring:message
									code="view.user.registration.table.header.inn" /></th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.users">
							<td><span ng-bind="u.firstName"></span></td>
							<td><span ng-bind="u.middleName"></span></td>
							<td><span ng-bind="u.lastName"></span></td>
							<td><span ng-bind="u.birthDate"></span></td>
							<td><span
								ng-if="u.inn == 0 && ( u.innRequestId != 0 && u.innRequestId != null )"><spring:message
										code="view.user.registration.table.body.inn.status.requested" /></span><span
								ng-if="u.inn == 0 && (u.innRequestId == 0 || u.innRequestId == null)"><spring:message
										code="view.user.registration.table.body.inn.status.none" /></span><span
								ng-if="u.inn != 0" ng-bind="u.inn"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">
									<spring:message
										code="view.user.registration.table.body.buttons.edit" />
								</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">
									<spring:message
										code="view.user.registration.table.body.buttons.remove" />
								</button>
								<button ng-if="u.innRequestId == 0 || u.innRequestId == null"
									type="button" ng-click="ctrl.requestINN(u.id)"
									class="btn btn-danger custom-width">
									<spring:message
										code="view.user.registration.table.body.buttons.request.inn" />
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/js/app.js' />"></script>
	<script src="<c:url value='/js/service/user_service.js' />"></script>
	<script src="<c:url value='/js/controller/user_controller.js' />"></script>
</body>
</html>
