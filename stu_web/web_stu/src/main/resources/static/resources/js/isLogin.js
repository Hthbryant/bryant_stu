$.ajax({
    type:"post",
    url:"http://localhost:16666/sso/isStuLogin",
    success: function (data) {
        if(data.code=='0000'){
            alert("您已经登录");
            $("#s_name").html(data.data.name);
        }else{
            alert("您未登录");
        }
    },
    dataType:"json"
})