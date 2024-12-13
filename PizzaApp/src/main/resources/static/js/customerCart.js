let items;

window.onload = async function () {
    await getCartItems();
    document.querySelector("#placeBtn").addEventListener("click", completeOrder);
};

async function getCartItems() {
    items = JSON.parse(sessionStorage.getItem("cart"));
    for (i = 0; i < items.length; i++) {
        let topTotal = 0;
        let size = await getSize(items[i].size);
        let crust = await getCrust(items[i].crust);
        let toppings = [];

        for (t = 0; t < items[i].toppings.length; t++) {
            let top = await getTopping(items[i].toppings[t]);
            toppings.push(top);
        }

        items[i].toppings = toppings;
        items[i].size = size;
        items[i].crust = crust;

        items[i].toppings.forEach((t) => topTotal += t.price);

        items[i].priceEach = items[i].size.price + items[i].crust.price + topTotal;
        items[i].totalPrice = items[i].priceEach * items[i].quantity;
    }

//    for (i = 0; i < items.length; i++) {
//        console.log(items[i]);
//    }

    buildOrders(items);

}

function buildOrders(items) {
    let orderDiv = document.querySelector("#orders");
    let html = '';
    let subTotal = 0;
    let total = 0;

    if (items.length === 0) {
        orderDiv.innerHTML = "<p>No orders currently</p>";
        return;
    }

    let num = 1;
    html = "<table class='table table-bordered table-sm w-auto'><thead><th>Pizza #</th><th>Size</th><th>Crust</th><th>Toppings</th><th>Price Each</th><th>Quantity</th><th>Total</th></thead><tbody>";
    items.forEach((i) => {
        let tempt = "";
        i.toppings.forEach((t) => tempt += "[" + t.name + "] ");
        html += `<tr><td>${num}</td><td>${i.size.name}</td><td>${i.crust.name}</td><td>${tempt}</td><td>${i.priceEach}</td><td>${i.quantity}</td><td>${i.totalPrice}</td></tr>`;
        num++;
        subTotal += i.totalPrice;
    });

    let formatter = new Intl.NumberFormat("en-US", {style: 'currency', currency: 'USD' });
    subTotal = Number(subTotal).toFixed(2);
    let hst = Number(Number(subTotal) * 0.15).toFixed(2);
    total = Number(Number(subTotal) + Number(hst)).toFixed(2);
    html += `</tbody><tfoot><tr><td colspan='6'>subTotal</td><td>${formatter.format(subTotal)}</td></tr><tr><td colspan='6'>HST 15%</td><td>${formatter.format(hst)}</td></tr><tr><td colspan='6'>Order Total</td><td>${formatter.format(total)}</td></tr></tfoot></table>`;

    items.subTotal = subTotal;
    items.hst = hst;
    items.orderTotal = total;
    orderDiv.innerHTML = html;
}

async function getSize(id) {
    try {
        let res = await fetch("/pizzasize/" + id);

        if (!res.ok) {
            alert(res.status + "\n" + res.error);
            return;
        }

        return res.json();

    } catch (err) {
        alert(err);
    }
}

async function getTopping(id) {
    try {
        let res = await fetch("/pizzatopping/" + id);

        if (!res.ok) {
            alert(res.status + "\n" + res.error);
            return;
        }

        return res.json();

    } catch (err) {
        alert(err);
    }
}

async function getCrust(id) {
    try {
        let res = await fetch("/pizzacrust/" + id);

        if (!res.ok) {
            alert(res.status + "\n" + res.error);
            return;
        }

        return res.json();

    } catch (err) {
        alert(err);
    }
}

async function processOrder() {
    console.log("clicking");
    let subTotal = items.subTotal;
    let orderTotal = items.orderTotal;
    let hst = items.hst;


    let obj = {
        customer: {id: 1},
        subTotal: subTotal,
        orderTotal: orderTotal,
        hst: hst,
        delivery: 1,
        deliveryDate: new Date()
    };

    try {
        let res = await fetch("/order", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })

        if (!res.ok) {
            alert(res.status + "\n" + res.error);
            return;
        }

        let data = res.json();
        return data;
        //await processPizzas(data.id);
    } catch (err) {
        alert(err);
    }


}

async function processPizzas(id) {
    let data;
    for (i = 0; i < items.length; i++) {
        let obj = {
            order: {id:id},
            size: items[i].size,
            crust: items[i].crust,
            quantity: items[i].quantity,
            priceEach: items[i].priceEach,
            totalPrice: items[i].totalPrice
        };

        try {
            let res = await fetch("/pizza", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(obj)
            });

            if (!res.ok) {
                return;
            }

            data = res.json();

        } catch (err) {
            alert(err);
        }
        
    }
    return data;
}

async function processToppings(id) {
    for (i = 0; i < items.length; i++) {
        for (t = 0; t < items[i].toppings.length; t++) {
            let topping = items[i].toppings[t];
            let obj = {
                pizza: {id:id},
                topping: {id: topping.id}
            };
            try {
                let res = await fetch("/toppingmap", {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(obj)
                });

                if (!res.ok) {
                    return;
                }

                let data = res.json();
                

            } catch (err) {
                alert(err);
            }
        }
    }
   
}

async function completeOrder() {
    let orderid = await processOrder();
    let pizzaid = await processPizzas(orderid.id);
    console.log(pizzaid.id);
    let toppingmap = await processToppings(pizzaid.id);
    
    alert("Order placed");
    sessionStorage.removeItem("cart");
    items = [];
    
    window.location.href = "customerView.html";
}