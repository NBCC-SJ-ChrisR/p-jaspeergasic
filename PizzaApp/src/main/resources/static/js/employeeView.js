window.onload = async function () {
    await buildOrders();
    document.querySelector("#pendDiv table").addEventListener("click", handleRowClick);
    document.querySelector("#readyBtn").addEventListener("click", changeStatus);
};

async function changeStatus() {
    let ids = document.querySelector(".table-active").querySelectorAll("td");
    let id = ids[1].innerHTML;

    let obj = {
        id:id,
        orderStatus: "READY",
        deliveryDate: new Date()
    };

    try {
        let res = await fetch("/order/" + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        });

        if (!res.ok) {
            //alert(res.status + "\n" + error);
        }

        document.querySelector("#readyBtn").setAttribute("disabled", "");
        await buildOrders();
    } catch (err) {
         alert(res.status + "\n" + err);
    }
}

function clearSelections() {
    let trs = document.querySelectorAll("tr");
    for (let i = 0; i < trs.length; i++) {
        trs[i].classList.remove("table-active");
    }
}

function handleRowClick(e) {
    //add style to parent of clicked cell
    clearSelections();
    e.target.parentElement.classList.add("table-active");
    console.log(e.target);

    // enable Delete and Update buttons
    document.querySelector("#readyBtn").removeAttribute("disabled");
}

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
        alert(err);
    }

}

async function buildOrders() {
    let pending = "";
    let ready = "";
    let data = await getOrders();

    let html = "<table class='table table-bordered table-sm w-auto table-hover'><thead><th>Status</th><th>Order ID</th><th>Customer</th>"
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
