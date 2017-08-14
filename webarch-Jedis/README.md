# Java Redis 学习
study how to use jedis to operate redis database


### 预启动
redis  
启动redis server(进入目录D:\DevProgrm\Redis-x64-3.2.100)：redis-server.exe [redis.conf]  
客户端：redis-cli.exe [-h 192.168.10.61 -p 6379]  


### Redis相关 
1. 启动客户端后，输入ping命令，返回pong
1. 如果需要设置密码，则启动server时需要加上配置文件（redis-server.exe redis.conf），配置文件里加上登录密码 requirepass *passowrd*
1. 登录时需要输入命令auth password
