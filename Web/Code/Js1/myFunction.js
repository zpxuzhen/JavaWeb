
function jiSuan(num1,num2,operator){
var res=0;
if(operator=="+"){
res=num1+num2;
}
else if(operator=="-"){
res=num1-num2;
}
else if(operator=="*"){
res=num1*num2;
}
else if(operator=="/"){
res=num1/num2;
}
return res;
}

function abc2(){
	//在JS中有一个 arguments可以访问所有传入的值
	//window.alert(arguments.length);//得到参数的个数
	//遍历所有的参数
var sum=0;
for(var i=0;i<arguments.length;i++){
sum=arguments[i]+sum;
}
window.alert(sum);
return sum;
}

