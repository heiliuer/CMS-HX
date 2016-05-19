jQuery(function() {
	$("[data-file-upload]")
			.each(
					function() {
						var $root = $(this);
						var $imgsInput = $($root.data("imgs-input"));
						var $file = $root.find("input:file");
						var $previewHolder = $root.find("[data-previews]");
						$file.on("change", function() {
							upload();
						});
						$previewHolder.on("click", ".del", function() {
							$(this).parent("div").remove();
							updateImgsInput();
						});

						var updateImgsInput = function() {
							$imgsInput.val($root.find("[data-img]").map(
									function() {
										return $(this).data("img");
									}).get().join(","));
						}
						
						updateImgsInput();
						var upload = function() {
							var oMyForm = new FormData();
							// fileInputElement中已经包含了用户所选择的文件
							oMyForm.append("file", $file[0].files[0]);
							oMyForm.append("filename", $file[0].value);
							console.log("oMyForm:", oMyForm);

							$
									.ajax({
										url : "/file",
										type : "POST",
										cache : false,
										dataType : "json",
										processData : false,// 这个需要加，否则jquery不支持文件
										// contentType : "multipart/form-data",
										contentType : false,// 这个需要加，否则后台无法检测上传的文件
										data : oMyForm,
										success : function(data, status) {
											console.log("success:", data,
													status);
											$previewHolder
													.append("<div data-img='"
															+ data.data.path
															+ "'><img src='"
															+ data.data.path
															+ "' class='preview'/><span class='del'>x</span></div>");
											$file.val("");
											updateImgsInput();
										},
										error : function(data, status) {
											console.log("error:", data, status);
											$file.val("");
										}
									})
						}
					})
});