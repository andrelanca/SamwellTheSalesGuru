$(document).ready(function () {


    //bookTitle, bookQuantity, bookPrice, clientName, clientPhoneNum, clientAddress
    

    function errorCallback(request, status, error) {
        console.log(request, status, error);
    }

    function successCallback(response){        
        window.location.replace("./users.html");
    }


    $("#submit-order").click(function(){
        var bookTitle = $("#bookTitle").val();
        var bookQuantity = $("#bookQuantity").val();
        var bookPrice = $("#bookPrice").val();
        var clientName = $("#clientName").val();
        var clientPhoneNum = $("#clientPhoneNum").val();
        var clientAddress = $("#clientAddress").val();

        $.ajax({
            url:"http://localhost:8080/addClient?bookTitle=" +
            bookTitle + "&bookQuantity=" +
            bookQuantity + "&bookPrice=" + 
            bookPrice + "&clientName=" +
            clientName + "&clientPhoneNum=" +
            clientPhoneNum + "&clientAddress=" + 
            clientAddress + '"',
  
            type: "POST",
            async: true,
            success: successCallback,
            error: errorCallback
        })
        console.log(bookTitle, bookQuantity, bookPrice, clientName, clientPhoneNum, clientAddress);
        
    })

    $("#showTable").click(function showList(){
        $.ajax({
            url: 'http://localhost:8080/clients',
            type: "GET",
            async: true,
            dataType: 'json',
            success: successTableCallback,
            error: errorCallback
        })
    })

    function successTableCallback(response){
        
        var table = $("#usersList");
        //This line is used when the user click on "Show table", to refresh the users instead of duplicate them.
        $(".customer-rows").remove();

        $.each(response, customer => {
                table.append("<tr class='customer-rows'><td>" + "<td>" + response[customer].orderID + "</td>" + response[customer].firstName +
                "</td><td>" + response[customer].bookTitle + "</td><td>" +
                response[customer].bookQuantity + "</td><td>" + response[customer].bookPrice + "</td>" +
                "<td>" + response[customer].clientName + "</td>" +
                "<td>"+ response[customer].clientPhoneNum + "</td>" + 
                "<td>" + response[customer].clientAddress + "</tr>")

        });

    }



});