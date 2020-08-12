function exportExcel(title, data, filename, sheetname) {
	var workbook = new kendo.ooxml.Workbook({
		  sheets: [
	           {
		      // Column settings (width)
		      columns: [
		        { autoWidth: true },
		        { autoWidth: true }
		      ],
		      // Title of the sheet
		      title: sheetname,
		      // Rows of the sheet
		      rows: [
					// Content
		      ]
		    }
		  ]
		});
	
	var rows = workbook.options.sheets[0].rows;
	
	// Title
	var cellContent = [];
	$.each( title, function( index, value ){
		var item = { value: value };
		cellContent.push(item);
	});
	var cellTitle = {
			cells: cellContent
	};
	rows.push(cellTitle);
	
	// Row content
	$.each( data, function( index, value){
		rows.push(value);
	});
	
	kendo.saveAs({
	    dataURI: workbook.toDataURL(),
	    fileName: filename + ".xlsx"
	});
}

// Edit by hoangvukmt
// Bo sung kha nang next den ban ghi tiep theo khi dang xem chi tiet tren grid
function nextRowBase(grid, message) {
	if (grid.select() == null || grid.select().length == 0) {
		toastr.warning(message.recordRequired);
		return;
	}
	var dataRows = grid.items();
    var rowIndex = dataRows.index(grid.select());
    var nextIndex = rowIndex + 1;
    if (nextIndex >= dataRows.length) {
    	toastr.warning(message.positionLast);
    	return;
    }
    
    var curentRow = grid.select().closest("tr");
    var nextRow = curentRow.next();
    if (nextRow.attr("class").indexOf("k-detail-row") >= 0){
    	nextRow = nextRow.next();
    }
    
    if ($(curentRow).find(".k-hierarchy-cell > a").attr("class").indexOf("k-minus") >= 0){
    	$(curentRow).find(".k-hierarchy-cell > a").click();
    	$(nextRow).find(".k-hierarchy-cell > a").click();
    }
//    grid.clearSelection();
    grid.select(nextRow);
}

//Edit by hoangvukmt
//Bo sung kha nang prev den ban ghi phia tren khi dang xem chi tiet tren grid
function previousRowBase(grid, message) {
	if (grid.select() == null || grid.select().length == 0) {
		toastr.warning(message.recordRequired);
		return;
	}
	var dataRows = grid.items();
    var rowIndex = dataRows.index(grid.select());
    var preIndex = rowIndex - 1;
    if (preIndex < 0) {
    	toastr.warning(message.positionFirst);
    	return;
    }
    
    var curentRow = grid.select().closest("tr");
    var prevRow = curentRow.prev();
    if (prevRow.attr("class").indexOf("k-detail-row") >= 0){
    	prevRow = prevRow.prev();
    }
    
    if ($(curentRow).find(".k-hierarchy-cell > a").attr("class").indexOf("k-minus") >= 0){
    	$(curentRow).find(".k-hierarchy-cell > a").click();
    	$(prevRow).find(".k-hierarchy-cell > a").click();
    }
//    grid.clearSelection();
    grid.select(prevRow);
}

function multiDeleteBase(grid, serviceInstance, toastr, message) {
	var deferred = $.Deferred();
	
	var selectedRow = [];
	
	grid.table.find("tr").each(function(idx, item) {
		var row = $(item);
		var checkbox = $('[name="gridcheckbox"]', row);
		
		if(checkbox.is(':checked')) {
			// Push id into selectedRow
//			var tr = grid.select().closest("tr");
        	var dataItem = grid.dataItem(item);
        	console.log('dataItem ----');
        	console.log(dataItem.cstatementId);
        	selectedRow.push(dataItem.cstatementId);
		}
    });
	
	if (selectedRow.length == 0) {
		toastr.warning(message.recordRequired);
		return;
	}
	
	console.log(selectedRow);
	if (confirm('Xác nhận xóa')) {
		for(var i = 0; i < selectedRow.length; i++) {
			serviceInstance.deleteItem(selectedRow[i]).then(function(){
					// 
	            }, function(errResponse){
	            	toastr.error(message.deleteError);
	            }
			);
		}
		
		// Info
		toastr.success(message.deleteSuccess);
	}
	
	return deferred.promise();
}


function chkSelectAllBase(flag, grid) {
	var lockedItem = $("#" + grid._cellId.substring(0, grid._cellId.length - 12) + " > .k-grid-content-locked").find("tr");
	if (lockedItem.length === 0) {
		var rowList = grid.lockedTable == undefined ? grid.table.find("tr") : grid.lockedTable.find("tr");
		rowList.each(function(idx, item) {
			var row = $(item);
			var checkbox = $('[name="gridcheckbox"]', row);
			if(flag) {
				checkbox.prop('checked', true);
			} else {
				checkbox.prop('checked', false);
			}
			
	    });
	} else {
		lockedItem.each(function(idx, item) {
			var row = $(item);
			var checkbox = $('[name="gridcheckbox"]', row);
			if(flag) {
				checkbox.prop('checked', true);
			} else {
				checkbox.prop('checked', false);
			}
			
	    });
	}
}

function stringToDate(_date,_format,_delimiter) {
    var formatLowerCase=_format.toLowerCase();
    var formatItems=formatLowerCase.split(_delimiter);
    var dateItems=_date.split(_delimiter);
    var monthIndex=formatItems.indexOf("mm");
    var dayIndex=formatItems.indexOf("dd");
    var yearIndex=formatItems.indexOf("yyyy");
    var month=parseInt(dateItems[monthIndex]);
    month-=1;
    var formatedDate = new Date(dateItems[yearIndex],month,dateItems[dayIndex]);
    return formatedDate;
}

function stringToDate2(_date,_format,_delimiter) {
	var formatLowerCase=_format.toLowerCase();
	var formatItems=formatLowerCase.split(_delimiter);
	var dateItems=_date.split(_delimiter);
	var monthIndex=formatItems.indexOf("mm");
	var dayIndex=formatItems.indexOf("dd");
	var yearIndex=formatItems.indexOf("yyyy");
	var month=parseInt(dateItems[monthIndex]);
	month-=1;
	var day=parseInt(dateItems[dayIndex]);
	day -=1;


	var formatedDate = new Date(dateItems[yearIndex],month,day);
	return formatedDate;
}
function stringToDateKendo(_date){
	return stringToDate(_date,"dd/mm/yyyy","/");
}
function contains(list, obj) {
    var i = list.length;
    while (i--) {
       if (list[i] === obj) {
           return true;
       }
    }
    return false;
}
function removeItem(e,caller,action) {
            var grid = $(e.target).closest("div.k-grid").data('kendoGrid')
            var row = $(e.target).closest("tr");
            var dataItem = grid.dataItem(row);
           
           confirm('Bạn có muốn loại bỏ bản ghi không?',function() {		   
            grid.dataSource.remove(dataItem); //removes it actually from the grid
            grid.refresh();
		   });
        };
function startLoading(){
	var maxZ = Math.max.apply(null, 
		    $.map($('body *'), function(e,n) {
		      if ($(e).css('position') != 'static')
		        return parseInt($(e).css('z-index')) || 1;
		  }));
	$("#loading").css('z-index', maxZ);
	$("#loading").show();
}
function stopLoading(){
	$("#loading").hide();
}

function validateIpRegex(ipRegex) {
        if ((ipRegex == null) || (ipRegex.length < 1))
            return 3;
        var iResult = validateCharacters(ipRegex);
        if (iResult != 0) {
            return iResult;
        }

        if ((ipRegex.charAt(0) == '|') || (ipRegex.charAt(ipRegex.length - 1) == '|'))
            return 3;
        var regexes = ipRegex.split("|");
        for(var i=0;i<regexes.length;i++) {
                var regex = regexes[i];
                if (regex == null || regex.length < 1) {
                    return 3;
                }
                if (regex.charAt(0) == '.' || regex.charAt(regex.length - 1) == '.') {
                    return 3;
                }
                var octets = regex.split(".");
                if (octets.length != 4) {
                    return 3;
                }
                if (validateOctet(octets[0]) != 0 || validateOctet(octets[1]) != 0 || validateOctet(octets[2]) != 0) {
                    return 3;
                }
                if (validateOctetRegex(octets[3]) != 0) {
                    return 3;
                }
             }
        return 0;
    }
    function validateOctet(octet){
        if(octet==null||octet.length==0)
            return 3;
        if(octet.length>1 && octet.charAt(0)=='0')
            return 3;
        var value =-1;
        try{
            value=kendo.parseInt(octet);
        }catch (err){
            return 3;
        }
        if(value<0||value>255)
            return 1;
        return 0;
    }
    
    function validateCharacters(ipRegex){
        return  /[a-zA-Z!@#$%^&()+\={};':"\\<>\/?]/.test(ipRegex) ? 2:0;
		
    }

    function validateOctetRegex(octetRegex){
        if(octetRegex==null || octetRegex.length<1)
            return 3;
        if(octetRegex!="*"){
            if((octetRegex.charAt(0)=='[')&&(octetRegex.charAt(octetRegex.length-1)==']')){
                octetRegex=octetRegex.substring(1,octetRegex.length-1);
                if(octetRegex.length<1)
                    return 3;
                var pos = octetRegex.indexOf('-');
                if(pos>=0){
                    if((octetRegex.charAt(0)=='-')||octetRegex.charAt(octetRegex.length-1)=='-'){
                        return 3;
                    }
                    var nums=octetRegex.split("-");
                    if(nums.length!=2)
                        return 3;
                    if(validateOctet(nums[0])!=0||validateOctet(nums[1])!=0){
                        return 3;
                    }
                    try{
                        var begin =kendo.parseInt(nums[0]);
                        var end =kendo.parseInt(nums[1]);
                        if(begin>=end)
                            return 3;
                    }catch (err){
                        return 3;
                    }
                }
                else{
                    if(octetRegex.charAt(0)==','||octetRegex.charAt(octetRegex.length-1)==','){
                        return 3;
                    }
                    var numss=octetRegex.split(",");
                    if(numss.length!=2)
                        return 3;
                    for(var j =0;j<numss.length;j++){
                        var num = numss[j];
                        if(validateOctet(num)!=0)
                            return 3;
                    }
                }

            }
            else if(validateOctet(octetRegex)!=0)
                return 3;
        }
        return 0;
    }

//function downloadFileWithUrl(url){
//    var elem = document.createElement('a');
//    elem.href = url;
//    elem.target = 'hiddenIframe';
//    document.body.appendChild(elem);
//	elem.click();
//}