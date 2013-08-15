

function deleteStock(stockId) {
	jConfirm('Are you sure want to delete this stock?', 'Confirmation Dialog',
			function(r) {
				// jAlert('Confirmed: ' + r, 'Confirmation Results');
				if (r) {
					$.ajax({
						type : 'get',
						data : $.param({
							investerStockId : stockId
						}),
						url : 'deleteStock.do',
						success : function(responseData) {
							if (responseData == 'success') {
								// jAlert('Confirmed: ', 'Stock Deleted
								// Successfully');
								//loadStock();
								removeTableRow('r'+stockId);
							}

						},
						cache : false,
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							// TODO
						}

					});
					// jAlert('Confirmed: ' + r, 'Confirmation Results');

				}
			});
	/* */
}
function searchStock() {
	var stockname = $('#addstock').val();
	if (stockname == null || stockname == "") {
		jAlert('Please input stock name ', 'Required');
	} else if (stockname.length < 3) {
		jAlert('Please enter atleast three charactor for search ',
				'Stock Name Error');
	} else {



						
		var stockLst = '';
		var counter = 0;
		$
				.ajax({
					type : 'get',
					data : $.param({
						pattern : $('#addstock').val()
					}),
					dataType : 'json',
					url : 'getStockByStockSymbolOrCompanyname.do',
					success : function(responseData) {
						
						if (responseData.length > 0) {
							$('#tab22').html('');
							stockLst = stockLst
							        + '<table id="thetable2" cellspacing="0"  style="width:100%;" >' 
									+ '<thead class="tablescroll_head">'
									+ '<tr>' 
									+ '<td>Stock Symbol</td>'
									+ '<td>Company name</td>'
									+ '<td>Purchase Price</td>'
									+ '<td>Purchase Date</td>'
									+ '<td>Quantity</td>' +
									// '<td>Varient(%)</td>'+
									'<td>Email Alert</td>' + '<td>Action</td>'
									+ '</tr>' + '</thead>' + '<tbody>';
							for ( var key in responseData) {
								// alert(responseData[key].stockSymbol);
								if (counter == 0) {
									stockLst = stockLst
											+ '<tr class="first" id="r'+responseData[key].stockId+'">'
											+ '<td>'
											+ responseData[key].stockSymbol
											+ '</td>'
											+ '<td>'
											+ responseData[key].companyName
											+ '</td>'
											+ '<td><input type="text" id="pprice'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+ '<td><input type="text" id="pdate'
											+ responseData[key].stockId
											+ '" onClick="datePicker(this.id);" size="10"/></td>'
											+ '<td><input type="text" id="quantity'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+
											// '<td><input type="text"
											// readonly="true"
											// id="varient'+responseData[key].stockId+'"
											// size="10"/></td>'+
											'<td><input type="checkbox" onchange="bindCheck(this.id)" id="email'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+ '<td><input type="image" src="images/1347277752_group_add.png" onClick="addStock('
											+ responseData[key].stockId
											+ ');"/></td>' + '</tr>';
								} else {
									stockLst = stockLst
											+ '<tr id="r'+responseData[key].stockId+'">'
											+ '<td>'
											+ responseData[key].stockSymbol
											+ '</td>'
											+ '<td>'
											+ responseData[key].companyName
											+ '</td>'
											+ '<td><input type="text" id="pprice'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+ '<td><input type="text" id="pdate'
											+ responseData[key].stockId
											+ '" onClick="datePicker(this.id);" size="10"/></td>'
											+ '<td><input type="text" id="quantity'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+
											// '<td><input type="text"
											// readonly="true"
											// id="varient'+responseData[key].stockId+'"
											// size="10"/></td>'+
											'<td><input type="checkbox" onchange="bindCheck(this.id)" id="email'
											+ responseData[key].stockId
											+ '" size="10"/></td>'
											+ '<td><input type="image" src="images/1347277752_group_add.png" onClick="addStock('
											+ responseData[key].stockId
											+ ');"/></td>' + '</tr>';

								}
								counter++;

							}
							stockLst = stockLst + '</tbody></table>';
							$('#tab22').html(stockLst);
														$('#addstock').val('');
						}else{
							jAlert('No stock found in record,Please try again',
				'Stock Name Error');
						}

						$('#thetable2').tableScroll({
							height : 100
						});
					},
					cache : false,
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						// TODO
					}

				});

	}

}
function changeEmailAlert(id, variant, emailval) {
	$.ajax({
		url : 'updateStock.do',
		type : 'post',
		data : $.param({
			varient : variant,
			investerStockId : id,
			emailAlertValue : emailval
		}),
		success : function(data) {
			if (data == 'fail') {

			} else {

				loadStock();

			}

		},
		cache : false
	});
}
function resetAlert(id, variant,emailalert) {
	jConfirm('Are you sure want to reset email alert?',
			'Confirmation Dialog', function(r) {
				// jAlert('Confirmed: ' + r, 'Confirmation Results');
				if (r) {
					if(emailalert==0 && variant >0)
					changeEmailAlert(id, variant, 1);
					else if (emailalert==0 && variant ==0)
					jAlert('Please set varience value to reset email alert!','Alert Error: ');
					else
					changeEmailAlert(id, variant, 0);
				} /*else {
					
				}
*/
			});
}
function resetVarience(id, variant, emailalert){
jConfirm('Your current varience is '+variant+', Do you want  to change variance?',
							'Confirmation Dialog', function(r) {
								// jAlert('Confirmed: ' + r, 'Confirmation
								// Results');
								if (r) {
									jPrompt('Please enter variance', variant,
											'Variance Entry', function(r) {
												if (r) {
													//if(r<=20)
													if(r==0)
													changeEmailAlert(id, r, 0);
													else
													changeEmailAlert(id, r, 1);
													//else
													//jAlert('Please input varience value laess than or equal to 20 ', 'Varience Error');
												}
											});
								} else {

								}

							});
}
function editInesterStock(InvestTerStockId){
	var numeric = /^[0-9 ]/;
	var stockPurchaseDate = $('#epdate' + InvestTerStockId).val();
	var stockPurchasePrice = $('#epprice' + InvestTerStockId).val();
	var quantity = $('#equantity' + InvestTerStockId).val();
	if (stockPurchasePrice == null || stockPurchasePrice == "") {
		jAlert('Please input stock price ', 'Required');
	} else if (stockPurchaseDate == null || stockPurchaseDate == "") {
		jAlert('Please input stock purchase date ', 'Required');
	} else if (quantity == null || quantity == "") {
		jAlert('Please input stock purchase quantity ', 'Required');
	} else if (!numeric.test(quantity)) {
		jAlert('Please input stock purchase quantity numeric', 'Required');
	} else if (!numeric.test(stockPurchasePrice)) {
		jAlert('Please input stock purchase price numeric', 'Required');
	} else{
		 updateInvesterStock(stockPurchaseDate,stockPurchasePrice,quantity,InvestTerStockId);
	}
	
}
function removeTableRow(trId) {
    $(document.getElementById(trId)).remove();
}
function updateInvesterStock(stockPurchaseDate,stockPurchasePrice,quantity,InvestTerStockId){
	//alert(stockPurchaseDate+''+stockPurchasePrice+''+quantity+''+InvestTerStockId);
		$.ajax({
		url : 'updateInesterStock.do',
		type : 'post',
		data : $.param({
			stockPurchaseDate : stockPurchaseDate,
			stockPurchasePrice : stockPurchasePrice,
			quantity : quantity,
			investerStockId : InvestTerStockId
			
		}),
		success : function(data) {
			if (data == 'fail') {
				jAlert('Sorry No Stock Added','Confirmed: ');
			} else {
				jAlert('Stock Updated Successfully','Confirmed: ');
				removeTableRow('r'+InvestTerStockId);
			}

		},
		cache : false
	});

}
function editStock() {
	$('#thetable3').html('');
	var stockLst = '<thead class="tablescroll_head">' + '<tr>'
			+ '<td>Stock Symbol</td>' + '<td>Company Name</td>' + '<td>Purchase Price</td>'
			+ '<td>Purchase Date</td>' + '<td>Quantity</td>'
			+ '<td>Action</td>' + '</tr>' + '</thead>' + '<tbody>';

	var counter = 0;
	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'getInvesterstock.do',
		data : $.param({
			time : new Date().getTime()			
		}),
		success : function(responseData) {

			for ( var key in responseData) {
// alert(responseData[key].stockSymbol);
								if (counter == 0) {
									stockLst = stockLst
											+ '<tr class="first" id="r'+responseData[key].investerStockID+'">'
											+ '<td>'
											+ responseData[key].stockSymbol
											+ '</td>'
											+ '<td>'
											+ responseData[key].companyName
											+ '</td>'
											+ '<td><input type="text" id="epprice'
											+ responseData[key].investerStockID
											+ '" size="10" value="'+ responseData[key].stockPurchasePrice+'"/></td>'
											+ '<td><input type="text" id="epdate'
											+ responseData[key].investerStockID
											+ '" onClick="datePicker(this.id);" size="10" value="'+ responseData[key].stockPurchasedate+'"/></td>'
											+ '<td><input type="text" id="equantity'
											+ responseData[key].investerStockID
											+ '" size="10" value="'+ responseData[key].quantity+'"/></td>'
											+ '<td><input type="image" src="images/1348147470_group_edit.png" title="Update Stock Details" onClick="editInesterStock('+responseData[key].investerStockID+');"/>&nbsp;&nbsp;<input type="image" src="images/undo.png" title="Update Varience Details" onClick="resetVarience('+responseData[key].investerStockID+','+responseData[key].varient+');"/></td>'
											+ '</tr>';
								} else {
									stockLst = stockLst
											+ '<tr  id="r'+responseData[key].investerStockID+'">'
														+ '<td>'
											+ responseData[key].stockSymbol
											+ '</td>'
											+ '<td>'
											+ responseData[key].companyName
											+ '</td>'
											+ '<td><input type="text" id="epprice'
											+ responseData[key].investerStockID
											+ '" size="10" value="'+ responseData[key].stockPurchasePrice+'"/></td>'
											+ '<td><input type="text" id="epdate'
											+ responseData[key].investerStockID
											+ '" onClick="datePicker(this.id);" size="10" value="'+ responseData[key].stockPurchasedate+'"/></td>'
											+ '<td><input type="text" id="equantity'
											+ responseData[key].investerStockID
											+ '" size="10" value="'+ responseData[key].quantity+'"/></td>'
										+ '<td><input type="image" src="images/1348147470_group_edit.png" title="Update Stock Details" onClick="editInesterStock('+responseData[key].investerStockID+');"/>&nbsp;&nbsp;<input type="image" src="images/undo.png" title="Update Varience Details" onClick="resetVarience('+responseData[key].investerStockID+','+responseData[key].varient+');"/></td>'
											+ '</tr>';
								}
								counter++;

			}

			stockLst = stockLst + '</tbody>';
			$('#thetable3').html(stockLst);
		
		},
		cache : false,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			// TODO
		}

	});
}
function loadStock() {

	$('#thetable').html('');
	var stockLst = '<thead class="tablescroll_head">'
			+ '<tr>'
			+ '<td>Stock Symbol</td>'
			+ '<td>Company Name</td>'
			+ '<td>Purchase Price</td>'
			+ '<td>Purchase Date</td>'
			+ '<td>Current Price</td>'
			+ '<td>Quantity</td>'
			+ '<td><label style="color:green">Gain</label>/<label style="color:red">Loss</label></td>'
			+ '<td>Varient(%)</td>' + '<td>Email Alert</td>'
			+ '<td>Action</td>' + '</tr>' + '</thead>' + '<tbody>';

	var counter = 0;
	$
			.ajax({
				type : 'get',
				dataType : 'json',
				url : 'getInvesterstock.do',
		data : $.param({
			time : new Date().getTime()			
		}),
				success : function(responseData) {
                     if(responseData==''){
					    $('#ecsv').hide();
					 }else{
						 $('#ecsv').show();
					 }
					for ( var key in responseData) {
						var emailAlert = '';
						var amountStatuc = responseData[key].investerAmountStatus;
						var statusRow = '';
						if (amountStatuc < 0) {
							statusRow = '<td style="color:red">' + amountStatuc
									+ ' Rs.</td>';
						} else {
							statusRow = '<td style="color:green">'
									+ amountStatuc + ' Rs.</td>';
						}
						if (responseData[key].emailAlert == 1) {
							emailAlert = 'Activated';
						} else {
							emailAlert = 'DeActivated';
						}
						if (counter == 0) {
							stockLst = stockLst
									+ '<tr class="first" id="r'+responseData[key].investerStockID+'">'
									+ '<td>'
									+ responseData[key].stockSymbol
									+ '</td>'
									+ '<td>'
									+ responseData[key].companyName
									+ '</td>'
									+ '<td>'
									+ responseData[key].stockPurchasePrice
									+ '</td>'
									+ '<td>'
									+ responseData[key].stockPurchasedate
									+ '</td>'
									+ '<td>'
									+ responseData[key].currPrice
									+ '</td>'
									+ '<td>'
									+ responseData[key].quantity
									+ '</td>'
									+ statusRow
									+ '<td>'
									+ responseData[key].varient
									+ '</td>'
									+ '<td>'
									+ emailAlert
									+ '</td>'
									+ '<td><a href="getChart.do?stockID='
									+ responseData[key].stockID
									+ '&stockSymbol='
									+ responseData[key].stockSymbol
									+ '"><img src="images/1347277378_Stocks.png" width="24px" title="See chart"	height="24px" style="cursor:pointer" /></a>&nbsp;<a href="javascript:deleteStock('
									+ responseData[key].investerStockID
									+ ');"><img src="images/1347277322_001_05.png" width="24px" title="Delete Stock"	height="24px" style="cursor:pointer" /></a>&nbsp;<a href="javascript:resetAlert('
									+ responseData[key].investerStockID
									+ ','
									+ responseData[key].varient
									+ ','
									+ responseData[key].emailAlert
									+ ');"><img src="images/email-alert-icon.png" width="24px" title="Reset Alert"	height="24px" style="cursor:pointer" /></a></td>'
									+ '</tr>';
						} else {
							stockLst = stockLst
									+ '<tr id="r'+responseData[key].investerStockID+'">'
									+ '<td>'
									+ responseData[key].stockSymbol
									+ '</td>'
									+ '<td>'
									+ responseData[key].companyName
									+ '</td>'
									+ '<td>'
									+ responseData[key].stockPurchasePrice
									+ '</td>'
									+ '<td>'
									+ responseData[key].stockPurchasedate
									+ '</td>'
									+ '<td>'
									+ responseData[key].currPrice
									+ '</td>'
									+ '<td>'
									+ responseData[key].quantity
									+ '</td>'
									+ statusRow
									+ '<td>'
									+ responseData[key].varient
									+ '</td>'
									+ '<td>'
									+ emailAlert
									+ '</td>'
									+ '<td><a href="getChart.do?stockID='
									+ responseData[key].stockID
									+ '&stockSymbol='
									+ responseData[key].stockSymbol
									+ '"><img src="images/1347277378_Stocks.png" width="24px"	height="24px" style="cursor:pointer" /></a>&nbsp;<a href="javascript:deleteStock('
									+ responseData[key].investerStockID
									+ ');"><img src="images/1347277322_001_05.png" width="24px"	height="24px" style="cursor:pointer" /></a>&nbsp;<a href="javascript:resetAlert('
									+ responseData[key].investerStockID
									+ ','
									+ responseData[key].varient
									+ ','
									+ responseData[key].emailAlert
									+ ');"><img src="images/email-alert-icon.png" width="24px" title="Reset Alert"	height="24px" style="cursor:pointer" /></a></td>'
									+ '</tr>';

						}
						counter++;

					}
//             
                 
					stockLst = stockLst + '</tbody>';
					$('#thetable').html(stockLst);

				},
				cache : false,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					// TODO
				}

			});

}

function addStockToPortfolio(stockId, stockPurchaseDate, stockPurchasePrice,
		varient, quantity, emailAlertValue) {
	$.ajax({
		url : 'addStock.do',
		type : 'post',
		data : $.param({
			stockId : stockId,
			stockPurchaseDate : stockPurchaseDate,
			stockPurchasePrice : stockPurchasePrice,
			varient : varient,
			quantity : quantity,
			emailAlertValue : emailAlertValue
		}),
		success : function(data) {
			if (data == 'success') {
				
				jAlert('Stock Added Successfully','Confirmed: ');
			//	$('#thetable2').html("");
				
				removeTableRow('r'+stockId);
			} else {
				
             jAlert(data,'Confirmed: ');
			}

		},
		cache : false
	});

}
function addStock(stockId) {
	//var stockId = $('#'+stockId).val();
	var ck_name = /^[0-9 ]{0,20}$/;
	var numeric = /^[0-9 ]/;
	var varient = 0;
	var emailAlertValue = 0;
	var stockPurchaseDate = $('#pdate' + stockId).val();
	var stockPurchasePrice = $('#pprice' + stockId).val();
	var quantity = $('#quantity' + stockId).val();
	if (stockPurchasePrice == null || stockPurchasePrice == "") {
		jAlert('Please input stock price ', 'Required');
	} else if (stockPurchaseDate == null || stockPurchaseDate == "") {
		jAlert('Please input stock purchase date ', 'Required');
	} else if (quantity == null || quantity == "") {
		jAlert('Please input stock purchase quantity ', 'Required');
	} else if (!numeric.test(quantity)) {
		jAlert('Please input stock purchase quantity numeric', 'Required');
	} else if (!numeric.test(stockPurchasePrice)) {
		jAlert('Please input stock purchase price numeric', 'Required');
	} else {
		if ($('#email' + stockId).is(':checked')) {
			jPrompt('Please enter variance', '0', 'Variance Entry',
					function(r) {
						if (r) {
							if (!ck_name.test(r)) {
								varient = 0;
							} else {
								varient = r;
								emailAlertValue = 1;
							}
							addStockToPortfolio(stockId, stockPurchaseDate,
									stockPurchasePrice, varient, quantity,
									emailAlertValue);
						}
					});

		} else {
			addStockToPortfolio(stockId, stockPurchaseDate, stockPurchasePrice,
					varient, quantity, emailAlertValue);
		}

	}

}