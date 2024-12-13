window.onload = async function () {
    await buildOrders();
};

async function getOrders() {

    try {
        let res = await fetch("/order");
        
        if (!res.ok) {
            alert(res.status + "\n" + res.error);
            return;
        }

        let data = res.json();
        return data;

    } catch (err) {
        alert(err.error);
    }

}

//async function getCustomer(){
//    
//}

async function buildOrders() {
    let id = 1
    let pending = "";
    let ready = "";
    let data = await getOrders();
    
    data.filter((data)=> data.customer.id === id);


    let html = "<table class='table table-bordered table-sm w-auto'><thead><th>Status</th><th>Order ID</th><th>Customer</th>"
            + "<th>SubTotal</th><th>Hst</th><th>Order Total</th><th>Delivery</th><th>Order Placed</th><th>Delivery Date</th></thead><tbody>";

    for (i = 0; i < data.length; i++) {
        if (data[i].orderStatus === "PENDING") {
            pending += `<tr><td>${data[i].orderStatus}</td><td>${data[i].id}</td><td>${data[i].customer.lastName}, ${data[i].customer.firstName}</td><td>${data[i].subTotal}</td>`
                    + `<td>${data[i].hst}</td><td>${data[i].orderTotal}</td><td>${data[i].delivery}</td><td>${data[i].orderPlacedDate}</td><td>${data[i].deliveryDate}</td></tr>`;
        } else if (data[i].orderStatus === "READY") {
            ready += `<tr><td>${data[i].orderStatus}</td><td>${data[i].id}</td><td>${data[i].customer.lastName}, ${data[i].customer.firstName}</td><td>${data[i].subTotal}</td>`
                    + `<td>${data[i].hst}</td><td>${data[i].orderTotal}</td><td>${data[i].delivery}</td><td>${data[i].orderPlacedDate}</td><td>${data[i].deliveryDate}</td></tr>`;
        }
    }
    let endHtml = `</tbody></table>`;
    if (pending !== "") {
        let pendDiv = document.querySelector("#pendDiv");
        pendDiv.innerHTML = html + pending + endHtml;
    }
    if (ready !== "") {
        let readyDiv = document.querySelector("#readyDiv");
        readyDiv.innerHTML = html + ready + endHtml;
    }


}


