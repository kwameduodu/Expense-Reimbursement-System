function getAllemployee(){
   
   let url ='http://localhost:8000/employee/all';

   
  var xhr = new XMLHttpRequest();
  
xhr.onreadystatechange = function(){

if (xhr.readyState === 4 && xhr.status === 200) {
            var Employees = JSON.parse(this.responseText);
           
            console.log(Employees);
            
           
            for (var employee in Employees) {

                console.log(employee.length);
                let display = document.getElementById('show');
                let newRow = display.insertRow();
                console.log(newRow);
                
                let cell1 = newRow.insertCell(0);
                let cell2 = newRow.insertCell(1);
                let cell3 = newRow.insertCell(2);
              
                cell1.innerHTML = Employees[employee].name;
                cell2.innerHTML =Employees[employee].amount;
                cell3.innerHTML = Employees[employee].reason;
                
        }
    }   
   }
            
xhr.open('GET',url, true);

//send request
xhr.send();

    }
    
  

 function update() {
   
   let url ='http://localhost:8000/approve/all';
   
   var xhr = new XMLHttpRequest();
   
 xhr.onreadystatechange = function(){
 
 if (xhr.readyState === 4 && xhr.status === 200) {
           let Approval = JSON.parse(this.responseText);
              
             console.log(Approval);
             
            
             for (var approve in Approval) {
	
                 console.log(approve.length);
                 var display = document.getElementById('approve');
                  let newRow = display.insertRow();
                console.log(newRow);
                
    
                 var cell4 = newRow.insertCell(0);
                  var cell5 = newRow.insertCell(1);
                  
                  
                
                cell4.innerHTML = Approval[approve].status;
                cell5.innerHTML =Approval[approve].approveBy;  
          }
         }
      }
      xhr.open('GET',url, true);
//send request
xhr.send();
    } 
    
      window.onload = function(){
    this.getAllemployee();
    this.update();
   
}             