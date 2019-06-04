$(document).ready(function () {

    function errorCallback(request, status, error) {
        console.log(request, status, error);
    }

    $(document).ready(function (){
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





})