	 var timeAry=[10,11,12,13,12,14,15,16,17];
	  var dayAry=[0,1,2,3,4,5];
function include(arr,obj) {
    return (arr.indexOf(obj) != -1);
}
function dayChart(date,stockId,stockname){
	$.ajax({
	    type: 'get',
	    data: $.param({dat:date,stockID:stockId}),
	    dataType:'json',
	    url: 'getDayStockChart.do',    
	    success: function(responseData) {
	 	data= responseData;
		
		drawDayChart(data,stockname,'container3')
	  },
	      error: function(XMLHttpRequest, textStatus, errorThrown) {
	          //TODO  
	      }
	  	
	  });
}
function getChartDetails(stockId,stockname){
var dateAry = [];
var priceAry=[];
var chardata=[];
 var data='[';
	$.ajax({
	    type: 'get',
	    data: $.param({stockID:stockId}),
	    dataType:'json',
	    url: 'getStockChart.do',    
	    success: function(responseData) {
	 	data= responseData;
		drawChart(data,stockname,'container')
	  },
	      error: function(XMLHttpRequest, textStatus, errorThrown) {
	          //TODO  
	      }
	  	
	  });

}


function convertDateToLong(stockEntryDate){
  return new Date(stockEntryDate).getTime();
}

function drawDayChart(json,stockname,container){
  // create the chart
		chart = new Highcharts.StockChart({
			chart : {
				renderTo : container
			},

			title: {
				text: stockname
			},
			
			xAxis: {
				gapGridLineWidth: 0
			},
			
			rangeSelector : {
				buttons : [{
					type : 'hour',
					count : 1,
					text : '1h'
				}, {
					type : 'day',
					count : 1,
					text : '1D'
				}, {
					type : 'all',
					count : 1,
					text : 'All'
				}],
				selected : 1,
				inputEnabled : false
			},
			
			series : [{
				name : stockname,
				type: 'area',
				data : json,
				gapSize: 5,
				tooltip: {
					valueDecimals: 2
				},
				fillColor : {
					linearGradient : {
						x1: 0, 
						y1: 0, 
						x2: 0, 
						y2: 1
					},
					stops : [[0, Highcharts.getOptions().colors[0]], [1, 'rgba(0,0,0,0)']]
				},
				threshold: null
			}]
		});
   
}
function drawChart(json,stockname,container){
   // Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
	
	 // Create the chart
        window.chart = new Highcharts.StockChart({
            chart : {
                renderTo : container
            },

            rangeSelector : {
                selected : 1
            },

            title : {
                text : stockname+' Stock Price'
            },
            
            series : [{
                name : stockname,
                data : json,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
   
}
function changeTheme(color){

var script=document.createElement('script');
script.id="jss";
script.type='text/javascript';
script.src=color;

$("body").append(script);
//$('#jss').removeAttr("src");




getChartDetails(stockId,stockSymbol);
//$('#jss').attr('src',color);

}
function loadLiveChart(stockId,stockname){
	
	var ourTime = new Date().getHours();
	var ourDay =  new Date().getDay();
	
	if(include(dayAry,ourDay)){
		if(include(timeAry,ourTime)){
			
	Highcharts.setOptions({
		global : {
			useUTC : false
		}
	});
	
	// Create the chart
	window.chart = new Highcharts.StockChart({
		chart : {
			renderTo : 'container2',
			events : {
				load : function() {

					// set up the updating of the chart each second /
					var series = this.series[0];
					setInterval(function() {
										 $.ajax({
	    type: 'post',
	    data: $.param({stockID:stockId}),
	    dataType:'json',
	    url: 'getLiveStock.do',    
	    success: function(responseData) {
	 	
			var x = (new Date()).getTime();// current time
						//y = Math.round(Math.random() * 100);
						
						series.addPoint([x, responseData.faceValue], true, true);
	  },
	      error: function(XMLHttpRequest, textStatus, errorThrown) {
	          //TODO  
	      }
	  	
	  });

					
					}, 5000);
				}
			}
		},
		
		rangeSelector: {
			buttons: [{
				count: 1,
				type: 'minute',
				text: '1M'
			}, {
				count: 5,
				type: 'minute',
				text: '5M'
			}, {
				type: 'all',
				text: 'All'
			}],
			inputEnabled: false,
			selected: 0
		},
		
		title : {
			text : stockname + ' Live Data'
		},
		
		exporting: {
			enabled: false
		},
		
		series : [{
			name : stockname,
			data : (function() {
				// generate an array of random data
				var data = [], time = (new Date()).getTime(), i;

				for( i = -999; i <= 0; i++) {
					data.push([
						time + i * 1000,
						Math.round(Math.random() * 100)
					]);
				}
				return data;
			})()
		}]
	});
	    }else{
		
	  $('#container2').html('Live chart available from monday to friday and between 10-5 pm ');
	    $('#container2').css('display','block');
	}
	}


}