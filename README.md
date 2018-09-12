# testviewpagerfragment
viewpaper中的fragment间通信

第一种方法：定义接口，然后在mainactivity中实现，之后在fragment中创建接口变量然后在onAttach方法中实例化，之后正常调用；

第二种方法：在fragment中创建广播，通过广播进行传递；

第三种方法：在Mainactivity中创建list，把实例化的fragment添加进list中，然后在fragment中通过getactivity方法获取实例，然后在list中的fragment实例，
    然后通过public方法传递数据；
