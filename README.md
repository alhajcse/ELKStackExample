# ELKStackExample
ELKStackExample

![ELK](https://i.imgur.com/uMIuOAM.png)


## Requirements

- Elasticsearch
- logstash
- kibana[https://www.elastic.co/downloads/kibana]
- Spring Boot 

## Installation process
- Download required files
- add the log file path on application.yml inside your Spring Boot application
  ```
  logging:
  file:
    name: /home/user/log/xxx.log
  ```

- create logstash.conf file. prefered location is `/home/user/log` (on same path of logfile)
  ```
  input {
   file {
       path => "/home/user/log/xxx.log"
       start_position => "beginning"
     }
   }
   output{
      stdout{
        codec=>rubydebug
      }
      elasticsearch{
         hosts => ["localhost:9200"]
      }
   }
  ```
## Now elasticsearch 
- Unzip elasticsearch and goto the `bin` folder and open terminal. run the below command
`/Downloads/elasticsearch-7.11.2-linux-x86_64/elasticsearch-7.11.2/bin$ ./elasticsearch`

## Kibana 
- Unzip kibana and goto the `bin` folder and open terminal. run the below command
`/Downloads/kibana-7.11.2-linux-x86_64/bin$ ./kibana`

## Logstash 
- Unzip elastic search and goto the `bin` folder and open terminal. run the below command
- past `logstash.conf` file in /Downloads/logstash-7.11.2-linux-x86_64/logstash-7.11.2/bin path
`/Downloads/logstash-7.11.2-linux-x86_64/logstash-7.11.2/bin$ ./logstash -f logstash.conf`
