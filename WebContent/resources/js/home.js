function configureDropDownLists(hr,ddl2) {
	var d = new Date();
	var hour = d.getHours();
	var minute = d.getMinutes();
	var number = hr.value;
	//Delivery ends at 14:30
	var pad = "";
	if (number == 14) {
		$("#ddl2").css("display", "inline");
		$("#colon").css("display", "inline");
		if (number == hour) {
			var min = minute;
		}
		else {
			var min = 0;
		}
		ddl2.options.length = 0;
		for (i = min; i <= 30; i+=5) {
			createOption(ddl2, i, i);
		}
	}
	else if (number == hour) {
		$("#ddl2").css("display", "inline");
		$("#colon").css("display", "inline");
		ddl2.options.length = 0;
		for (i = minute; i <= 55; i+=5) {
			createOption(ddl2, i, i);
		}
	}
	else if (number < 14 || number > 14) {
		$("#ddl2").css("display", "inline");
		$("#colon").css("display", "inline");
		ddl2.options.length = 0;
		for (i = 0; i <= 55; i+=5) {
			createOption(ddl2, i, i);
		}
	}
	else if (number == "ASAP") {
		ddl2.options.length = 0;
		$('#ddl2').fadeOut();
		$('#colon').fadeOut();
	}
	else {
		ddl2.options.length = 0;
		$('#ddl2').fadeOut();
		$('#colon').fadeOut();
	}
}

function createOption(ddl, text, value) {
	var opt = document.createElement('option');
	opt.value = value;
	opt.text = text;
	ddl.options.add(opt);
}
var i = 1;
function addItem () {
	if (i <= 10) {
		i++;
		var div = document.createElement('div');
		div.innerHTML = '<input type="text" name="order" placeholder="Item">' + 
		'<input type="text" name="quantity" placeholder="Qty">' + 
		'<input type="text" name="addinfo" placeholder="Additional Information">' +
		'<input type ="button" id="remove_item" onClick="removeItem(this)" value="-" /> '
		document.getElementById('list_item').appendChild(div);
	}
}

function removeItem(div) {
	document.getElementById('list_item').removeChild(div.parentNode);
	i--;
}