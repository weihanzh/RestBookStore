$().ready(function() {
    $("#registerForm").validate({
        rules: {
            first_name: "required",
            last_name: "required",
            password: {
                required: true,
                minlength: 6
            },
            confirm_password: {
                required: true,
                minlength: 6,
                equalTo: "#password"
            },
            email: {
                required: true,
                email: true
            },
            country: "required",
            province: "required",
            street: "required",
            zip: "required",
            tel: {
                required: true,
                phoneUS: true
            }
        },
        messages: {
            first_name: "Please enter your firstname",
            last_name: "Please enter your lastname",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            },
            confirm_password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long",
                equalTo: "Please enter the same password as above"
            },
            email: "Please enter a valid email address",
            country: "Please enter a country",
            province: "Please enter a province",
            street: "Please enter a street",
            zip: "Please enter a zip code",
            tel:"Please enter a valid telephone number"
        }
    });
    $("#signInForm").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            email: "Please enter a valid email",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            }
        }
    });

    $("#creditForm").validate({
        rules: {
            credit_account: {
                required: true,
                creditcard: true
            },
            credit_name: "required"
        },
        messages: {
            credit_account: "Please enter a valid credit card",
            credit_name: "Please enter your name"
        }
    });
});
