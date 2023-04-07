window.addEventListener("load", () => {
   // Switch du listage standard des candidats au listage par formation
   document.querySelector("#toggl_formation").addEventListener("change", () => {
      if(document.querySelector("#toggl_formation").checked) {
         fetch("/candidat/getByFormation", { method: "GET" }).then(request => {
            request.text().then(requestBody => {
               if(request.ok === true) {
                  let tbodyContentByFormation = requestBody.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
                  document.querySelector("tbody").innerHTML = tbodyContentByFormation;
               }
            })
         });
      } else {
         fetch("/candidat/index", { method: "GET" }).then(request => {
            request.text().then(requestBody => {
               if(request.ok === true) {
                  let tbody = requestBody.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
                  document.querySelector("tbody").innerHTML = tbody;
               }
            })
         });
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