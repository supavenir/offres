window.addEventListener("load", () => {
   document.querySelector("#toggl_formation").addEventListener("change", () => {
      if(document.querySelector("#toggl_formation").checked) {
         let xhr = new XMLHttpRequest();
         xhr.onreadystatechange = function () {
            // console.log(this)
            if(this.status === 200 && this.readyState === 4) {
               let tbodyContentByFormation = this.responseText.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
               // console.log(tbodyContent)
               document.querySelector("tbody").innerHTML = tbodyContentByFormation;
            }
         };
         xhr.open("GET", "/candidat/getByFormation", true);
         xhr.send();
      } else {
         let xhr = new XMLHttpRequest();
         xhr.onreadystatechange = function () {
            // console.log(this)
            if(this.status === 200 && this.readyState === 4) {
               let tbodyContent = this.responseText.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
               // console.log(tbodyContent)
               document.querySelector("tbody").innerHTML = tbodyContent;
            }
         };
         xhr.open("GET", "/candidat/index", true);
         xhr.send();
      }
   });
});