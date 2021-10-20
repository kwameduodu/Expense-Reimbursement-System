function getAllemployee(){


	var row = 1;
	
 var Name = document.getElementById("name").value;
 var Amount = document.getElementById("amount").value;
 var Reason = document.getElementById("reason").value;
  
   var display  = document.getElementById("show");
   
   var newRow = display.insertRow(row);
   
   
   var cell1 = newRow.insertCell(0);
   var cell2 = newRow.insertCell(1);
   var cell3 = newRow.insertCell(2);
   
   cell1.innerHTML = Name;
   cell2.innerHTML = Amount;
   cell3.innerHTML = Reason;      
   row++;        
                    
              
    }