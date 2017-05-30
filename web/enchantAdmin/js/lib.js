function isFunction(fn) {
    return Object.prototype.toString.call(fn) === "[object Function]";
}

function setCookie (key, value, expires) {
    //expires 使用秒
    var objDate = new Date();
    objDate.setTime(objDate.getTime() + Number(expires) * 1000);
    document.cookie = key+"="+value+";expires="+objDate.toGMTString();
}
function getCookie(key){
    var arrData = document.cookie.match(new RegExp("(^| )"+key+"=([^;]*)(;|$)"));
    if(arrData != null){
        return (arrData[2]);
    }else{
        return "";
    }
}
function delCookie(key){
    var objData = new Date();  
    objData.setTime(objData.getTime() - 1);  
    var value = getCookie(key);  
    if(value != null){
        document.cookie = key + "="+value+";expires="+objData.toGMTString();
    }
}
function setLocalStorage(key, value) {
    localStorage.setItem(key, value);
}
function getLocalStorage(key) {
    return localStorage.getItem(key);
}
function delLocalStorage(key) {
    localStorage.removeItem(key);
}
function clearLocalStorage() {
    localStorage.clear();
}

//sessionStorage


(function() {
    var initializing = false;
    var superPattern = /xyz/.test(function() {xyz;})? /\b_super\b/ : /.*/;
    
    Object.subClass = function(properties) {
        var _super = this.prototype;
        
        initializing = true;
        var proto = new this();
        initializing = false;
        
        for(var name in properties) {
            proto[name] = typeof properties[name] == "function" &&
                          typeof _super[name]  == "function" &&
                          superPattern.test(properties[name])?
                        (function(name, fn) {
                            return function() {
                                var tmp =this._super;
                                this._super = _super[name];
                                var ret = fn.apply(this,arguments);
                                this._super = tmp;
                                return ret;
                            };
                        })(name,properties[name]): properties[name];
        }
        
        function Class() {
            if(!initializing && this.init){
                this.init.apply(this, arguments);
            }
        }
        Class.prototype = proto;
        Class.constructor = Class;
        Class.subClass = arguments.callee();
        return Class;
    };
})();
