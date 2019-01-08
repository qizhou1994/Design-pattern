# Design Practice
用于设计模式学习与练习

# 中介者设计模式
### 不同对象之间并无直接联系，而是通过中介者去统一处理。
在本例子中，中介者就是一个代理相亲平台，而其他不同的相亲对象，通过相亲平台来说出自己的要求。
这只是一个简单的示例，让大家知道其关系是中介者去处理
打印:
msg = blindDater1 ,相亲者 blindDater1= BlindDaters{agencys=code.one.imp.AgencysImp@3d4eac69}
msg = blindDater2 ,相亲者 blindDater2= BlindDaters{agencys=code.one.imp.AgencysImp@3d4eac69}
打印日志可以看到代理平台是相同的
在处理多个相亲对象的时候，只是增加更多的相亲对象，而相亲者的身份都不会变（BlindDaters），
会变的只有代理平台(代码会变，添加逻辑判断)。 ##
* [中介者模式](https://github.com/qizhou1994/Design-pattern/tree/master/中介者模式/code)

# 解释器设计模式
### 定义，给定一个语言，定义他的文法的一种表示，病定义一个解释器，这个解释器使用该表示来解释语言中的句子。
在这个设计模式的代码中  
one示例：  
包含的就是最基础的，AbstractExpress,context作为全局参数，并不干扰解释内容  
而TerminalExpression与NotTerminalExpression才是用来想要去解释内容的  
music示例：  
包含的是一个更为直接显示的，讲一段演奏内容，大意则是根据其中的高低标示，解释其中带有的高低音区间。
这里只是简单的做了高低音数字的区分，当情况较多的时候可以写入多个解释器，并且在客户端中优化通过反射与简单工厂优化客户端代码。 
* [解释器模式](https://github.com/qizhou1994/Design-pattern/tree/master/解释器模式/code)

