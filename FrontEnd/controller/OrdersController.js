let baseUrl = 'http://localhost:8080/pos/';

getAllOrders();

function getAllOrders() {
    $("#tblOrders").empty();

    $.ajax({
        url: baseUrl + 'orders',
        dataType: 'json',
        method: 'GET',

        success: function (response) {
            console.log(response)
            let orders = response.data;
            console.log(orders[0].orderDetails)

            for (let i in orders) {
                let order = orders[i];
                let orderId = order.oid;
                let date = order.date;
                let customerId = order.cusID;

                let details;
                for(let x in order.orderDetails){
                    details += order.orderDetails[x];
                }
                let itemsIDs = details;
                let discount = order.discount;
                let total = order.total;

                let row = `<tr>
                <td>${orderId}</td>
                <td>${date}</td>
                <td>${customerId}</td>
                <td>${itemsIDs}</td>
                <td>${discount}</td>
                <td>${total}</td>
                </tr>`;

                $("#tblOrders").append(row);
            }
        },
        error: function (error) {
            alert('Error loading !');
        }
    });
}

// search orders
$("#btnSearch").click(function () {
    let isFound = false;
    var searchText = $("#searchText").val().trim().toLowerCase();
    if (searchText !== "") {
        $("#tblOrders tr").hide();
        $("#tblOrders tr").each(function () {
            var orderId = $(this).find("td:eq(0)").text().trim().toLowerCase();
            if (orderId === searchText) {
                $(this).show();
                isFound = true;
            }
        });
    }

    if (!isFound) {
        alert("Not found! check ID again");
        $("#tblOrders tr").show();
        $("#searchText").val("");
    }
});