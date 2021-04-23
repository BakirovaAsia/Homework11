<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>

<!DOCTYPE html>
<html>

<head>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css"
>

<meta charset="UTF-8">
<title>Caucus Calculator | CALCULATOR</title>
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
					<a
						class="button"
						href="index.jsp"
					>Start Over</a>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<section class="column is-three-fifths is-offset-one-fifth">
			<form
				method="POST"
				action="GetResults"
			>

				<div class="box ">
					<div class="field">
						<label class="label">Precinct Name</label>
						<div class="field-body">
							<div class="field">
								<div class="control">
									<input
										name="precinctName"
										class="input"
										type="text"
										placeholder="Name"
									>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<label class="label">Number of Participants</label>
						<div class="field-body">
							<div class="field">
								<div class="control">
									<input
										class="input"
										type="text"
										name="numParticipants"
										placeholder="Participants"
									>
								</div>
							</div>
						</div>
					</div>

					<div class="field">
						<label class="label">Number of Delegates Awarded</label>
						<div class="field-body">
							<div class="field">
								<div class="control">
									<input
										class="input"
										type="text"
										placeholder="Precinct Delegates"
										name="numDelegates"
									>
								</div>
							</div>
						</div>
					</div>
				</div>

				<c:forEach
					var="i"
					begin="1"
					end="${numCandidates}"
				>
					<div class="box">
						<label class="label">Candidate <c:out value="${i }" /></label>
						<div class="field is-horizontal">
							<div class="field-body">
								<div class="field">
									<p class="control is-expanded">
										<input
											class="input"
											type="text"
											placeholder="Name"
											name="candidate_<c:out value="${i }"/>"
										>
									</p>
								</div>
								<div class="field">
									<p class="control">
										<input
											class="input"
											type="text"
											name="votes_<c:out value="${i }"/>"
											placeholder="Votes"
										>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<input
					type="hidden"
					name=count
					value=${numCandidates }
				/>
				<button
					class="button"
					type="submit"
				>Submit</button>
			</form>
		</section>
	</div>
</body>
</html>