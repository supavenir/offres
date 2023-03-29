window.onload = function () {
    document.getElementById("input_cp").addEventListener("input", function () {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", "https://geo.api.gouv.fr/communes?codePostal=61200&fields=codesPostaux&format=json&geometry=centre", false ); // false for synchronous request
        xmlHttp.send( null );
        document.getElementById('input_adresse').innerHTML = xmlHttp.responseText;
    });

    function adresse() {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", "https://geo.api.gouv.fr/communes?codePostal=61200&fields=codesPostaux&format=json&geometry=centre", false ); // false for synchronous request
        xmlHttp.send( null );
        return xmlHttp.responseText;
    }
}