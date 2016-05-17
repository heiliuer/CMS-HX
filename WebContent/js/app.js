jQuery(function () {
    $("[data-file-upload]").each(function () {
        var $root = $(this);
        var $file = $("input:file");
        $file.on("change", function () {
            upload();
        });
        var upload = function () {
            var oMyForm = new FormData();
            oMyForm.append("filename", $file[0].value);
            // fileInputElement中已经包含了用户所选择的文件
            oMyForm.append("file", $file[0]);
            var oReq = new XMLHttpRequest();
            oReq.open("POST", "/file");
            oReq.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
            oReq.send(oMyForm);
        }
    })
});