RocketMQ官方文档：https://gitee.com/apache/rocketmq/tree/develop/docs/cn

# 主流MQ对比
| 特性             | ActiveMQ                | RabbitMQ                    | RocketMQ                                                           | Kafka                                                                           |
|----------------|-------------------------|-----------------------------|--------------------------------------------------------------------|---------------------------------------------------------------------------------|
| 单机吞吐量          | 万级，比RocketMQ、Kafka低一个量级 | 同ActiveMQ                   | 10万级，支撑高吞吐                                                         | 10万级，高吞吐，一般配合大数据类的系统进行实时数据计算、日志采集等场景                                            |
| topic数量对吞吐量的影响 |                         |                             | topic可以达到几百/几千的级别，吞吐量会有较小幅度的下降，这是RocketMQ的一大优势，在同等机器下，可以支撑大量的topic | topic从几十到几百个时候，吞吐量会大幅度下降，在同等机器下，Kafka尽量保证topic数量不要过多，如果要支撑大规模的topic，需要增加更多的机器资源 |
| 时效性            | ms级                     | 微妙级，这是RabbitMQ的一大特点，延迟最低    | ms级                                                                | 延迟在ms级以内                                                                        |
| 可用性            | 高，基于主从架构实现高可用           | 同ActiveMQ                   | 非常高，分布式架构                                                          | 非常高，分布式，一个数据多个副本，少数机器宕机，不会丢失数据，不会导致不可用                                          |
| 消息可靠性          | 有较低的概率丢失                | 基本不丢失                       | 经过参数优化配置，可以做到0丢失                                                   | 同RocketMQ                                                                       |
| 功能支持           | MQ领域的极其完备               | 基于erlang开发，并发能力很强，性能极好，延时很低 | MQ功能较为完善，还是分布式的，扩展性好                                               | 功能较为简单，主要支持简单的MQ功能，在大数据领域的实时计算以及日志采集被大规模使用                                      |


