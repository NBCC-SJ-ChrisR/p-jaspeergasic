window.onload = function () {
    document.querySelector("#createBtn").addEventListener("click", createAccount);
};

async function createAccount(e) {
    e.preventDefault();
    let firstName = document.querySelector("#inputFirst").value;
    let lastName = document.querySelector("#inputLast").value;
    let pass = document.querySelector("#inputPass").value;
    let email = document.querySelector("#inputEmail").value;
    let street = document.querySelector("#inputStreet").value;
    let house = Number(document.querySelector("#inputHouse").value);
    let prov = document.querySelector("#inputProv").value;
    let postal = document.querySelector("#inputPostal").value;
    let phone = document.querySelector("#inputPhone").value;

    let obj = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        street: street,
        password: pass,
        postalCode: postal,
        houseNumber: house,
        province: prov,
        phoneNumber: phone

    };

    try {
        let res = await fetch("/customer", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        });
        
        if(!res.ok){
            alert(res.status);
            return;
        }
        
        alert("Account Created.");x
        clearForm();
    } catch (error) {
        alert(error);
    }
}

function clearForm() {
    document.querySelector("#inputPhone").value = "";
    document.querySelector("#inputFirst").value = "";
    document.querySelector("#inputLast").value = "";
    document.querySelector("#inputEmail").value = "";
    document.querySelector("#inputStreet").value = "";
    document.querySelector("#inputHouse").value = 0;
    document.querySelector("#inputProv").value = "";
    document.querySelector("#inputPostal").value = "";
}
