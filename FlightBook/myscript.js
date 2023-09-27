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

const toggleMenu = () => {
    const x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
};

function validate() {
    var departure = document.getElementById('departure-country').value;
    var arrival = document.getElementById('destination-country').value;
    var depdate = document.getElementById('departure-date').value;
    var arrdate = document.getElementById('arrival-date').value;
    var pclass = document.getElementById('class-type').value;
    var pcount = document.getElementById('passenger-count').value;

    var confirmationMessage = "Selected Departure Country: " + departure +
          "\nSelected Destination Country: " + arrival +
          "\nDeparture Date: " + depdate +
          "\nArrival Date: " + arrdate +
          "\nClass Type: " + pclass +
          "\nNumber of Passengers: " + pcount;

    if (confirm(confirmationMessage)) {
        window.location.href = "landing.html";
    } else {
    }
    return false;
}
