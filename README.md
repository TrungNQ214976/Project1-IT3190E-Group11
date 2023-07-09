# Project I - Group 11 - Service log program
## Service Log: Open Source Log Analysis Program
### Description

A log analyser program with support for Apache logs, firewall iptables logs and ModSecurity logs.

---------------
### Features
- Support modify log files and directly analyse logs from server.
- Filter log data by fields and properties.
- Monitor and visualize log.
- Get log statistics and other infomations.
---------------
### Contributors
**Student:**
- [Nguyễn Hữu Duẩn 20214951](https://github.com/DuanNH214951) 
- [Nhữ Đức Minh 20214966](https://github.com/NhuDucMinh20214966)
- [Nguyễn Quốc Trung 20214976](https://github.com/TrungNQ214976)
---------------
### GUI App Design

[Balsamiq](https://balsamiq.cloud/six90ga/po6qsj0/r1EA6)

---------------
### Directory layout
Simplified directory layout
```
PROJECT_ROOT
├── Code
│   ├── ModSecurity            
│   │   ├── INSTALL.md
│   │   ├── Noi dung tim hieu
│   │   ├── README.md
│   │   └── src                       ModSecurity log source code
│   ├── apache-nginx
│   │   ├── README.md
│   │   ├── bin
│   │   │   ├── accesslog
│   │   │   └── errorlog
│   │   └── src                       Apache log source code
│   │       ├── accesslog
│   │       └── errorlog
│   ├── app
│   │   └── README.md
│   ├── iptables
│   │   ├── README.md
│   │   ├── data                      Sample iptables log files
│   │   └── iptablesLog
│   │       ├── bin
│   │       └── src                   iptables log source code
│   ├── server_optional
│   │   └── README.md
│   └── external-libs                 External libraries used
├── INSTALL.md
├── LICENSE
└── README.md 
```
