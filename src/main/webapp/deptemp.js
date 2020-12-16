$(function () {
    $("#query").click(function () {
        $.ajax({
            url:"http://localhost:8080/reportdeptemp",
            type:"post",
            data:{
                "deptno":$("#depts").val(),
                "min":$("#min").val(),
                "max":$("#max").val()
            },
            success:function (res) {
                var obj = JSON.parse(res)
                var result = obj.data
                var temp = ""
                // $table=$("#empsInfo")
                // for(i in result){
                //     let emp=result[i]
                //     $tr=$("<tr></tr>")
                //     for(j in emp){
                //         $td=$("<td></td>")
                //         $td.text(emp[j])
                //         $tr.append($td)
                //     }
                //     $table.append($tr)
                // }
                for (let de of result) {
                    console.log(de)
                    temp += `
                    <tr>
                    <td>${de.dname}</td>
                    <td>${de.ename}</td>
                    <td>${de.loc}</td>
                    <td>${de.sal}</td>
                    </tr>
                    `
                }
                $("#empsInfo tbody").append(temp)
            }
        })

    })

    $.ajax({
        url:"http://localhost:8080/deptfindall",
        type:"get",
        success:function (res) {
            var result=JSON.parse(res);
            var depts=result.data
            for(i in depts){
                var dept=depts[i]
                $optionNode=$("<option></option>")
                $optionNode.text(dept.dname)
                $optionNode.val(dept.deptno)
                $("#depts").append($optionNode)
            }
        }
    })
})