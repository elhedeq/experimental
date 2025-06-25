mapScript = document.createElement('script');
mapScript.src = `https://maps.googleapis.com/maps/api/js?key=${apiKeys.googleMapsKey}&loading=async&libraries=maps&v=beta`;
document.body.appendChild(mapScript);

const myip = document.querySelector('#myip');
const ipField=document.querySelector("#ip");
const result = document.querySelector('#result');

document.querySelector('form').addEventListener('submit', filterInput);
myip.addEventListener('click',getmyip);

async function getmyip(event){
    response = await fetch('https://4.ident.me/json',{method:'GET',});
    data = await response.json();
    getInfo(data.ip);
}

function filterInput(event){
    event.preventDefault();
    ip = ipField.value.trim();
    if (ip.match(/^[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}$/g)){
        valid = true;
        valid = ip.split('.').map(sector => {
            sector = parseInt(sector);
            if (sector>255 || sector<0){
                return false;
            }
            return true;
        }).reduce((final,ac)=>final &=ac);
        if (!valid) {
            result.innerText = 'IPv4: xxx.xxx.xxx.xxx numbers [0-255]';
            return;
        }
        getInfo(ip)
    return;
    }
    result.innerText = 'IPv4: xxx.xxx.xxx.xxx numbers [0-255]';
}

async function getInfo(ip){
    try {
        let response = await fetch(`https://json.geoiplookup.io/${ip}`,{method:'GET'});
        let info = await response.json();
        result.innerText = `
                            IP: ${info.ip}
                            ISP: ${info.isp}
                            Organizatio: ${info.org}
                            Host Name: ${info.hostname}
                            Longitude: ${info.longitude}
                            Latitude: ${info.latitude}
                            Postal Code: ${info.postal_code}
                            City: ${info.city}
                            Country Code: ${info.country_code}
                            Country Name: ${info.country_name}
                            Continent Code: ${info.continent_code}
                            Region: ${info.region}
                            District: ${info.district}
                            Timezone: ${info.timezone_name}
                            Connection Type: ${info.connection_type}
                            ASN: ${info.asn}
                            Currency Code: ${info.currency_code}
                            Currency Name: ${info.currency_name}                
                            `;
        initMap(info.latitude,info.longitude);
    } catch (err) {
        console.log(err);
    }
}

async function initMap(lat,lng) {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: lat, lng: lng },
    zoom: 8,
  });
  let marker = new google.maps.Marker({
    position: {lat,lng},
    map: map,
  });
  
//   google.maps.event.addListener(map, 'click',(e)=>{
//     console.log(e);
//     new google.maps.Marker({
//     position: e.latLng,
//     map: map,
//   });
// });
}
