document.addEventListener('DOMContentLoaded', function () {
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            const countries = data.map(country => country.name.common);

            countries.sort();

            populateDropdown('departure-country', countries);
            populateDropdown('destination-country', countries);
        })
        .catch(error => {
            console.error('Error fetching countries:', error);
        });
});

function populateDropdown(elementId, countries) {
    const selectElement = document.getElementById(elementId);

    countries.forEach(country => {
        const option = document.createElement('option');
        option.text = country;
        selectElement.appendChild(option);
    });
}
document.getElementById('arrival-date').min = new Date().toISOString().split('T')[0];

const toggleMenu = () => {
    const x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
};

// function validate() {
//     var departure = document.getElementById('departure-country').value;
//     var arrival = document.getElementById('destination-country').value;
//     var depdate = document.getElementById('departure-date').value;
//     var arrdate = document.getElementById('arrival-date').value;
//     var pclass = document.getElementById('class-type').value;
//     var pcount = document.getElementById('passenger-count').value;

//     var confirmationMessage = "Selected Departure Country: " + departure +
//           "\nSelected Destination Country: " + arrival +
//           "\nDeparture Date: " + depdate +
//           "\nArrival Date: " + arrdate +
//           "\nClass Type: " + pclass +
//           "\nNumber of Passengers: " + pcount;

//     if (confirm(confirmationMessage)) {
//         window.location.href = "landing.html";
//     } else {
//     }
//     return false;
// }


function displayPopup() {
    const popup = document.getElementById("confirmation-popup");
    popup.style.display = "block";
 
    // Get form input values
    
    const departureCountry = document.getElementById("departure-country").value;
    const destinationCountry = document.getElementById("destination-country").value;
    const departureDate = document.getElementById("departure-date").value;
    const arrivalDate = document.getElementById("arrival-date").value;
    const classType = document.getElementById("class-type").value;
    const passengerCount = document.getElementById("passenger-count").value;
 
    // Populate the popup with form data
    
    document.getElementById("popup-departure-country").textContent = departureCountry;
    document.getElementById("popup-destination-country").textContent = destinationCountry;
    document.getElementById("popup-departure-date").textContent = departureDate;
    document.getElementById("popup-arrival-date").textContent = arrivalDate;
    document.getElementById("popup-class-type").textContent = classType;
    document.getElementById("popup-passenger-count").textContent = passengerCount;
}
 
// Function to close the popup
function closePopup() {
    const popup = document.getElementById("confirmation-popup");
    popup.style.display = "none";
}
function doBooking() {
    window.location.href = 'landing.html';
}