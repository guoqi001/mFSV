/**
 * Created by home on 2017/6/23.
 */
var articleList;
var articles;
//获取全部商品列表 匹配商品名
var localstorage=window.localStorage;
var token=localstorage.getItem("token");
console.log(localstorage.getItem("type"));
var shipmentCode=localstorage.getItem("shipmentCode");
var outletNo=localstorage.getItem("outletNo");
$(function() {
    var headerH = $("header").height();
    $("section").css("margin-top", headerH);
    setTotle();
});

var  delive=localstorage.getItem("delive");
console.log(delive);
if(delive==1){
    $(".mask_layer").css("display","block");
}else{
    $(".mask_layer").css("display","none");
}
    $.ajax({
        url:"order/getAllProducts",
        type:"get",
        async:false,
        dataType:"json",
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("X-Access-Token", token);
        },
        success:function(data){
            console.log(data);
            if(data.status==200){
                articleList=data.articleList;
            }
            else{
                diolog_msg(data.message);
            }
        },
        err:function(data){
            diolog_msg("网络不可用");
        },
        complete:function(){

        }
    });
//产品编号名称匹配
function  articleName(articleNo){
    for(var i=0;i<articleList.length;i++){
        if(articleList[i].articleNo==articleNo){
            return articleList[i].articleName;
        }
    }
}
    //匹配价格
    $.ajax({
        url: "scheduling/getCustomerArticles",
        async: false,
        type: "get",
        dataType: "json",
        data: {
            "outletNo": outletNo
        },
        success: function (data) {
            console.log(data);
            if (data.status == 200) {
                articles=data.articles;
            } else {
                diolog_msg(data.message);
            }
        }

    });
    function articlePrice(articleNo) {
        var flag3=false;
        for (var j = 0; j < articles.length; j++) {
            if (articles[j].articleNo == articleNo) {
                return articles[j].priceListPrice;
                flag3=true;
            }
        }
        if(flag3==false){return ""}
    }
    //
    if (localstorage.getItem("type") == "COLV") {
        $.ajax({
            url: "scheduling/getFSVsalesInfoFromCOLV",
            type: "post",
            dataType: "json",
            data: {
                "shipmentCode": shipmentCode,
                "outletNo": outletNo
            },
            success: function (data) {
                var str = "";
                if (data.status == 200) {
                    console.log(data);
                    for (var i = 0; i < data.articleList.length; i++) {
                        str += ' <li class="list-group-item" salesCount="' +
                            data.articleList[i].salesCount +
                            '">' +
                            '<div class="row" >' +
                            '<div class="col-xs-3 img-ad text-center" style="padding-right:0">' +
                            '<img src="SFA_Image/sku_' +data.articleList[i].articleNo.slice(-4)+
                            '.png" alt="" onerror="imgError(this)" class="img-responsive  center-block">' +
                            '</div>' +
                            '<div class="col-xs-9">' +
                            '<div class="clearfix">' +
                            '<div class="pull-left prod_name">' +
                            articleName(data.articleList[i].articleNo.slice(-4)) +
                            '</div>' +
                            '<div class="pull-right prod_id">' +
                            data.articleList[i].articleNo.slice(-4) +
                            '</div>' +
                            '</div>' +
                            '<div class="prod_price">' +
                            '<div >￥<span>' +
                            articlePrice(data.articleList[i].articleNo.slice(-4)) +
                            '</span></div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '<div class="cart_nums clearfix">' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>销售</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan salesNum" value="' +
                            data.articleList[i].salesCount +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)"/>' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>补货</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan refillNum" value="' +
                            data.articleList[i].salesCount +
                            '" maxlength="3" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>回收</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan returnNum" value="0" maxlength="3" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'
                    }
                    $(".addprod-list").html(str);
                    setTotle();
                } else if (data.status == 400) {
                    diolog_msg(data.message)
                }

            },
            err: function () {
                diolog_msg("网络不可用");
            }
        });
    }else{
        $.ajax({
            url:"scheduling/getFSVsalesInfoFromCS",
            type: "post",
            async: false,
            dataType: "json",
            data: {
                "shipmentCode": shipmentCode,
                "outletNo": outletNo
            },
            success: function (data) {
                console.log(data);
                var str = "";
                if (data.status == 200) {
                    for (var j = 0; j < data.articleList.length; j++) {
                        str += ' <li class="list-group-item" salesCount="' +
                            data.articleList[j].salesCount +
                            '">' +
                            '<div class="row" >' +
                            '<div class="col-xs-3 img-ad text-center" style="padding-right:0">'+
                            '<img src="SFA_Image/sku_' +data.articleList[j].articleNo.slice(-4)+
                            '.png" alt="" onerror="imgError(this)" class="img-responsive  center-block">' +
                            '</div>' +
                            '<div class="col-xs-9">' +
                            '<div class="clearfix">' +
                            '<div class="pull-left prod_name">' +
                            articleName(data.articleList[j].articleNo.slice(-4)) +
                            '</div>' +
                            '<div class="pull-right prod_id">' +
                            data.articleList[j].articleNo.slice(-4) +
                            '</div>' +
                            '</div>' +
                            '<div class="prod_price">' +
                            '<div >￥<span>' +
                            articlePrice(data.articleList[j].articleNo.slice(-4)) +
                            '</span></div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '<div class="cart_nums clearfix">' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>销售</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan salesNum" value="' +
                            data.articleList[j].actSalesCount +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>补货</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan refillNum" value="' +
                            data.articleList[j].refillCount +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>回收</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan returnNum" value="' +
                            data.articleList[j].redrawCount+
                            '" maxlength="3" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'

                    }
                    $(".addprod-list").html(str);
                    setTotle();
                } else{
                    diolog_msg(data.message);
                }

            },
            err: function () {
                diolog_msg("网络不可用");
            }
        })
    }

function setTotle() {
    var s = 0;var p=0;
    $("li").each(function () {
        s+=parseInt($(this).find(".prod_price span").html()) * parseInt($(this).find(".refillNum").val());
        p+=parseInt($(this).find(".refillNum").val());
    });
    console.log(s);
    console.log(p);
    $(".addp_totle").html(s);
    $(".addp_num").html(p);

}


$(".fresh").click(function(){
//确认弹框
    if(confirm("确定刷新？")){
        $.ajax({
            url: "scheduling/getFSVsalesInfoFromCOLV",
            type: "post",
            dataType: "json",
            data: {
                "shipmentCode": shipmentCode,
                "outletNo": outletNo
            },
            success: function (data) {
                console.log(data);
                var str = "";
                if (data.statue == 200) {
                    for (var i = 0; i < data.articleList; i++) {
                        str += ' <li class="list-group-item"  salesCount="' +
                            data.articleList[i].salesCount +
                            '">' +
                            '<div class="row" >' +
                            '<div class="col-xs-3 img-ad text-center" style="padding-right:0">' +
                            '<img src="SFA_Image/sku_' +data.articleList[i].articleNo.slice(-4)+
                            '.png" alt="" onerror="imgError(this)" class="img-responsive  center-block">' +
                            '</div>' +
                            '<div class="col-xs-9">' +
                            '<div class="clearfix">' +
                            '<div class="pull-left prod_name">' +
                            articleName(data.articleList[i].articleNo.slice(-4)) +
                            '</div>' +
                            '<div class="pull-right prod_id">' +
                            data.articleList[i].articleNo.slice(-4) +
                            '</div>' +
                            '</div>' +
                            '<div class="prod_price">' +
                            '<div >￥<span>' +
                            articlePrice(data.articleList[i].articleNo.slice(-4)) +
                            '</span></div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '<div class="cart_nums clearfix">' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>销售</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan salesNum" value="' +
                            data.articleList[i].salesCount +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>补货</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan refillNum" value="' +
                            data.articleList[i].salesCount +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>回收</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan returnNum" value="0" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'
                    }
                    $(".addprod-list").html(str);
                    setTotle();
                } else if (data.status == 400) {
                    diolog_msg("无可用数据")
                }

            },
            err: function () {
                diolog_msg("网络不可用");
            }
        });
    }
});

//默认图片
function imgError(that){
    console.log("test");
    that.src="images/sku_no.png";
}
//模态框
var prod_ids=[];
// $(document).ready(function(){
    $(".circle_red").click(function(){
        $('#myModal').modal();
        $("li").each(function(){
            var prod_id=$(this).find(".prod_id").html();
            prod_ids.push(prod_id);
        });
        console.log(prod_ids);

    });
    $(".addProduct").click(function(){
        console.log("点击添加产品");
        $("#identifier1").bind("input propertychange",function(){
            $("#msg1").html("");
        });
        var addp="";
        var productNo=$(this).parent().parent().find("#identifier1").val();
        var flag4=true;
        if(productNo==""){
            flag4=false;
            $("#msg1").html("产品编号不能为空");
        }else{
            flag4=true;
        }
        for(var s=0;s<prod_ids.length;s++){
            if(parseInt(prod_ids[s])==productNo){
                console.log("11");
                // $("#msg1").html("已添加");
                diolog_msg("已添加");
                flag4=false;
            }
        }
        console.log(productNo);
        if(flag4){
                console.log(productNo);
                var flag=false;
                for(var l=0;l<articleList.length;l++){
                    if(articleList[l].articleNo==productNo){
                        flag=true;
                        addp= ' <li class="list-group-item" >' +
                            '<div class="row" >' +
                            '<div class="col-xs-3 img-ad text-center" style="padding-right:0">' +
                            '<img src="SFA_Image/sku_' +articleList[l].articleNo+
                            '.png" alt="" onerror="imgError(this)" class="img-responsive  center-block">' +
                            '</div>' +
                            '<div class="col-xs-9">' +
                            '<div class="clearfix">' +
                            '<div class="pull-left prod_name">' +
                            articleName(articleList[l].articleNo) +
                            '</div>' +
                            '<div class="pull-right prod_id">' +
                            articleList[l].articleNo+
                            '</div>' +
                            '</div>' +
                            '<div class="prod_price">' +
                            '<div >￥<span>' +
                            articlePrice(articleList[l].articleNo) +
                            '</span></div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '<div class="cart_nums clearfix">' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>销售</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan salesNum" value="' +
                            0 +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)"/>' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>补货</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan refillNum" value="' +
                            0 +
                            '" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)"/>' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '<div class="pull-left" style="width:33.2%">' +
                            '<span>回收</span>' +
                            '<div class="cart_num">' +
                            '<button class="jian_button"><img src="images/icon_jian.png" alt="" class="img-responsive"></button>' +
                            '<input type="text" class="text-center prod_dan returnNum" value="0" maxlength="2" onkeyup="onlyNum(this)" onblur="returnK(this)">' +
                            '<button class="jia_button"><img src="images/icon_jia.png" alt="" class="img-responsive"></button>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'
                    }
                }
                $(".addprod-list").append(addp);
                // $(".jia_button").on("click",function () {
                //     var cart_num = parseInt($(this).prev().val());
                //     $(this).prev().val(++cart_num);
                //     setTotle();
                // });
                //
                // $(".jian_button").on("click",function () {
                //     var cart_num = parseInt($(this).next().val());
                //     cart_num > 0 && $(this).next().val(--cart_num);
                //     setTotle();
                // });
                setTotle();
                $('#myModal').modal('hide');
            // }
            if(flag==false){
                $("#msg1").html("请输入正确的产品编号");

            }
        }
    });
$('#myModal').modal('hide');
    $(".jia_button").on("click",function () {
        var cart_num = parseInt($(this).prev().val());
        $(this).prev().val(++cart_num);
        setTotle();
    });

    $(".jian_button").on("click",function () {
        var cart_num = parseInt($(this).next().val());
        cart_num > 0 && $(this).next().val(--cart_num);
        setTotle();
    });


$(".salesNum").bind("input propertychange",function(){
    setTotle();
});
//输入框只能输入数字，默认为0
function onlyNum(that){
    that.value=that.value.replace(/\D/g,"");
}
function returnK(that){
    console.log(that.value);
    if(that.value==""){
        that.value=0;
    }
}
//提交订单
$('.submit_order').click(function(){
    Date.prototype.pattern=function(fmt) {
        var o = {
            "M+" : this.getMonth()+1, //月份
            "d+" : this.getDate(), //日
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
            "H+" : this.getHours(), //小时
            "m+" : this.getMinutes(), //分
            "s+" : this.getSeconds(), //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S" : this.getMilliseconds() //毫秒
        };
        var week = {
            "0" : "/u65e5",
            "1" : "/u4e00",
            "2" : "/u4e8c",
            "3" : "/u4e09",
            "4" : "/u56db",
            "5" : "/u4e94",
            "6" : "/u516d"
        };
        if(/(y+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        if(/(E+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
        }
        for(var k in o){
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    };
    var TodayDate = new Date();
    var startDate=TodayDate.pattern("yyyyMMddhhmmss");
    console.log(startDate);
    var articleList=[];//
    var machineNum= parseFloat(localstorage.getItem("size_no"));//码表数
    var fsvDeposit=parseFloat(localstorage.getItem("pettycash"));//备用金
    var refillType=parseInt(localstorage.getItem("refillType"));//补货数
    var payList=JSON.parse(localstorage.getItem("payList"));
    var periodId="";
    if(localstorage.getItem("periodId")!=null){
        periodId=localstorage.getItem("periodId");
        console.log(localstorage.getItem("periodId"));
    }
    var deliveryDate=startDate;
    var lastDeliveryDate="";
    if(localstorage.getItem("lastDeliveryDate")!=null){
        lastDeliveryDate=localstorage.getItem("lastDeliveryDate")+"000000";
    }
    lastDeliveryDate=lastDeliveryDate.replace(/[\s\-\:\.]/ig,"").substring(0,14);
    console.log(lastDeliveryDate);
    var photoList=JSON.parse(localstorage.getItem("photoList"));
    console.log(photoList);
    console.log(payList);
    localstorage.removeItem("size_no");
    localstorage.removeItem("pettycash");
    localstorage.removeItem("refillType");
    localstorage.removeItem("payList");
    localstorage.removeItem("periodId");
    localstorage.removeItem("lastDeliveryDate");
    localstorage.removeItem("photoList");
    // console.log($("li"));
    $("li").each(function(){
        var articleNo=$(this).find(".prod_id").html();
        var articleName=$(this).find(".prod_name").html();
        var reaSalesNum=parseInt($(this).find(".salesNum").val());
        var refillNum=parseInt($(this).find(".refillNum").val());
        var returnNum=parseInt($(this).find(".returnNum").val());
        var salesCount=0;
            if($(this).attr("salesCount")!=null){
                salesCount=$(this).attr("salesCount");
            };
        var article={
            "articleNo":articleNo,
            "articleName":articleName,
            "salesNum": parseInt(salesCount),
            "refillNum": refillNum,
            "returnNum":returnNum,
            "reaSalesNum":reaSalesNum
        };
        articleList.push(article);
    });
    console.log(articleList);
    var data={
        "shipmentCode":shipmentCode,
        "outletNo": outletNo,
        "machineNum": machineNum,
        "fsvDeposit": fsvDeposit,
        "refillType": refillType,
        "articleList": JSON.stringify(articleList),
        "periodId": periodId,
        "payList": JSON.stringify(payList),
        "deliverDate":deliveryDate,
        "lastDeliverDate": lastDeliveryDate,
        "photoList": JSON.stringify(photoList)
    };

    $.ajax({
        url:"scheduling/submitrefillDataToCs",
        type:"post",
        dataType:"json",
        data:data,
        success:function(data){
            console.log(data);
            if(data.status==200){
                data.result==0 && diolog_msg(data.message);
                // window.location.href="customer_list.html?shipmentCode="+shipmentCode;
            }else if(data.status==500){
                diolog_msg(data.message);
            }else{
                diolog_msg("网络不可用");
            }

        },
        error:function(){
            diolog_msg("网络不可用");
        }

    })
});