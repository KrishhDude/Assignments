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

document.getElementById('booking-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const departureCountry = document.getElementById('departure-country').value;
    const destinationCountry = document.getElementById('destination-country').value;
    const departureDate = document.getElementById('departure-date').value;
    const arrivalDate = document.getElementById('arrival-date').value;
    const classType = document.getElementById('class-type').value;

    alert(`Booking details:
        Departure Country: ${departureCountry}
        Destination Country: ${destinationCountry}
        Departure Date: ${departureDate}
        Arrival Date: ${arrivalDate}
        Class Type: ${classType}`);
});


function toggleMenu() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
