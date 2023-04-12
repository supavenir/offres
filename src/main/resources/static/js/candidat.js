window.addEventListener("load", () => {
   // Partie 1 - Switch du listage standard des candidats au listage par formation
   document.querySelector("#toggl_formation").addEventListener("change", () => {
       let headers = new Headers();
       headers.append("x-partial_request", "true")
       if(document.querySelector("#toggl_formation").checked) {
         fetch("/candidat/getByFormation", {
             method: "GET"
         }).then(request => {
            request.text().then(requestBody => {
               if(request.ok === true) {
                  document.querySelector("tbody").innerHTML = requestBody;
                  /*let tbodyContentByFormation = requestBody.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
                  document.querySelector("tbody").innerHTML = tbodyContentByFormation;*/
               }
            })
         });
      } else {
         fetch("/candidat/index", {
             method: "GET",
             headers:headers
         }).then(request => {
            request.text().then(requestBody => {
               if(request.ok === true) {
                  console.log(request)
                  /*let tbody = requestBody.match(/<tbody>([\s\S]*?)<\/tbody>/i)[0].replace(/(<tbody>|<\/tbody>)/gmi, "");
                  document.querySelector("tbody").innerHTML = tbody;*/
               }
            })
         });
      }
   });

   // Partie 2 - (Un/)Check all checkboxes on click on select all checkbox
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