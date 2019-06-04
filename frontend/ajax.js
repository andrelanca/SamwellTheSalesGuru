$(document).ready(function () {
    

    function errorCallback(request, status, error) {
        console.log(request, status, error);
    }

    function successCallback(response){        
        window.location.replace("./orders.html");
    }

    $("#add-order").click(function(){
        var bookTitle = $("#bookTitle").val();
        var bookQuantity = $("#bookQuantity").val();
        var bookPrice = $("#bookPrice").val();
        var clientName = $("#clientName").val();
        var clientPhoneNum = $("#clientPhoneNum").val();
        var clientAddress = $("#clientAddress").val();

        if(!bookTitle){
            alert("All fields must be filled")
            return;
        }
        if(!clientName){
            alert("All fields must be filled");
            return;
        }
        if(!clientAddress){
            alert("All fields must be filled");
            return;
        }

        $.ajax({
            url:"http://localhost:8080/addClient?bookTitle=" +
            bookTitle + "&bookQuantity=" +
            bookQuantity + "&bookPrice=" + 
            bookPrice + "&clientName=" +
            clientName + "&clientPhoneNum=" +
            clientPhoneNum + "&clientAddress=" + 
            clientAddress,
  
            type: "POST",
            async: true,
            success: successCallback,
            error: errorCallback
        })
        console.log(bookTitle, bookQuantity, bookPrice, clientName, clientPhoneNum, clientAddress);
        
    })



    $("#delete-order").click(function(){
        var orderIdValue = $("#order-id").val();
        var parsed = $.parseJSON(orderIdValue);
        console.log(parsed, orderIdValue);
        
        $.ajax({
            url: 'http://localhost:8080/removeClient/' + parsed,
            type: "DELETE",
            //next task will just happen when this one complete
            async: false, 
            success: window.location.reload(),
            error: errorCallback
        })

        
    })

    $("#submit-order").click(function(){
        $.ajax({
            url: 'http://localhost:8080/submitOrderList/',
            type: "GET",
            async: true,
            dataType: 'json',
            success: window.location.replace("success.html"),
            error: errorCallback
        })
    })





});