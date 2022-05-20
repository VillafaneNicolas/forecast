document.addEventListener("DOMContentLoaded", function () {
    requestEveryFiveM();
});

let timeInterval;

function requestEveryFiveM() {
    getLocations();
    timeInterval = setInterval(getLocations, 300000);
}

async function getLocations() {

    const request = await fetch('api/forecast', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const locations = await request.json();

    console.log(locations);

    let listHtml = '';
    for (let location of locations) {

        let locationHtml = '<tr><th>' + location.name + ', ' + location.province + '</th>' +
            '<td>' + location.weather.tempDesc + '</td>' +
            '<td>' + location.weather.description + '</td><td>' + location.weather.st + 'º </td><td>' + location.weather.pressure + 'hPa </td>' +
            '<td>' + location.weather.visibility + 'km </td><td>' + location.weather.wind_speed + 'km/h</td>' +
            '<td>' + location.weather.wing_deg + '</td></tr>';

        listHtml += locationHtml;
    }

    document.querySelector('#locations tbody').outerHTML = listHtml;


}