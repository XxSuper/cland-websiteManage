


var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	
           $('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            errorLabelContainer:'#alert-error',
	            rules: {
	            	j_username: {
	                    required: true
	                },
	                j_password: {
	                    required: true
	                }
	            },

	            messages: {
	            	j_username: {
	                    required: "用户名必须填写"
	                },
	                j_password: {
	                    required: "密码必须填写"
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('.login-form')).show();
	            },

	          

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	              //  error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                //window.location.href = "index.html";
	            }
	        });

	       


	        $.backstretch([
		       ctx + "/js/bootstrap/media/image/bg/1.jpg",
		       ctx +"/js/bootstrap/media/image/bg/2.jpg",
		       ctx +"/js/bootstrap/media/image/bg/3.jpg",
		       ctx +"/js/bootstrap/media/image/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();