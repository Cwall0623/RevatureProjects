function getAllReimbursements(){
    let xhr = new XMLHttpRequest();
    let url = 'http://localhost:7000/getAll'
    

    xhr.onreadystatechange = function(){
         if(xhr.readyState === 4 && xhr.status === 200) {
          let reimbursements= JSON.parse (xhr.response);    
          console.log(reimbursements);
        
          for(let reimbursement of reimbursements){

            let new_tr = document.createElement('TR');
            new_tr.className = "table_row";
            let x = document.getElementById("Straw hat Reimbursement")
            x.appendChild(new_tr);

            let new_caseNumber = document.createElement('td');
            new_caseNumber.innerText =reimbursement.caseNumber;

            let new_description = document.createElement('td');
            new_description.innerText = reimbursement.description;

            let new_amount = document.createElement('td');
            new_amount.innerText = reimbursement.amount;

            let new_status = document.createElement('td');
            new_status.innerText = reimbursement.status;

            new_tr.appendChild(new_caseNumber);
            new_tr.appendChild(new_description);
            new_tr.appendChild(new_amount);
            new_tr.appendChild(new_status);

            x.appendChild(new_tr)
          }
        
        
        
        
        
        }
    
      
}
       
   
    xhr.open('GET',url);

    xhr.send();
}

window.onload = function(){
    this.getAllReimbursements();
}