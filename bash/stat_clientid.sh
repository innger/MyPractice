#!/usr/bin/env bash

#usage sh stat_clientid.sh yyyy-MM-dd

#两台cmg-server
#/home/yulong.ryl/script

path="/home/admin/cmg-server/logs"
ip=`hostname`
date=$1

grep 'Connect register client' $path/cmg-server.log.$date | grep -v cmg_router_client_id | awk '{print $9}' | sort | uniq > ~/script/cmg-server.log.$date.$ip

#跳板机
#/home/yulong.ryl/script

hosts="cmg-server010178093026.et2 cmg-server010178093223.et2"
servers="10.178.93.26 10.178.93.223"
user="yulong.ryl"
date=$1

if [ -z "$date" ]; then
    date=`date -d "yesterday" +%Y-%m-%d`
fi
echo "$date"

for server in $hosts
do
   echo "$server"
   ssh -l $user $server "sh ~/script/stat_clientid.sh $date"
   rsync -zvrtopg -e "ssh" $user@$server:~/script/cmg-server.log.$date.$server ./
done

echo "####################"
dau=`cat ./cmg-server.log.$date* | sort | uniq | wc -l`
echo "$dau"
curl "http://10.180.16.211:7001/ws/cmg/mail?date=$date&dau=$dau"


#统计当前连接数
hosts="cmg-server010178093026.et2 cmg-server010178093223.et2"
servers="10.178.93.26 10.178.93.223"
user="yulong.ryl"
date=$1

for server in $servers
do
    echo "$server"
    ssh -l $user $server "sh ~/script/stat_conns.sh"
    echo "#################"
done

#统计当前连接数
grep 'Connect register client' /home/admin/cmg-server/logs/cmg-server.log | tail -1 | awk '{print $1" "$2"\t"$NF}'