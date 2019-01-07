# Design Practice
用于设计模式学习与练习

###中介者设计模式
##不同对象之间并无直接联系，而是通过中介者去统一处理。
在本例子中，中介者就是一个代理相亲平台，而其他不同的相亲对象，通过相亲平台来说出自己的要求。
这只是一个简单的示例，让大家知道其关系是中介者去处理
打印:
msg = blindDater1 ,相亲者 blindDater1= BlindDaters{agencys=code.imp.AgencysImp@3d4eac69}
msg = blindDater2 ,相亲者 blindDater2= BlindDaters{agencys=code.imp.AgencysImp@3d4eac69}
打印日志可以看到代理平台是相同的
在处理多个相亲对象的时候，只是增加更多的相亲对象，而相亲者的身份都不会变（BlindDaters），
会变的只有代理平台(代码会变，添加逻辑判断)。
##
* 中介者模式
   [中介者模式] https://github.com/qizhou1994/Design-pattern.git
