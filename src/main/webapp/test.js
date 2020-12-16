$(function () {
   $("#delBtn").click(function () {
        var data=[]
       $("#testul input:checkbox:checked").each(function () {
            // alert($(this).val()+"打印了")
           data.push({empno:$(this).val()})
       })
       $.ajax({
           url:"http://localhost:8080/empdelbatch",
           type:"post",
           data:{
               empnos:JSON.stringify(data) //JSON格式传参
           },
           success:function (res) {
               console.log(res)
           }
       })
   })
})