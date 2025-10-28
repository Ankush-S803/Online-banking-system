let correctPIN = 2710;
let balance = 20000.0;

function verifyPin() {
  let enteredPin = document.getElementById("pinInput").value;
  let msg = document.getElementById("loginMsg");

  if (enteredPin == correctPIN) {
    document.getElementById("loginScreen").style.display = "none";
    document.getElementById("menuScreen").style.display = "block";
    msg.textContent = "";
  } else {
    msg.textContent = "Incorrect PIN! Try again.";
  }
}


function checkBalance() {
  document.getElementById("message").textContent = "Your current balance is ₹" + balance.toFixed(2);
}


function showDeposit() {
  document.getElementById("menuScreen").style.display = "none";
  document.getElementById("depositScreen").style.display = "block";
  document.getElementById("depositMsg").textContent = "";
}

function deposit() {
  let amount = parseFloat(document.getElementById("depositAmount").value);
  let msg = document.getElementById("depositMsg");

  if (amount > 0) {
    balance += amount;
    msg.textContent = "Deposit successful! New balance: ₹" + balance.toFixed(2);
    document.getElementById("depositAmount").value = "";
  } else {
    msg.textContent = "Enter a valid amount!";
  }
}


function showWithdraw() {
  document.getElementById("menuScreen").style.display = "none";
  document.getElementById("withdrawScreen").style.display = "block";
  document.getElementById("withdrawMsg").textContent = "";
}

function withdraw() {
  let amount = parseFloat(document.getElementById("withdrawAmount").value);
  let msg = document.getElementById("withdrawMsg");

  if (amount > 0 && amount <= balance) {
    balance -= amount;
    msg.textContent = "Withdrawal successful! Remaining balance: ₹" + balance.toFixed(2);
    document.getElementById("withdrawAmount").value = "";
  } else if (amount > balance) {
    msg.textContent = "Insufficient balance!";
  } else {
    msg.textContent = "Enter a valid amount!";
  }
}


function goBack() {
  document.getElementById("depositScreen").style.display = "none";
  document.getElementById("withdrawScreen").style.display = "none";
  document.getElementById("menuScreen").style.display = "block";
  document.getElementById("message").textContent = "";
}

function logout() {
  document.getElementById("menuScreen").style.display = "none";
  document.getElementById("loginScreen").style.display = "block";
  document.getElementById("pinInput").value = "";
  document.getElementById("loginMsg").textContent = "";
  document.getElementById("message").textContent = "";
}