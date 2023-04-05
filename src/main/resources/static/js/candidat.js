window.addEventListener("load", () => {
   document.querySelector("#toggl_formation").addEventListener("change", () => {
      if(document.querySelector("#toggl_formation").checked) {
         let xhr = new XMLHttpRequest();
         xhr.open("GET", "/candidat/getByFormation");
         xhr.responseType = "json";
         xhr.onreadystatechange = function () {
            if(this.readyState === 4 && this.status === 200) {
               xhr.send();
            }
         }
      }
   });
});