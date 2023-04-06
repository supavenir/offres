window.addEventListener("load", () => {
   // Switch du listage standard des candidats au listage par formation
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

   // (Un/)Check all checkboxes on click on select all checkbox
   document.querySelector("#select_all").addEventListener("change", () => {
      if (document.querySelector("#select_all").checked) {
         document.querySelectorAll(".checkbox_candidat").forEach((oneCheckbox) => {
            oneCheckbox.checked = true;
         })
      } else {
         document.querySelectorAll(".checkbox_candidat").forEach((oneCheckbox) => {
            oneCheckbox.checked = false;
         })
      }
   });
});