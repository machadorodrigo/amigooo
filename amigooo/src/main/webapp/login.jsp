<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="assets/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="assets/css/login.css">
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<title>Bem vindo ao Amigooo!</title>
</head>
<body>
	<div class="row-fluid">
		<div class="span3 offset2"></div>
		<div class="span3 offset3">
			<form class="form-signin" method="post">
				<h3 class="form-signin-heading">Acessar o Amigooo!</h3>
				<input type="text" class="input-block-level" placeholder="E-mail">
				<input type="password" class="input-block-level" placeholder="Senha">
				<label class="checkbox">
					<input type="checkbox">Lembrar senha
				</label> 
				<button type="submit" class="btn btn-primary btn-large">
  					<i class="icon-ok-sign icon-white"></i> Entrar
				</button>
			</form>
		</div>
	</div>
</body>
</html>