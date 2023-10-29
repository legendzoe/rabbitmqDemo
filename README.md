# rabbitmqDemo
rabbitmq类似生产环境的模拟(极简版本)

根据本人网上查找的资料，发现rabbitmq大部分的教程都是所谓的main方法，创建一个消费者一个生产者的作用， 这种做法只能是一知半解，看似理解了rabbitmq的使用方式，可是对于实际项目来说帮助并没有。

例如，如何通过打接口的方式，将一个调用次数很高，并发量很大的接口，通过队列的方式传入到具体的消费者中，并进行接下来的业务逻辑处理，例如存储数据库，进行cord操作等。

本项目的作用就是一个很基本的，来掩饰rabbitmq是如何以一个项目来运行的，供初学者参考和思考，
ps:因本人也是一个新手，若有不足之处欢迎大家指出来，共同进步。

![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/82f9eb6c-50da-457e-96f3-93f3da20a600)

项目名称为springboot-demo， (本人懒的换一个接近项目名称的名字了), 主体部分src目录下，是消息的生产者，如队列配置，创建controller， 并将消息发送出去。

红框内标注的是，mq的 消费者，也是消息接收者，
![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/a71f0556-cfe2-4d62-8691-038fb9c03b94)
此处为具体的接口，通过交换机，和routingKey来指向与之匹配的 消息接收者(消费者)，并发送数据"Hello from RabbitMQ!"

![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/2657b0f9-78a0-40d2-8a51-65cfca990724)
此处是调用成功后的截图。

紧接着，启动消费者application， 和生产者application之后，
通过打接口，生产者生产一条数据并发送给消费者
![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/5a90e6a9-3d5b-4c7a-af55-b843ae21a6de)
在消费者控制台里可以看到，具体接受到的消息
![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/bf0fe325-bdfe-4910-ba3e-c48678d960ec)

至此，一个通过交换机发送的，数据从生产到运输到消费， 就全部完成了， 
剩下需要做的就是具体的业务了。

项目比较简单，只是一个从网上所谓的main方法过度到实际开发应用当中，(这里要吐槽一下中文教程里面的各种杂乱的教程，main方法的体现可以理解思路，但是对项目实战一点用也没有。)
欢迎大家指出不足之处，若项目有问题，请告知我，我会第一时间查看并修改。
