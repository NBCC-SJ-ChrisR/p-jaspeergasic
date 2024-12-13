let cart = [];
window.onload = async function () {
    await buildMenu();
    document.querySelector("#addBtn").addEventListener("click", addToCart)
    document.querySelector("#proceedBtn").addEventListener("click", goToCart)
};

async function getSizes() {
    let data;
    let res;
    try {
        res = await fetch("/pizzasize");
        data = await res.json();

        if (!res.ok) {
            console.log("error");
            return;
        }
    } catch (ex) {
        alert.log(ex);
    } finally {
        return data;
    }
}

async function getCrusts() {
    let data;
    let res;
    try {
        res = await fetch("/pizzacrust");
        data = await res.json();

        if (!res.ok) {
            console.log("error");
            return;
        }
    } catch (ex) {
        alert.log(ex);
    } finally {
        return data;
    }
}

async function getToppings() {
    let data;
    let res;
    try {
        res = await fetch("/pizzatopping/customer");
        data = await res.json();

        if (!res.ok) {
            console.log("error");
            return;
        }
    } catch (ex) {
        alert.log(ex);
    } finally {
        return data;
    }
}

async function buildMenu() {
    let sizes = await getSizes();
    let crusts = await getCrusts();
    let toppings = await getToppings();
    let sizeHtml = "";
    let crustHtml = "";
    let toppingsHtml = "";

    sizes.forEach((size) => sizeHtml += `<div class='p-1'><input id=size${size.id} type='radio' name='size' value=${size.id} ><label for='size${size.id}' class='p-1'>${size.name} - ${size.price}</label></div>`);
    crusts.forEach((crust) => crustHtml += `<div class='p-1'><input id=crust${crust.id} type='radio' name='crust' value=${crust.id}><label for='crust${crust.id}' class='p-1'>${crust.name} - ${crust.price}</label></div>`);
    toppings.forEach((top) => toppingsHtml += `<div class='p-1'><input id=top${top.id} type='checkbox' name='toppings' value=${top.id}><label for='crust${top.id}' class='p-1'>${top.name} - ${top.price}</label></div>`);

    document.querySelector("#sizesDiv").innerHTML += sizeHtml;
    document.querySelector("#crustsDiv").innerHTML += crustHtml;
    document.querySelector("#toppingsDiv").innerHTML += toppingsHtml;

}

function addToCart() {
    let toppings = [];
    let sizes = document.querySelectorAll("input[name=size]");
    let crusts = document.querySelectorAll("input[name=crust]");
    let top = document.querySelectorAll("input[name=toppings]:checked");
    let quantity = document.querySelector("#quantityInput").value;
    let size;
    let crust;

    top.forEach((topping) => toppings.push(topping.value));

    sizes.forEach((s) => {
        s.checked === true ? size = s.value : "";
    })
    crusts.forEach((c) => {
        c.checked === true ? crust = c.value : "";
    })

    if (size === undefined || size === null) {
        alert("Select a size.");
        return;
    }
    if (crust === undefined || crust === null) {
        alert("Select a crust.");
        return;
    }
    if (toppings.length < 1) {
        alert("Select at least one topping.");
        return;
    }
    if(quantity < 1 && quantity > 5){
        alert("Select valid quantity(1-5)");
    }

    let obj = {
        size: size,
        crust: crust,
        quantity: quantity,
        toppings: toppings
//        priceEach: price,
//        totalPrice: total
    };
    
    cart.push(obj);
    
    document.querySelector("#proceedBtn").removeAttribute("disabled");
    document.querySelector("#proceedBtn").innerText = `Go to Cart (${cart.length})`;
        
    sessionStorage.setItem("cart", JSON.stringify(cart));
    alert("Added to Cart");
//    let storedArray = JSON.parse(sessionStorage.getItem("cart"));
//    for (i = 0; i < storedArray.length; i++) {
//        console.log(storedArray[i]);
//    }
    clearSelections();
}

function clearSelections() {
    let sizes = document.querySelectorAll("input[name=size]");
    let crusts = document.querySelectorAll("input[name=crust]");
    let top = document.querySelectorAll("input[name=toppings]:checked");
    document.querySelector("#quantityInput").value = 1;

    top.forEach((t) => t.checked = false);
    sizes.forEach((s) => s.checked === true ? s.checked = false : "");
    crusts.forEach((c) => c.checked === true ? c.checked = false : "");
}

function goToCart(){
    window.location.href = "customerOrder.html"
}



