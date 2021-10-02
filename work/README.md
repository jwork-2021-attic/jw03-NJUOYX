# W03

## 1.example 代码理解
**和W02不同，W03使用了java类的动态创建特性，使用字节码创建排序类。**
### 1. 结构
```encoder```包包含了将类字节码使用隐写术写进一张图片的方法和从使用该隐写方法创建的隐写术图中获取类字节码的方法；```classloader```包并且提供了类加载器，使得调用者可以通过传入隐写术图位置参数创建一个类；主函数调用了这些包提供的方法，能够读取隐写术图，并创建一个实现了Sort接口的类对象。

### 2. encoder Package
#### 1. SteganographyEncoder Class
这个类提供的两类方法，分别负责将类字节码隐写到图片中、从隐写图中提取类字节码。其隐写方法是这样的：以数组的方式读取图片的像素数据，将每个字节码按参数放在每个像素数据的低n位，在n较小时，被修改的图片在人眼看来基本没有变化。同样的，在读取隐写术图时，也根据隐写方法，读取出藏在像素低位的类字节码数据。

#### 2. SteganographyFactory Class
这个类用作工厂类，使得使用```encoder``包的用户不用自己创建```SteganographyEncoder```类，仅仅调用工厂类提供的一个方法，就能得到想要的结果。在这里，工厂类提供了将类的java源码文件隐写到一张目标图片的方法。该方法首先将java源码文件编译成字节码文件，然后创建默认的```SteganographyEncoder```类进行隐写，最终将得到的图像数据写入目标文件。同时，这个类也提供了自己的main函数，使得该包可以被直接执行。


### 3. classloader Package
这个类继承了java的```ClassLoader```类，并重载了```findClass```方法，通过读取隐写术图，得到图片像素数据，然后用```SteganographyEncoder```类解除隐藏的类字节码，得到目标类```Class<?>```，这里使用了泛型，因此，得到返回值之后，要进行cast。


## 2. 隐写术图
### 1. InsertSorter:
![InsertSorter.png](example.InsertSorter.png)


### 2. MergeSorter:
![MergeSorter.png](example.MergeSorter.png)


## 3. 结果
### 1. InsertSorter:
![insert](https://asciinema.org/a/TbsGAm1SlF6KwbDkdw9xN7dej)

### 2. MergeSorter:
![merge](https://asciinema.org/a/FHVah1I7H1uxcUqyTQxhYOFZO)


## 4. 验证同学

![insert](https://raw.githubusercontent.com/jwork-2021/jw03-Kisekis/main/example.InsertSorter.png)
结果正确