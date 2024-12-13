let addOrUpdate = "";
window.onload = async function () {
    await getToppings();
    document.querySelector("#addTop").addEventListener("click", addItem);
    document.querySelector("#deleteTop").addEventListener("click", deleteItem);
    document.querySelector("#editTop").addEventListener("click", updateItem);
//    document.querySelector("#disableTop").addEventListener("click", disableItem);
    document.querySelector("#submitBtn").addEventListener("click", processForm);
    document.querySelector("#cancelBtn").addEventListener("click", cancelAddUpdate);
    document.querySelector("table").addEventListener("click", handleRowClick);

};

function clearSelections() {
    let trs = document.querySelectorAll("tr");
    for (let i = 0; i < trs.length; i++) {
        trs[i].classList.remove("table-active");
    }
}

function refreshSelect() {
    document.querySelector("table").addEventListener("click", handleRowClick);
}

function handleRowClick(e) {
    //add style to parent of clicked cell
    clearSelections();
    e.target.parentElement.classList.add("table-active");

    // enable Delete and Update buttons
    document.querySelector("#deleteTop").removeAttribute("disabled");
    document.querySelector("#editTop").removeAttribute("disabled");
    document.querySelector("#disableTop").removeAttribute("disabled");
}

function disableButtons(){
    document.querySelector("#deleteTop").setAttribute("disabled","");
    document.querySelector("#editTop").setAttribute("disabled","");
    document.querySelector("#disableTop").setAttribute("disabled","");
}

function cancelAddUpdate() {
    hideUpdatePanel();
    clearSelections();
}

function hideUpdatePanel() {
    document.querySelector("#AddUpdatePanel").setAttribute("hidden", "");
}

function addItem() {
    // Show panel, panel handler takes care of the rest
    addOrUpdate = "add";
    resetUpdatePanel();
    showUpdatePanel();
    clearSelections();
}

function updateItem() {
    addOrUpdate = "update";
    resetUpdatePanel();
    populateUpdatePanelWithSelectedItem();
    showUpdatePanel();
}

function resetUpdatePanel() {
    document.querySelector("#idInput").value = "";
    document.querySelector("#toppingName").value = "";
    document.querySelector("#priceInput").value = 0.00;
    document.querySelector("#activeInput").checked = false;
}

function showUpdatePanel() {
    let idLabel = document.querySelector("label[for='idInput']");
    document.querySelector("#AddUpdatePanel").removeAttribute("hidden");
    if (addOrUpdate === "update") {
        document.querySelector("#idDiv").removeAttribute("hidden", "");
        document.querySelector("#idInput").setAttribute("disabled", "");
        idLabel.removeAttribute("hidden");
    } else {
        document.querySelector("#idDiv").setAttribute("hidden", "");
    }
}

function populateUpdatePanelWithSelectedItem() {
    let tds = document.querySelector(".table-active").querySelectorAll("td");
    document.querySelector("#idInput").value = tds[0].innerHTML;
    document.querySelector("#toppingName").value = tds[1].innerHTML;
    document.querySelector("#priceInput").value = tds[2].innerHTML;
    let checked = tds[3].innerText == "Yes" ? true : false;
    document.querySelector("#activeInput").checked = checked;
}

async function getToppings() {
    let data;
    let res;
    try {
        res = await fetch("/pizzatopping");
        data = await res.json();

        if (!res.ok) {
            console.log("error");
            return;
        }
    } catch (ex) {
        alert.log(ex);
    } finally {
        buildToppings(data);
    }
}



function buildToppings(data) {
    let html = "<table class='table table-bordered table-sm w-auto table-hover'><thead><th>ID</th><th>Topping</th><th>Price</th><th>Active</th></thead><tbody>";
    data.forEach((topping) => {
        let active = topping.isActive === 1 ? "Yes" : "No";
        html += `<tr><td>${topping.id}</td><td>${topping.name}</td><td>${topping.price}</td><td>${active}</td></tr>`;
    });
    html += "<tbody></table>";

    let table = document.querySelector("#toppingDiv");
    table.innerHTML = html;
}

async function processForm() {
    let topId = document.querySelector("#idInput").value;
    let name = document.querySelector("#toppingName").value;
    let price = document.querySelector("#priceInput").value;
    let checked = document.querySelector("#activeInput").checked;
    let active = checked === true ? 1 : 0;

    let obj = "";
    if (addOrUpdate === "add") {
        obj = {
            "name": name,
            "price": price,
            "isActive": active,
            //temp emp
            "empAddedBy": {id: 1}
        };
    } else {
        obj = {
            "id": topId,
            "name": name,
            "price": price,
            "isActive": active
        };
    }

    let url = addOrUpdate == "add" ? "/pizzatopping" : ("/pizzatopping/" + topId);
    let method = addOrUpdate == "add" ? "POST" : "PUT";
    try {
        let res = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        });

        if (!res.ok) {
            return;
        }

        let msg = addOrUpdate === "add" ? "Pizza added." : "Pizza updated.";
        alert(msg);
        await getToppings();


    } catch (err) {
        alert(err);
    }finally{
        refreshSelect();
        hideUpdatePanel();
        resetUpdatePanel();
        disableButtons();
    }


}

async function deleteItem() {
    let id = document.querySelector(".table-active").querySelectorAll("td")[0].innerHTML;
    let url = "/pizzatopping/" + id; //

    try {
        let res = await fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!res.ok) {
            return;
        }

        refreshSelect();
        alert("Pizza deleted.");
        disableButtons();
        await getToppings();

    } catch (err) {
        alert(err);
    }
}