document.querySelector("#files").addEventListener("change", (e) => {
  if (window.File && window.FileReader && window.FileList && window.Blob) {
    const files = e.target.files;
    const output = document.querySelector("#result");
    output.innerHTML = "";
    var count = 0;
    for (let i = 0; i < files.length; i++) {
      if (!files[i].type.match("image")) continue;
      const picReader = new FileReader();
      picReader.addEventListener("load", function (event) {
        const picFile = event.target;
        const div = document.createElement("div");
        div.innerHTML = `<img class="thumbnail"  style="width:150px;height:150px; float:left;" src="${picFile.result}" title="${picFile.name}"/>`;
        div.style.width="600x";
        output.appendChild(div);  
      });
      picReader.readAsDataURL(files[i]);
    }
  } else {
    alert("Your browser does not support File API");
  }
});
