#!/bin/bash

file=/home/hari/init.sh
if [ ! -f "$file" ]
then
	echo "$0: file '${file}' not found: Exiting"
	exit
else
	echo "File  Found: proceeding"
fi
echo "vikas"

#!/bin/bash
#logging into loader server
ssh -tt $1 << EOF
#checking the files in the respective location loader server
ls /home/hari/VISION/INIT/loader_automation/ | grep test.ctl > /dev/null

if [ $? -eq 0 ]
then
    echo -e "Found file"
	#copying files to user selected instance location
	case $2 in
	"EAST" )   cp /home/hari/VISION/INIT/loader_automation/test.ctl /home/hari/VISION/INIT/loader_automation/ctl_east ;;
    "WEST" )   cp /home/hari/VISION/INIT/loader_automation/test.ctl /home/hari/VISION/INIT/loader_automation/ctl_west ;;
	"NORTHEAST" )   cp /home/hari/VISION/INIT/loader_automation/test.ctl /home/hari/VISION/INIT/loader_automation/ctl_north ;;
	"B2B" )   cp /home/hari/VISION/INIT/loader_automation/test.ctl /home/hari/VISION/INIT/loader_automation/ctl_b2b ;;
	  *) echo "Sorry, I can not get a $rental rental  for you!";;
esac
    
else
#if not found we will show the alert message
    echo -e "File is not in there"
fi
#we have to change the location based user instance
   case $2 in
	"EAST" )   cd /home/hari/VISION/INIT/$3/cassandraloader/VISE;;
    "WEST" )   cd /home/hari/VISION/INIT/$3/cassandraloader/VISW ;;
	"NORTHEAST" )   cd /home/hari/VISION/INIT/$3/cassandraloader/VISNE ;;
	"B2B" )   cd /home/hari/VISION/INIT/$3/cassandraloader/VISB;;
	  *) echo "Sorry, I can not get a  rental for you";;
   esac
   #./generate_cassandra_automation_command_ctl.sh>ctl.sh 
   #chmod 777 ctl.sh
   #nohup ./ctl.sh &
   case $2 in
	"EAST" )   cd /home/hari/VISION/$2/cassandraloader/VISE/logs;;
    "WEST" )   cd /home/hari/VISION/$3/cassandraloader/VISW/logs ;;
	"NORTHEAST" )   cd /home/hari/VISION/$3/cassandraloader/VISNE/logs ;;
	"B2B" )   cd /home/hari/VISION/$3/cassandraloader/VISB/logs;;
	  *) echo "Sorry, I can not get a  rental for you";;
   esac
   #grep –i done filename***.out
   cd /home/hari/VISION/INIT/loader_automation/
   #rm *.ctl
exit
EOF