var a = document.getElementById("agricultureAccordian");
a.addEventListener("mouseover", function(){ openAccordian(document.getElementById("a")); });
a.addEventListener("mouseout", function(){ closeAccordian(document.getElementById("a")); });
var m = document.getElementById("miningAccordian");
m.addEventListener("mouseover", function(){ openAccordian(document.getElementById("m")); });
m.addEventListener("mouseout", function(){ closeAccordian(document.getElementById("m")); });
var s = document.getElementById("syntheticsAccordian");
s.addEventListener("mouseover", function(){ openAccordian(document.getElementById("s")); });
s.addEventListener("mouseout", function(){ closeAccordian(document.getElementById("s")); });

var currentlyOpened = null;

function openAccordian(x)
{
	if (currentlyOpened != x)
	{
		if (currentlyOpened != null)
		{
			currentlyOpened.className = currentlyOpened.className.replace(" w3-show", "");
		}
		x.className += " w3-show";
		currentlyOpened = x;
	}
}

function closeAccordian(x)
{
	currentlyOpened.className = currentlyOpened.className.replace(" w3-show", "");
	currentlyOpened = null;
}

function switchSubroundPanel()
{
	document.getElementById("subroundPanel1").className = document.getElementById("subroundPanel1").className.replace("w3-show", "w3-hide");
	document.getElementById("subroundPanel2").className = document.getElementById("subroundPanel2").className.replace("w3-hide", "w3-show");
}

function updateFocusRangeValues(value, subround)
{
	if (subround == "s")
	{
		document.getElementById("sellFocusRangeValue").textContent = value;
		totalFocus = Number(document.getElementById("sellFocusRangeValue").textContent) + Number(document.getElementById("actFocusRangeValue").textContent) + Number(document.getElementById("buyFocusRangeValue").textContent);
		if (totalFocus > 10)
		{
			overusedFocus = totalFocus - 10;
			for (var i = 0; i < overusedFocus; i++)
			{
				if ((i % 2 == 0) && (document.getElementById("actFocus").value > 0))
				{
					document.getElementById("actFocusRangeValue").textContent = Number(document.getElementById("actFocusRangeValue").textContent) - 1;
					document.getElementById("actFocus").value = Number(document.getElementById("actFocusRangeValue").textContent);
				}
				else
				{
					if (document.getElementById("buyFocus").value > 0)
					{
						document.getElementById("buyFocusRangeValue").textContent = Number(document.getElementById("buyFocusRangeValue").textContent) - 1;
						document.getElementById("buyFocus").value = Number(document.getElementById("buyFocusRangeValue").textContent);
					}
					else
					{
						document.getElementById("actFocusRangeValue").textContent = Number(document.getElementById("actFocusRangeValue").textContent) - 1;
						document.getElementById("actFocus").value = Number(document.getElementById("actFocusRangeValue").textContent);
					}
				}
			}
		}
	}
	else if (subround == "a")
	{
		document.getElementById("actFocusRangeValue").textContent = value;
		totalFocus = Number(document.getElementById("sellFocusRangeValue").textContent) + Number(document.getElementById("actFocusRangeValue").textContent) + Number(document.getElementById("buyFocusRangeValue").textContent);
		if (totalFocus > 10)
		{
			overusedFocus = totalFocus - 10;
			for (var i = 0; i < overusedFocus; i++)
			{
				if ((i % 2 == 0) && (document.getElementById("sellFocus").value > 0))
				{
					document.getElementById("sellFocusRangeValue").textContent = Number(document.getElementById("sellFocusRangeValue").textContent) - 1;
					document.getElementById("sellFocus").value = Number(document.getElementById("sellFocusRangeValue").textContent);
				}
				else
				{
					if (document.getElementById("buyFocus").value > 0)
					{
						document.getElementById("buyFocusRangeValue").textContent = Number(document.getElementById("buyFocusRangeValue").textContent) - 1;
						document.getElementById("buyFocus").value = Number(document.getElementById("buyFocusRangeValue").textContent);
					}
					else
					{
						document.getElementById("sellFocusRangeValue").textContent = Number(document.getElementById("sellFocusRangeValue").textContent) - 1;
						document.getElementById("sellFocus").value = Number(document.getElementById("sellFocusRangeValue").textContent);
					}
				}
			}
		}
	}
	else if (subround == "b")
	{
		document.getElementById("buyFocusRangeValue").textContent = value;
		totalFocus = Number(document.getElementById("sellFocusRangeValue").textContent) + Number(document.getElementById("actFocusRangeValue").textContent) + Number(document.getElementById("buyFocusRangeValue").textContent);
		if (totalFocus > 10)
		{
			overusedFocus = totalFocus - 10;
			for (var i = 0; i < overusedFocus; i++)
			{
				if ((i % 2 == 0) && (document.getElementById("actFocus").value > 0))
				{
					document.getElementById("actFocusRangeValue").textContent = Number(document.getElementById("actFocusRangeValue").textContent) - 1;
					document.getElementById("actFocus").value = Number(document.getElementById("actFocusRangeValue").textContent);
				}
				else
				{
					if (document.getElementById("sellFocus").value > 0)
					{
						document.getElementById("sellFocusRangeValue").textContent = Number(document.getElementById("sellFocusRangeValue").textContent) - 1;
						document.getElementById("sellFocus").value = Number(document.getElementById("sellFocusRangeValue").textContent);
					}
					else
					{
						document.getElementById("actFocusRangeValue").textContent = Number(document.getElementById("actFocusRangeValue").textContent) - 1;
						document.getElementById("actFocus").value = Number(document.getElementById("actFocusRangeValue").textContent);
					}
				}
			}
		}
	}
}



// function updateGlobalExchange(industry, value)
// {
// 	if (industry == "agriculture")
// 	{
// 		document.getElementById("globalExchangeAgricultureValue").textContent = Number(document.getElementById("globalExchangeAgricultureValue").textContent) + value;
// 		document.getElementById("globalExchangeAgricultureProgress").style.width = (document.getElementById("globalExchangeAgricultureValue").textContent * 2) + "%";
// 	}
// 	else if (industry == "mining")
// 	{
// 		document.getElementById("globalExchangeMiningValue").textContent = Number(document.getElementById("globalExchangeMiningValue").textContent) + value;
// 		document.getElementById("globalExchangeMiningProgress").style.width = (document.getElementById("globalExchangeMiningValue").textContent * 2) + "%";
// 	}
// 	else if (industry == "synthetics")
// 	{
// 		document.getElementById("globalExchangeSyntheticsValue").textContent = Number(document.getElementById("globalExchangeSyntheticsValue").textContent) + value;
// 		document.getElementById("globalExchangeSyntheticsProgress").style.width = (document.getElementById("globalExchangeSyntheticsValue").textContent * 2) + "%";
// 	}
// }

// function updatePlayerCurrency(value)
// {
// 	document.getElementById("playerCurrency").textContent = Number(document.getElementById("playerCurrency").textContent) + value;
// }

// function interactWithGlobalExchange(action, industry, amount, price)
// {
// 	amount = Number(amount);
// 	price = Number(price);
// 	if (action == "buy")
// 	{
// 		updatePlayerCurrency(-1 * amount * price);
// 		updateGlobalExchange(industry, (-1 * amount));
// 	}
// 	else if (action == "sell")
// 	{
// 		updatePlayerCurrency(amount * price);
// 		updateGlobalExchange(industry, amount);
// 	}
// }