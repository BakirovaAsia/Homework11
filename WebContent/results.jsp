<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

<meta charset="UTF-8">
<title>Caucus Calculator | RESULTS</title>
<style>
body {
	min-height: 100vh;
}
</style>
</head>
<body class="has-background-grey-lighter">
	<section class="hero is-dark is-small">
		<div class="hero-body">
			<div class="level">
				<div class="level-left">
					<h1 class="title">Caucus Calculator</h1>
				</div>
				<div class="level-right">
					<a class="button" href="index.jsp">Start Over</a>
				</div>
			</div>
		</div>
	</section>
	<c:choose>
		<c:when test="${caucus.getIsValid() }">
			<section class="column is-three-fifths is-offset-one-fifth">
				<label class="label">
					<h1 class="title">RESULTS</h1>
				</label>
				<div class="box">
					<label class="label">Precinct Name: ${caucus.getName()}</label> <label
						class="label">Total Participants:
						${caucus.getNumParticipants()}</label>


					<table
						class="table is-fullwidth is-bordered is-striped is-hoverable">
						<thead>
							<tr>
								<th>Candidate</th>
								<th>Votes</th>
								<th>Percent</th>
								<th>Delegates</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="candidate" items="${caucus.getCandidates()}">
								<tr>
									<td><c:out value="${candidate.getName()}" /></td>
									<td><c:out value="${candidate.getVotes()}" /></td>
									<td><fmt:formatNumber type="percent" minFractionDigits="2"
											value="${candidate.getVotes()/caucus.getNumParticipants()}" /></td>
									<td><c:out value="${candidate.getDelegates()}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>

		</c:when>

		<c:otherwise>

			<section class="column is-half is-offset-one-quarter">
				<div class="box">
					<h1 class="title" style="color: red">INVALID</h1>
					<h2 class="subtitle">
						<c:out value="${caucus.getErrors() }"></c:out>
					</h2>
				</div>
			</section>
		</c:otherwise>
	</c:choose>
</body>
</html>