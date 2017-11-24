# ESData
The Demo of Elastic&amp;Kibana

#=============================ElasticsearchConfig==================================

cluster.name: es_cluster    #集群名字
node.name: node0            #节点名字

path.data: /data1/es/data #数据存放路径

path.logs: /data1/es/logs  #日志存放路劲

network.host: 10.10.10.10 #绑定主机地址

http.port: 9200  #地址端口号

#discovery.zen.ping.unicast.hosts:      #配置多节点,发现方式为unicast,指定master节点,方便快速定位主节点

#- 10.10.10.11

#- 10.10.10.12

#http.cors.enabled: true                #允许跨域访问   这样head插件可以访问es

#http.cors.allow-origin: "*"

action.auto_create_index: .security,.monitoring*,.watches,.triggered_watches,.watcher-history*  #自动建立x-pack索引

