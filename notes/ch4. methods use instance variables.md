# ch4. methods use instance variables

> State affects behavior，behavior affects state.

## 实例变量和方法

对象有状态和行为两种属性，也就是说有实例（non-static）变量和方法。

面向对象的重点：行为会根据状态来改变。也就是说同一个类的每个对象能够有不同的防范行为。任一类都有相同的方法，但是方法可以根据实例变量的值来表现不同的行为。

## 方法参数

可能会用到实参（arguments）或形参（parameters）来调用传给方法的参数。

方法会使用形参。调用的方法会传入实参。（A caller passes arguments. A method takes parameters.）

也就是或调用方法的时候会传入实参，实参会传给形参。形参会作为变量，在方法中进行相关的操作。同时，如果方法中写了形参，调用的时候一定要写入相对于的实参，才能够调用该方法。

## 方法返回值

方法可以有返回值，每个方法都声明返回的类型，`void` 是代表无返回值。如果一个方法声明中有返回值，就必须返回所对应的类型值。（或是声明类型兼容的值， we will talk about it more in ch7 and ch8）

## 多个参数

方法可以有多个参数，在声明的时候要用逗号分开。传入也是逗号分开，保证顺序，数量和类型与方法中的形参一致。

```java
void go() {
    TestStuff t = new TestStuff();
    t.takeTwo(12, 34);
}

void takeTwo(int x, int y) {
    int z = x + y;
    System.out.println("Total is " + z);
}
```

也可以将变量当作参数传入，只要类型相符就可以。

```java
void go() {
    int foo = 7;
    int bar = 3;
    t.takeTwo(foo, bar);
}

void takeTwo(int x, int y) {
    int z = x + y;
    System.out.println("Total is " + z);
}
```

Java是通过值传递，也就是拷贝（copy）传递。

```java
// 声明一个类型为int的x变量，并赋值7.代表7的二进制数会放进x的变量中
int x = 7;

// 声明一个有int参数的方法，参数名称为z
void go(int z) { }

// 以x为参数传入go()方法中。意味x的二进制数被拷贝进z中
foo.go(x);
void go(int z) {
    z = 0;
}

// 方法中 z = 0，实际x的值不会改变，因为传给z 的是个拷贝。方法无法改变调用的一方传入的参数
```

比如c盘一个word文档，你拷贝进d盘，然后你在d盘的word文档中改变内容，实际上c盘那个word文档并不会被改变。两者没有连接关系。

## 参数和返回值

Q: 如果传入的参数是对象的话会是怎样？

A: Java中所传递的所有东西都是值，**Everthing。**But…value means bits inside the variable.(值是指变量内部的位数)。Remember：不要把对象塞进变量里；变量是一个远程控制——对一个对象的引用。因此，如果你把一个对象的引用传递到一个方法中，也就是在传递一个远程控制的副本。

Q: 方法能声明多个返回值吗？

A:不能，只能声明一个返回值。返回多个，可以考虑使用数组的形式。

Q: 一定要返回所声明的类型吗？

A: 可以返回比声明的类型容器小的类型。

Q: 忽略返回值？

A: 可以，使用void，代表你只想要它的行为而不是返回值。void类型代表不返回任何东西，无返回值。

### BULLET POINT:

- 类定义变量和方法
- 对象的行为者是方法
- 方法可根据实例变量表示不同行为
- 方法可使用单参或形参

## Getter 和 Setter

Getter是返回实例变量的值，Setter是取一个参数赋值给实例变量。

调用方法传入实参，实参传递给方法中的形参，形参传给类中的实例变量。

Getter必须返回一个类型值。

## 封装 （Encapsulation）

由于不封装会造成数据或信息的泄露。所以需要创建Setter方法给所有的实例变量，在由Getter方法来获取值。需要通过Setter来设定变量而不是直接存取。Setter方法里可以设置条件等。Setter能够检查参数并判断是否可以执行，退回不合理的值，抛出Exception等。

```java
d.height = 50;
d.setHeight(50);
```

任何可以使用特定值的地方，都可以使用返回该类型的方法调用。

### 数据隐藏

隐藏数据通过`public` 和`private` 两个存取修饰符（access modifier）。

### 封装基本原则：

> 将实例变量标记为私有的，并提供公有的getter和setter方法来控制存取的动作。

将实例变量使用private修饰，getter和setter方法使用public修饰。

## 数组中对象的行为

数组中的对象和其他对象一样。

存取方式：

```java
// 声明Dog数组
Dog[] pets;
pets = new Dog[7];

// 创建两个Dog元素对象并赋值数组前两个元素
Dog[0] = new Dog();
Dog[1] = new Dog();

// 调用两个Dog对象的方法
pets[0].setSize(30);
int x = pets[0].getSize();
pets[1].setSize(80);
int y = pets[1].getSzie();
```

## 实例变量&局部变量

### 声明和初始化实例变量

实例变量永远都有默认值，如果没有明确赋值个实例变量，或是没有调用Setter方法，实例变量就是默认值。

### 实例变量与局部变量的差别

- 实例变量声明在类内而不是方法内

```java
class Horse {
    private double height = 15.2;
    private String breed;
}
```

- 局部变量是声明在方法中

```java
class AddThing {
    int a;
    int b = 12;
    
    public int add() {
        int total = a + b;
        return total;
    }
}
```

- 局部变量咋使用前必须初始化

```java
class Foo {
    public void go() {
        int x;
        int z = x + 3;  // 无法编译，编译器会提醒没有初始化。
    }
}
```

### 变量的比较

使用`==` 可以比较任何类型的两个变量，它只是比较其中的字节组合（二进制数）。

```java
int a = 3;
byte b = 3;
if(a == b){ // true }
```

使用== 判断两个引用是否时同一个对象。

```java
Foo a = new Foo();
Foo b = new Foo();
Foo c;
if(a == b) { // false}
if(a == c) { // true}
if(b == c) { // true}

// 由于字节组合相等，所以使用==会返回值
```

使用== 来比较基本数据类型，或者判断两个引用是否时同一个数据类型。使用equal() 判断两个对象是否在意义上相等。（像是两个String对象是否带有相同的字节组合）