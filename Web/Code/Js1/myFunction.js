
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
	//��JS����һ�� arguments���Է������д����ֵ
	//window.alert(arguments.length);//�õ������ĸ���
	//�������еĲ���
var sum=0;
for(var i=0;i<arguments.length;i++){
sum=arguments[i]+sum;
}
window.alert(sum);
return sum;
}

