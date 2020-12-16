$(function(){
	$.ajax({
		url:"emps.json",
		type:"get",
		data:{
			
		},
		success:function(resp){
			// console.log(resp)
			// let list=resp
			// let temp=""
			// for(let one of list){
			// 	temp+=`
			// 	<tr>
			// 	<td>${one.empno}</td>
			// 	<td>${one.ename}</td>
			// 	<td>${one.hiredate}</td>
			// 	<td>${one.sal}</td>
			// 	</tr>
			// 	`
			// }
			// $("#empInfo tbody").append(temp)
			
			let emps=resp
			$table=$("#empInfo")
			for(i in emps){
				let emp=emps[i]
				$tr=$("<tr></tr>")
				for(j in emp){
					$td=$("<td></td>")
					$td.text(emp[j])
					$tr.append($td)
				}
				$table.append($tr)
			}
			
		}
	})
})