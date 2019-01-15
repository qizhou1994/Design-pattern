# Design Practice
用于设计模式学习与练习

## 中介者设计模式
* [中介者模式](https://github.com/qizhou1994/Design-pattern/tree/master/中介者模式/code)
`不同对象之间并无直接联系，而是通过中介者去统一处理。`  
在本例子中，中介者就是一个代理相亲平台，而其他不同的相亲对象，通过相亲平台来说出自己的要求。
这只是一个简单的示例，让大家知道其关系是中介者去处理。  
打印:  
msg = blindDater1 ,相亲者 blindDater1= BlindDaters{agencys=code.one.imp.AgencysImp@3d4eac69}  
msg = blindDater2 ,相亲者 blindDater2= BlindDaters{agencys=code.one.imp.AgencysImp@3d4eac69}
打印日志可以看到代理平台是相同的,在处理多个相亲对象的时候，只是增加更多的相亲对象，而相亲者的身份都不会变（BlindDaters），
会变的只有代理平台(代码会变，添加逻辑判断)。

## 解释器设计模式
* [解释器模式](https://github.com/qizhou1994/Design-pattern/tree/master/解释器模式/code)
`定义，给定一个语言，定义他的文法的一种表示，病定义一个解释器，这个解释器使用该表示来解释语言中的句子。`  
在这个设计模式的代码中  
one示例：包含的就是最基础的，AbstractExpress,context作为全局参数，并不干扰解释内容，而TerminalExpression与NotTerminalExpression才是用来想要去解释内容的。  
music示例：包含的是一个更为直接显示的，讲一段演奏内容，大意则是根据其中的高低标示，解释其中带有的高低音区间。  
这里只是简单的做了高低音数字的区分，当情况较多的时候可以写入多个解释器，并且在客户端中优化通过反射与简单工厂优化客户端代码。 

## 访问者设计模式
* [访问者模式](https://github.com/qizhou1994/Design-pattern/tree/master/访问者模式/code)
`定义，表示一个作用于某对象结构中的元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。`  
在这个设计模式的代码中  
one示例：是一个最简单的，通过不同的人会做出不同的反应。
two示例：是一个比较明显的例子，将不同人的行为提出来，单独去处理，类似一个访问者一样。”多个人去做出来都可以做出相同的行为“，同比一个访问者，访问多个地方。这里，行为就是访问者，男人女人就是地方被访问。男人女人的改变并不影响访问者，并且随着“地方增多，只需要在访问者中添加接口即可。”  
three示例：则是将two的基础上，进一步做了一个统一去表示访问者模式的示例。
访问者的模式其实就是想吧访问者这个模块从被访问者中抽离出来，类比系统中算法与数据结构分离。  
优点很明显，增加行为只需要添加一个新的访问者类，所有与访问者相关的行为都在一个访问者类中。

## 工厂设计模式
#### 简单工厂设计模式
* [简单工厂模式](https://github.com/qizhou1994/Design-pattern/tree/master/工厂模式/code/simple_code)
这只是工厂设计模式的初级入门，在这个简单工厂（simple_code）的设计模式中，用最常见的水果来作为示例，一个工厂可以出多种水果，每一种水果对应者一个类，而都是通过`同一个工厂`创建的。

#### 工厂方法模式
* [工厂方法模式](https://github.com/qizhou1994/Design-pattern/tree/master/工厂模式/code/method)
`定义一个用于创建对象的借口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。`  
其对比简单工厂，就是在简单工厂通过一个工厂一一分类处理后再生产这一步，修改成你需要什么，则单独写一个类去用过这个类去生产水果。  
在这里就是通过`三个生产类`直接去生产水果。

#### 简单工厂对比工厂方法：
简单：通过一个工厂类去处理判断生成多个类。
方法：需要什么就单独写一个类去生产。


## 代理模式
* [工厂模式](https://github.com/qizhou1994/Design-pattern/tree/master/代理模式/code)
`定义：为其他对象提供一种代理以控制对这个对象的访问`  
在eg中就是通过proxy代理控制对RealSubject的访问

## 建造者模式
* [工厂模式](https://github.com/qizhou1994/Design-pattern/tree/master/建造者模式/code)
`定义：将一个复杂对象的构建与他的表示分离，使得同样的构建过程可以创建不同的表示。`  
在template中：Builder是建造者需要建造对象的接口。
ConcreateBuilder是真正的建造者去实现建造对象的接口，且建造对象。
Director在这里只是用于去通过建造者去建造对象，起指挥的作用。 

