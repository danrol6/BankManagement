<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regex Test</title>
</head>
<body>

<!-- 
You can add regex to any input type="text".
Just add the appropriate field: pattern="regexString"
 -->

<form>
	<p>
		<label for="f1">Username<abbr title="This field is mandatory" aria-label="required">*</abbr></label>
		<input type="text" id="f1" name="username" required pattern="^[a-zA-Z]\w{4,19}$">
	</p>
	<p>
		<label for="f2">SSN<abbr title="This field is mandatory" aria-label="required">*</abbr></label>
		<input type="text" id="f2" name="SSN" required pattern="^\d{3}-\d{2}-\d{4}$">
	</p>
	<p>
		<label for="f3">Date<abbr title="This field is mandatory" aria-label="required">*</abbr></label>
		<input type="text" id="f3" name="Date" required pattern="^\d{4}\/\d{2}\/\d{2} \d{2}:\d{2}:\d{2}$">
	</p>
 	<p>
		<input type="submit" name="Submit"/>
	</p>
</form>


<script>

</script>
</body>
</html>