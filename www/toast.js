var toast = {
    ShowToast:function(content,length){
        cordova.exec(null, null,"Toast","toast",[content,length]);
    }
}
module.exports = toast;
