
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Badminton </title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Badmintion</a>
			
		</div>
	</div>
	
	
	
		<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Badmintion Club</h1>
					
				</div>
		</div>	
	
		
			
			
			<div class="container text-center">
				<h3>New Player</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="print/player">
					
					<div class="form-group">
						<label class="control-label col-md-3">PhoneNumber</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="phonenumber"
								value="${user.phonenumber }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${user.name }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Amount Balance </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="account_balance"
								value="${user.account_balance}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
			
			<div class="container text-center">
				
				<hr>
				<form class="form-horizontal" method="GET" action="print/player">
						<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Print all Players" />
					</div>
				</form>
				<hr>
			</div>
			
			<div class="container text-center">
				<h3>Print Player details</h3>
				<hr>
				<form class="form-horizontal" method="GET" action="print/player/phonenumber">
					<div class="form-group">
						<label class="control-label col-md-3">PhoneNumber</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="phonenumber"
								value="${user.phonenumber }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
				</form>
			</div>
		
			
			
			<div class="container text-center">
				<h3>Match Players</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="print/match">
					
					<div class="form-group">
						<label class="control-label col-md-3">Court Number</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="courtNo"
								value="${user.courtNo }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Start Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="start_date_time"
								value="${user.start_date_time }" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-md-3">Player 1 phone Number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="player_1_phone_no"
								value="${user.player_1_phone_no}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Player 2 phone Number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="player_2_phone_no"
								value="${user.player_2_phone_no}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
				</form>
			</div>
			
		
		<div class="container text-center">
				<h3>Update Match Players</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="print/match1">
					<div class="form-group">
						<label class="control-label col-md-3">Id</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="id"
								value="${user.id }" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-md-3">End Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="end_date_time"
								value="${user.end_date_time }" />
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label class="control-label col-md-3">Loser phone Number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="loser_phone_no"
								value="${user.loser_phone_no}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
				</form>
			</div>
			
			<div class="container text-center">
				
				<hr>
				<form class="form-horizontal" method="GET" action="print/match">
						<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Print all Match" />
					</div>
				</form>
				<hr>
			</div>
		
		
		<div class="container text-center">
				<h3>Date Range</h3>
				<hr>
				<form class="form-horizontal" method="GET" action="print/range">
					<div class="form-group">
						<label class="control-label col-md-3">start Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="start_date_time"
								value="${user.start_date_time }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">End Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="end_date_time"
								value="${user.end_date_time }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
				</form>
			</div>
		<div class="container text-center">
				<h3>Date Range And Number</h3>
				<hr>
				<form class="form-horizontal" method="GET" action="print/range/phonenumber">
					<div class="form-group">
						<label class="control-label col-md-3">start Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="start_date_time"
								value="${user.start_date_time }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">End Date Time (ex.2023-03-06T10:35:47) </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="end_date_time"
								value="${user.end_date_time }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Player 1 phone Number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="player_1_phone_no"
								value="${user.player_1_phone_no}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Player 2 phone Number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="player_2_phone_no"
								value="${user.player_2_phone_no}" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="submit" />
					</div>
				</form>
			</div>
		
		
		<div class="container text-center">
				<h3>Payment Player</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="print/payment">
					
					<div class="form-group">
						<label class="control-label col-md-3">PhoneNumber</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="player_phone_number"
								value="${user.player_phone_number }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Amount</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="amount_paid"
								value="${user.amount_paid }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Date Of Payment (Ex 2023-03-03)</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="date_of_payment"
								value="${user.date_of_payment}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Submit" />
					</div>
				</form>
			</div>
			
			<div class="container text-center">
				
				<hr>
				<form class="form-horizontal" method="GET" action="print/payment">
						<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Print all Payment" />
					</div>
				</form>
				<hr>
			</div>
			
					
	
			
			
			
</body>
</html>