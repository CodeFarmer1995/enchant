function inputCheck() {
    var strPasswd = document.getElementById("inputPassword").value;
    var strMd5Passwd = md5(strPasswd);
    document.getElementById("md5Password").value = strMd5Passwd;
}
