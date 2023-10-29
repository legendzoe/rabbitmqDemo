# rabbitmqDemo
rabbitmq类似生产环境的模拟(极简版本)

根据本人网上查找的资料，发现rabbitmq大部分的教程都是所谓的main方法，创建一个消费者一个生产者的作用， 这种做法只能是一知半解，看似理解了rabbitmq的使用方式，可是对于实际项目来说帮助并没有。

例如，如何通过打接口的方式，将一个调用次数很高，并发量很大的接口，通过队列的方式传入到具体的消费者中，并进行接下来的业务逻辑处理，例如存储数据库，进行cord操作等。

本项目的作用就是一个很基本的，来掩饰rabbitmq是如何以一个项目来运行的，供初学者参考和思考，
ps:因本人也是一个新手，若有不足之处欢迎大家指出来，共同进步。

![image](https://github.com/legendzoe/rabbitmqDemo/assets/66513166/82f9eb6c-50da-457e-96f3-93f3da20a600)

