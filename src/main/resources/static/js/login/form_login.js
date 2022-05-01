
// var username_input = document.getElementById('username'),
    password_input = document.getElementById('password');
  /* show the password */
  var show_pass = document.getElementById("show_or_hidden");
  console.log(show_pass);
  show_pass.onclick = function() {
      if (password_input.getAttribute('type') === "password" ) {
          password_input.setAttribute('type', 'text');
          show_pass.style.opacity = '1';
      } else {
          password_input.setAttribute('type', 'password');
          show_pass.style.opacity = '0.6';
      }
  };