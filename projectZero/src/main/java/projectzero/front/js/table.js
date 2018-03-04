$('#refreshBtn').click(refresh);

// todo use header to send your accessToken
function refresh() {
    $.ajax({
        method: "GET",
        url: "/getAll?key=" + key
    })
        .done(function (data) {
            var orders = JSON.parse(data);
            var tbody = $('#ordersTableBody');
            tbody.innerHTML = null;
            addToTable(tbody, orders);
        });
}

/**
 * @param tbody - table body
 * @param orders - arr of orders
 */
 // todo use jquery
function addToTable(tbody, orders) {
    orders.forEach(function (value) {
       var tr = document.createElement('tr');

       var title = document.createElement('td');
       var status = document.createElement('td');
       var price = document.createElement('td');
       var created = document.createElement('td');
       var finished = document.createElement('td');

       title.innerHTML = value.title;
       status.innerHTML = value.status;
       price.innerHTML = value.price;
       created.innerHTML = value.openedTime;
       finished.innerHTML = value.closedTime ? value.closedTime : "-";

       tr.appendChild(title);
       tr.appendChild(status);
       tr.appendChild(price);
       tr.appendChild(created);
       tr.appendChild(finished);

       tbody.append(tr);
    });
}