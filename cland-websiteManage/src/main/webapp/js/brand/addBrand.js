$(document).ready(function() {
	
	// enable fileupload plugin
	$('#sLogoFile').fileuploader({
        limit: 1, // limit of the files {Number}
        maxSize: 5, // files maximal size in Mb {Number}
        fileMaxSize: 5, // file maximal size in Mb {Number}
        extensions: ['jpg', 'jpeg', 'png', 'bmp'], // allowed extensions or types {Array}
		changeInput: '<div class="fileuploader-input">' +
		                  '<div class="fileuploader-input-caption">' +
                              '<span>${captions.feedback}</span>' +
                          '</div>' +
                          '<div class="fileuploader-input-button">' +
                              '<span>${captions.button}</span>' +
                          '</div>' +
                      '</div>',
		inputNameBrackets: true,
        theme: 'default',
        thumbnails: {
			box: '<div class="fileuploader-items">' +
                      '<ul class="fileuploader-items-list"></ul>' +
                  '</div>',
			boxAppendTo: null,
			item: '<li class="fileuploader-item">' +
                       '<div class="columns">' +
                       '<a href="javascript:void(0);" onclick="">' +
	                           '<div class="column-thumbnail">${image}</div>' +
	                           '<div class="column-title">' +
	                               '<div title="${name}">${name}</div>' +
	                               '<span>${size2}</span>' +
	                           '</div>' +
                           '</a>' +
                           '<div class="column-actions">' +
                               '<a class="fileuploader-action fileuploader-action-remove" title="Remove"><i></i></a>' +
                           '</div>' +
                       '</div>' +
                       '<div class="progress-bar2">${progressBar}<span></span></div>' +
                   '</li>',
            item2: '<li class="fileuploader-item">' +
                        '<div class="columns">' +
                            '<a href="javascript:void(0);" onclick="">' +
                                '<div class="column-thumbnail">${image}</div>' +
                                '<div class="column-title">' +
                                    '<div title="${name}">${name}</div>' +
                                    '<span></span>' +
                                '</div>' +
                            '</a>' +
                            '<div class="column-actions">' +
                                '<a href="${file}" class="fileuploader-action fileuploader-action-download" title="Download" download><i></i></a>' +
                                '<a class="fileuploader-action fileuploader-action-remove" title="Remove"><i></i></a>' +
                            '</div>' +
                        '</div>' +
                    '</li>',
			itemPrepend: false,
			removeConfirmation: true,
			startImageRenderer: true,
			synchronImages: true,
			canvasImage: {
				width: null,
				height: null
			},
			_selectors: {
				list: '.fileuploader-items-list',
				item: '.fileuploader-item',
				start: '.fileuploader-action-start',
				retry: '.fileuploader-action-retry',
				remove: '.fileuploader-action-remove'
			},
        	beforeShow: function(parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onItemShow: function(item, listEl, parentEl, newInputEl, inputEl) {
				if(item.choosed)
					item.html.find('.column-actions').prepend(
						'<a class="fileuploader-action fileuploader-action-start" title="Start upload"><i></i></a>'
					);
			},
            onItemRemove: function(itemEl, listEl, parentEl, newInputEl, inputEl) {
                itemEl.children().animate({'opacity': 0}, 200, function() {
                    setTimeout(function() {
                        itemEl.slideUp(200, function() {
                            itemEl.remove(); 
                        });
                    }, 100);
                });
            },
			onImageLoaded: function(itemEl, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
		},
        upload: {
            url: ctx + "/file/fileUpload.htm",
            data: {
		  		isTest: 'yes'
		    },
            type: 'POST',
            enctype: 'multipart/form-data',
            start: false,
            synchron: false,
            dataType: "json",
            beforeSend: function(item, listEl, parentEl, newInputEl, inputEl) {
				item.upload.data.isTest = 'no';
				
				return true;
			},
            onSuccess: function(data, item, listEl, parentEl, newInputEl, inputEl, textStatus, jqXHR) {
            	if(data){
            		data = JSON.parse(data);
            	}
            	if(data.error == 0) {
            		item.html.find('.column-actions').append('<a class="fileuploader-action fileuploader-action-remove fileuploader-action-success" title="Remove"><i></i></a>');
                    
                    setTimeout(function() {
                        item.html.find('.progress-bar2').fadeOut(400);
                    }, 400);
                	$('#sLogo').val(data.url);
            	}else {
            		var progressBar = item.html.find('.progress-bar2');
    				
    				if(progressBar.length > 0) {
    					progressBar.find('span').html(0 + "%");
                        progressBar.find('.fileuploader-progressbar .bar').width(0 + "%");
    					item.html.find('.progress-bar2').fadeOut(400);
    				}
                    
                    item.upload.status != 'cancelled' && item.html.find('.fileuploader-action-retry').length == 0 ? item.html.find('.column-actions').prepend(
                        '<a class="fileuploader-action fileuploader-action-retry" title="Retry"><i></i></a>'
                    ) : null;
            	}
            },
            onError: function(item, listEl, parentEl, newInputEl, inputEl, jqXHR, textStatus, errorThrown) {
				var progressBar = item.html.find('.progress-bar2');
				
				if(progressBar.length > 0) {
					progressBar.find('span').html(0 + "%");
                    progressBar.find('.fileuploader-progressbar .bar').width(0 + "%");
					item.html.find('.progress-bar2').fadeOut(400);
				}
                
                item.upload.status != 'cancelled' && item.html.find('.fileuploader-action-retry').length == 0 ? item.html.find('.column-actions').prepend(
                    '<a class="fileuploader-action fileuploader-action-retry" title="Retry"><i></i></a>'
                ) : null;
            },
            onProgress: function(data, item, listEl, parentEl, newInputEl, inputEl) {
                var progressBar = item.html.find('.progress-bar2');
				
                if(progressBar.length > 0) {
                    progressBar.show();
                    progressBar.find('span').html(data.percentage + "%");
                    progressBar.find('.fileuploader-progressbar .bar').width(data.percentage + "%");
                }
            },
            onComplete: function(listEl, parentEl, newInputEl, inputEl, jqXHR, textStatus) {

			},
        },
        dragDrop: {
			container: null,
			onDragEnter: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onDragLeave: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onDrop: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			
	    },
        addMore: false,
        files: handleInit($('#sLogo').val()),
        clipboardPaste: 2000,
        listInput: true,
        enableApi: true,
		listeners: {
			click: function(event) {
				// input was clicked
			}	
		},
		onSupportError: function(parentEl, inputEl) {
			// your callback here
		},
        beforeRender: function(parentEl, inputEl) {
			// your callback here
			
			return true;
		},
        afterRender: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
        beforeSelect: function(files, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
			return true;
		},
        onFilesCheck: function(files, options, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
			return true;
		},
        onSelect: function(item, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
		afterSelect: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
        onListInput: function(list, fileList, listInputEl, listEl, parentEl, newInputEl, inputEl) {
			// your callback
			
			return list;
		},
        onRemove: function(item, listEl, parentEl, newInputEl, inputEl) {
        	$.ajax({
				url : ctx + "/file/del.htm",
				async : false,
				type : "post",
				data : {
					"url" : $('#sLogo').val()
				},
				dataType : "json",
				success : function(result) {
					if (result.code == 0) {
						$('#sLogo').val("");
					} else {
						BootstrapDialog.alert(result.message);
					}
				},
				error : function() {
					BootstrapDialog.alert("操作失败");
				}
			});
			return true;
		},
        onEmpty: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback
		},
        dialogs: {
            alert: function(text) {
            	return BootstrapDialog.alert(text);
            },
            confirm: function(text, callback) {
            	BootstrapDialog.confirm("确定要删除宣传图片吗？", function(isOk) {
            		if (isOk) {
            			callback();
            		}
            	});
            }
        },
        captions: {
            button: function(options) { return '选择图片' },
            feedback: function(options) { return '未选择' },
            feedback2: function(options) { return '已选择 '},
            drop: 'Drop the files here to Upload',
            paste: '<div class="fileuploader-pending-loader"><div class="left-half" style="animation-duration: ${ms}s"></div><div class="spinner" style="animation-duration: ${ms}s"></div><div class="right-half" style="animation-duration: ${ms}s"></div></div> Pasting a file, click here to cancel.',
            removeConfirmation: '确认删除图片?',
            errors: {
            	filesLimit: '只允许上传${limit}张图片.',
                filesType: '只允许上传 ${extensions} 格式的文件.',
                fileSize: '${name} 文件过大，文件大小应低于 ${fileMaxSize}MB.',
                filesSizeAll: '所选文件过大，文件总大小应低于 ${maxSize} MB.',
                fileName: '所选文件 ${name} 的文件名已存在.',
                folderUpload: '无法上传文件夹.'
            }
        }
	});
	
	$('#sLogoHoverFile').fileuploader({
        limit: 1, // limit of the files {Number}
        maxSize: 5, // files maximal size in Mb {Number}
        fileMaxSize: 5, // file maximal size in Mb {Number}
        extensions: ['jpg', 'jpeg', 'png', 'bmp'], // allowed extensions or types {Array}
		changeInput: '<div class="fileuploader-input">' +
		                  '<div class="fileuploader-input-caption">' +
                              '<span>${captions.feedback}</span>' +
                          '</div>' +
                          '<div class="fileuploader-input-button">' +
                              '<span>${captions.button}</span>' +
                          '</div>' +
                      '</div>',
		inputNameBrackets: true,
        theme: 'default',
        thumbnails: {
			box: '<div class="fileuploader-items">' +
                      '<ul class="fileuploader-items-list"></ul>' +
                  '</div>',
			boxAppendTo: null,
			item: '<li class="fileuploader-item">' +
                       '<div class="columns">' +
                       '<a href="javascript:void(0);" onclick="">' +
	                           '<div class="column-thumbnail">${image}</div>' +
	                           '<div class="column-title">' +
	                               '<div title="${name}">${name}</div>' +
	                               '<span>${size2}</span>' +
	                           '</div>' +
                           '</a>' +
                           '<div class="column-actions">' +
                               '<a class="fileuploader-action fileuploader-action-remove" title="Remove"><i></i></a>' +
                           '</div>' +
                       '</div>' +
                       '<div class="progress-bar2">${progressBar}<span></span></div>' +
                   '</li>',
            item2: '<li class="fileuploader-item">' +
                        '<div class="columns">' +
                            '<a href="javascript:void(0);" onclick="">' +
                                '<div class="column-thumbnail">${image}</div>' +
                                '<div class="column-title">' +
                                    '<div title="${name}">${name}</div>' +
                                    '<span></span>' +
                                '</div>' +
                            '</a>' +
                            '<div class="column-actions">' +
                                '<a href="${file}" class="fileuploader-action fileuploader-action-download" title="Download" download><i></i></a>' +
                                '<a class="fileuploader-action fileuploader-action-remove" title="Remove"><i></i></a>' +
                            '</div>' +
                        '</div>' +
                    '</li>',
			itemPrepend: false,
			removeConfirmation: true,
			startImageRenderer: true,
			synchronImages: true,
			canvasImage: {
				width: null,
				height: null
			},
			_selectors: {
				list: '.fileuploader-items-list',
				item: '.fileuploader-item',
				start: '.fileuploader-action-start',
				retry: '.fileuploader-action-retry',
				remove: '.fileuploader-action-remove'
			},
        	beforeShow: function(parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onItemShow: function(item, listEl, parentEl, newInputEl, inputEl) {
				if(item.choosed)
					item.html.find('.column-actions').prepend(
						'<a class="fileuploader-action fileuploader-action-start" title="Start upload"><i></i></a>'
					);
			},
            onItemRemove: function(itemEl, listEl, parentEl, newInputEl, inputEl) {
                itemEl.children().animate({'opacity': 0}, 200, function() {
                    setTimeout(function() {
                        itemEl.slideUp(200, function() {
                            itemEl.remove(); 
                        });
                    }, 100);
                });
            },
			onImageLoaded: function(itemEl, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
		},
        upload: {
            url: ctx + "/file/fileUpload.htm",
            data: {
		  		isTest: 'yes'
		    },
            type: 'POST',
            enctype: 'multipart/form-data',
            start: false,
            synchron: false,
            dataType: "json",
            beforeSend: function(item, listEl, parentEl, newInputEl, inputEl) {
				item.upload.data.isTest = 'no';
				
				return true;
			},
            onSuccess: function(data, item, listEl, parentEl, newInputEl, inputEl, textStatus, jqXHR) {
            	if(data){
            		data = JSON.parse(data);
            	}
            	if(data.error == 0) {
            		item.html.find('.column-actions').append('<a class="fileuploader-action fileuploader-action-remove fileuploader-action-success" title="Remove"><i></i></a>');
                    
                    setTimeout(function() {
                        item.html.find('.progress-bar2').fadeOut(400);
                    }, 400);
                	$('#sLogoHover').val(data.url);
            	}else {
            		var progressBar = item.html.find('.progress-bar2');
    				
    				if(progressBar.length > 0) {
    					progressBar.find('span').html(0 + "%");
                        progressBar.find('.fileuploader-progressbar .bar').width(0 + "%");
    					item.html.find('.progress-bar2').fadeOut(400);
    				}
                    
                    item.upload.status != 'cancelled' && item.html.find('.fileuploader-action-retry').length == 0 ? item.html.find('.column-actions').prepend(
                        '<a class="fileuploader-action fileuploader-action-retry" title="Retry"><i></i></a>'
                    ) : null;
            	}
            },
            onError: function(item, listEl, parentEl, newInputEl, inputEl, jqXHR, textStatus, errorThrown) {
				var progressBar = item.html.find('.progress-bar2');
				
				if(progressBar.length > 0) {
					progressBar.find('span').html(0 + "%");
                    progressBar.find('.fileuploader-progressbar .bar').width(0 + "%");
					item.html.find('.progress-bar2').fadeOut(400);
				}
                
                item.upload.status != 'cancelled' && item.html.find('.fileuploader-action-retry').length == 0 ? item.html.find('.column-actions').prepend(
                    '<a class="fileuploader-action fileuploader-action-retry" title="Retry"><i></i></a>'
                ) : null;
            },
            onProgress: function(data, item, listEl, parentEl, newInputEl, inputEl) {
                var progressBar = item.html.find('.progress-bar2');
				
                if(progressBar.length > 0) {
                    progressBar.show();
                    progressBar.find('span').html(data.percentage + "%");
                    progressBar.find('.fileuploader-progressbar .bar').width(data.percentage + "%");
                }
            },
            onComplete: function(listEl, parentEl, newInputEl, inputEl, jqXHR, textStatus) {

			},
        },
        dragDrop: {
			container: null,
			onDragEnter: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onDragLeave: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			onDrop: function(event, listEl, parentEl, newInputEl, inputEl) {
				// your callback here
			},
			
	    },
        addMore: false,
        files: handleInit($('#sLogoHover').val()),
        clipboardPaste: 2000,
        listInput: true,
        enableApi: true,
		listeners: {
			click: function(event) {
				// input was clicked
			}	
		},
		onSupportError: function(parentEl, inputEl) {
			// your callback here
		},
        beforeRender: function(parentEl, inputEl) {
			// your callback here
			
			return true;
		},
        afterRender: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
        beforeSelect: function(files, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
			return true;
		},
        onFilesCheck: function(files, options, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
			return true;
		},
        onSelect: function(item, listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
		afterSelect: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback here
		},
        onListInput: function(list, fileList, listInputEl, listEl, parentEl, newInputEl, inputEl) {
			// your callback
			
			return list;
		},
        onRemove: function(item, listEl, parentEl, newInputEl, inputEl) {
        	$.ajax({
				url : ctx + "/file/del.htm",
				async : false,
				type : "post",
				data : {
					"url" : $('#sLogo').val()
				},
				dataType : "json",
				success : function(result) {
					if (result.code == 0) {
						$('#sLogoHover').val("");
					} else {
						BootstrapDialog.alert(result.message);
					}
				},
				error : function() {
					BootstrapDialog.alert("操作失败");
				}
			});
			return true;
		},
        onEmpty: function(listEl, parentEl, newInputEl, inputEl) {
			// your callback
		},
        dialogs: {
            alert: function(text) {
            	return BootstrapDialog.alert(text);
            },
            confirm: function(text, callback) {
            	BootstrapDialog.confirm("确定要删除宣传图片吗？", function(isOk) {
            		if (isOk) {
            			callback();
            		}
            	});
            }
        },
        captions: {
            button: function(options) { return '选择图片' },
            feedback: function(options) { return '未选择' },
            feedback2: function(options) { return '已选择 '},
            drop: 'Drop the files here to Upload',
            paste: '<div class="fileuploader-pending-loader"><div class="left-half" style="animation-duration: ${ms}s"></div><div class="spinner" style="animation-duration: ${ms}s"></div><div class="right-half" style="animation-duration: ${ms}s"></div></div> Pasting a file, click here to cancel.',
            removeConfirmation: '确认删除图片?',
            errors: {
            	filesLimit: '只允许上传${limit}张图片.',
                filesType: '只允许上传 ${extensions} 格式的文件.',
                fileSize: '${name} 文件过大，文件大小应低于 ${fileMaxSize}MB.',
                filesSizeAll: '所选文件过大，文件总大小应低于 ${maxSize} MB.',
                fileName: '所选文件 ${name} 的文件名已存在.',
                folderUpload: '无法上传文件夹.'
            }
        }
	});
});

function handleInit(urlText) {
	var arr = new Array();
	if(urlText != "" && urlText != null) {
		var obj = new Object();
		var fileName = urlText.substring(urlText.lastIndexOf("/") + 1);
		obj.name = fileName;
        obj.file = urlText;
        var data = new Object();
        data.url = urlText;
        obj.data = data;
        arr.push(obj);
	}
	return arr;
}

function doSummit() {
	var flag = true;
	var sLogo = $('#sLogo').val();
	if (ChkUtil.isNull(sLogo)) {
		flag = false;
		BootstrapDialog.alert("请上传logo图片");
		return;
	}
	var sLogoHover = $('#sLogoHover').val();
	if (ChkUtil.isNull(sLogoHover)) {
		flag = false;
		BootstrapDialog.alert("请上传logo的hover状态图片");
		return;
	}
	var sLinkUrl = $('#sLinkUrl').val();
	if (!ChkUtil.isNull(sLinkUrl) && !ChkUtil.isUrl(sLinkUrl)) {
		BootstrapDialog.alert("请输入正确格式的超链接");
		flag = false;
		return;
	}
	var sNewContent = $('#sNewContent').val();
	if (ChkUtil.isNull(sNewContent)) {
		BootstrapDialog.alert("请输入介绍");
		flag = false;
		return;
	}
	if (flag) {
		$("#sMediaImage").val(sLogo + "|" + sLogoHover);
		$('#brand').submit();
	}
}