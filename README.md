# ELKStackExample
ELKStackExample

![ELK](https://i.imgur.com/uMIuOAM.png)


## Requirements

- Elasticsearch
- logstash
- kibana
- Spring Boot 

## Installation process
- Download and unzip required file
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
- 
