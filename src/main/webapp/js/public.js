/**
 * Created by home on 2017/6/22.
 */
function setLocalStorage(key,value){
    var curTime = new Date().getTime();
    localStorage.setItem(key,JSON.stringify({data:value,time:curTime}));
}
function getLocalStorage(key,exp){
    var data = localStorage.getItem(key);
    var dataObj = JSON.parse(data);
    console.log(dataObj);
    if (new Date().getTime() - dataObj.time>exp) {
        localStorage.removeItem(key);
        //alert("信息已过期")
    }else{
        console.log("data="+dataObj.data);
        var dataObjDatatoJson = dataObj.data;
        return dataObjDatatoJson;
        console.log(dataObjDatatoJson);
    }
}
